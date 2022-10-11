package com.jwtsecurity.jwtsecurity.service.imp;

import org.modelmapper.ModelMapper;

public class BaseService {

    //EAGER ModelMapper instance
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ModelMapper getModelMapperInstance(){
        return modelMapper;
    }

}
