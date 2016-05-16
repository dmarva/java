package com.dani.examples.rest.api.dto.factory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.dani.examples.rest.api.dto.AbstractDto;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.MappingContextFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Esta clase se encarga de la transformación de entidades a DTOs de respuesta.
 * La obtención de los datos necesarios para la salida deberá realizarse siempre
 * antes de invocar al factory, evitando que éste realice accesos a datos.
 *
 * @param <DTO>
 * @param <E>
 */
public abstract class BaseDtoFactory<DTO extends AbstractDto, O> {

	private MapperFactory mapperFactory;
	private MappingContextFactory mappingContextFactory;

	private Class<DTO> dtoClass;
	private Class<O> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDtoFactory() {
		super();
		mapperFactory = new DefaultMapperFactory.Builder().build();
		Type genericSuperclass = getClass().getGenericSuperclass();
		ParameterizedType parametrizedType;
		if (genericSuperclass instanceof ParameterizedType) { // class
			parametrizedType = (ParameterizedType) genericSuperclass;
		} else if (genericSuperclass instanceof Class) { // in case of CGLIB
															// proxy, from i.e:
															// Mockito
			parametrizedType = (ParameterizedType) ((Class<?>) genericSuperclass).getGenericSuperclass();
		} else {
			throw new IllegalStateException("class " + getClass() + " is not subtype of ParametrizedType.");
		}
		dtoClass = (Class<DTO>) parametrizedType.getActualTypeArguments()[0];
		entityClass = (Class<O>) parametrizedType.getActualTypeArguments()[1];
		mappingContextFactory = new MappingContext.Factory();

	}

	public DTO createDto(O object, String... options) {
		MappingContext mappingContext = mappingContextFactory.getContext();

		for (String option : options) {
			mappingContext.setProperty(option, option);
		}
		DTO result = getMapperFactory().getMapperFacade().map(object, dtoClass, mappingContext);
		return result;
	}

	public O createFromDto(DTO object) {
		O result = getMapperFactory().getMapperFacade().map(object, entityClass);
		return result;
	}

	protected MapperFactory getMapperFactory() {
		return mapperFactory;
	}

}
