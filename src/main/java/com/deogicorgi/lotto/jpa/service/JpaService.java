package com.deogicorgi.lotto.jpa.service;

import com.deogicorgi.lotto.config.component.SpringContext;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public abstract class JpaService {

    public ModelMapper getMapper() {
        return SpringContext.getBean(ModelMapper.class);
    }
}
