package com.ecommer.springbootapi.service;

public interface MapperService<E, D> {
    E mapToEntity(D type);

    D mapToDto(E type);

}
