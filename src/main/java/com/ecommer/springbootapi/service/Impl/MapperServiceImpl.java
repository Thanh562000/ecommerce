package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.service.MapperService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class MapperServiceImpl<E, D> implements MapperService<E, D> {

    @Autowired
    private ModelMapper modelMapper;

    private Class<D> dtoClass;
    private Class<E> entityClass;

    @Override
    public E mapToEntity(D type) {
        return modelMapper.map(type, getEntityClass());
    }

    @Override
    public D mapToDto(E type) {
        return modelMapper.map(type, getDtoClass());
    }
}
