package com.dani.jpa.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.dani.jpa.domain.Gender;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Integer> {

    public Integer convertToDatabaseColumn(Gender attribute) {
        return (int) attribute.getValue();
    }

    public Gender convertToEntityAttribute(Integer dbData) {
        return Gender.translate((byte) dbData.intValue());
    }

}
