package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.dto.request.FaqDto;
import com.ecommer.springbootapi.entities.Faq;
import com.ecommer.springbootapi.exception.ResourceNotFoundException;
import com.ecommer.springbootapi.repository.FaqRepository;
import com.ecommer.springbootapi.service.FagService;
import com.ecommer.springbootapi.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FagServiceImpl implements FagService {
    @Autowired
    private FaqRepository faqRepository;

    @Autowired
    private MapperService<Faq, FaqDto> mapperService;

    @Override
    public FaqDto create(FaqDto faqDto) {
        Faq faq = mapperService.mapToEntity(faqDto);
        return mapperService.mapToDto(faqRepository.save(faq));
    }

    @Override
    public List<FaqDto> getAll() {
        List<Faq> list = faqRepository.findAll();
        return list.stream().map(v -> mapperService.mapToDto(v)).toList();
    }

    @Override
    public void delete(Long id) {
        Faq faq = faqRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Faq", id));
        faqRepository.delete(faq);
    }

    @Override
    public FaqDto update(FaqDto faqDto, Long id) {
        Faq faq = faqRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Faq", id));
        faq.setQuestion(faqDto.getQuestion());
        faq.setStatus(faqDto.getStatus());
        faq.setAnswer(faqDto.getAnswer());

        Faq update =faqRepository.save(faq);
        return mapperService.mapToDto(update);
    }

    @Override
    public FaqDto getById(Long id) {
        Faq faq = faqRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Faq", id));
        return mapperService.mapToDto(faq);
    }
}
