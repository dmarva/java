package com.dani.examples.rest.common.orika;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ma.glasnost.orika.CustomMapper;

public abstract class BaseCustomMapper<A, B> extends CustomMapper<A, B> {

    private Map<String, String> fields;
    private List<String> excludes;

    public BaseCustomMapper() {
	super();
	fields = new HashMap<>();
	excludes = new ArrayList<>();
    }

    public void addField(String fieldA, String fieldB) {
	fields.put(fieldA, fieldB);
    }

    public Map<String, String> getFields() {
	return fields;
    }

    public void addExclude(String field) {
	excludes.add(field);
    }

    public List<String> getExcludes() {
	return excludes;
    }

}
