package com.ecommer.springbootapi.service;

import com.ecommer.springbootapi.dto.request.FaqDto;

import java.util.List;

public interface FagService {
    FaqDto create(FaqDto faqDto);

    List<FaqDto> getAll();

    void delete(Long id);

    FaqDto update(FaqDto faqDto, Long id);

    FaqDto getById(Long id);
}
