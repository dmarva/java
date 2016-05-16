package com.dani.examples.rest.common.orika;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

@Component
public class OrikaBeanMapper extends ConfigurableMapper implements ApplicationContextAware {

    private MapperFactory factory;
    private ApplicationContext applicationContext;

    public OrikaBeanMapper() {
	super(false);
    }

    @Override
    protected void configure(MapperFactory factory) {
	this.factory = factory;
	addAllSpringBeans(applicationContext);
    }

    @Override
    protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {

    }

    @SuppressWarnings("rawtypes")
    private void addAllSpringBeans(final ApplicationContext applicationContext) {
	Map<String, Mapper> mappers = applicationContext.getBeansOfType(Mapper.class);
	for (Mapper mapper : mappers.values()) {
	    addMapper(mapper);
	}
	Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);
	for (Converter converter : converters.values()) {
	    addConverter(converter);
	}
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addMapper(Mapper<?, ?> mapper) {
	ClassMapBuilder<?, ?> classMap = factory.classMap(mapper.getAType(), mapper.getBType())
		.customize((Mapper) mapper);

	if (mapper instanceof BaseCustomMapper) {
	    BaseCustomMapper baseCustomMapper = (BaseCustomMapper) mapper;
	    if (!baseCustomMapper.getExcludes().isEmpty()) {
		baseCustomMapper.getExcludes().forEach(field -> classMap.exclude((String) field));
	    }

	    if (!baseCustomMapper.getFields().isEmpty()) {
		baseCustomMapper.getFields().forEach((k, v) -> classMap.field((String) k, (String) v));
	    }
	}

	classMap.byDefault().register();
    }

    public void addConverter(Converter<?, ?> converter) {
	factory.getConverterFactory().registerConverter(converter);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext = applicationContext;
	init();
    }

}
