package com.ipartek.formacion.ipartekify.rest;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Provider
public class ObjectMapperResolver implements ContextResolver<ObjectMapper> {
    private final ObjectMapper mapper;

    public ObjectMapperResolver() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
//        mapper.findAndRegisterModules();
//        mapper = JsonMapper.builder()
//        .findAndAddModules()
//        .build();
    }

    @Override
    public ObjectMapper getContext(Class<?> cls) {
        return mapper;
    }
}