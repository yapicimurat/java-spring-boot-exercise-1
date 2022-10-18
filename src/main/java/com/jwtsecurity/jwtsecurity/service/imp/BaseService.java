package com.jwtsecurity.jwtsecurity.service.imp;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

public class BaseService {

    //EAGER ModelMapper instance
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ModelMapper getModelMapperInstance(){
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }

}
