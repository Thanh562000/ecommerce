package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.dto.response.CommonResponse;
import com.ecommer.springbootapi.service.CommonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@AllArgsConstructor
@Slf4j
public class CommonServiceImpl implements CommonService {
    private static Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public CommonResponse getResponseContent(Page page, List dtoList) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setContent(dtoList);
        commonResponse.setPageNo(page.getNumber());
        commonResponse.setPageSize(page.getSize());
        commonResponse.setTotalPages(page.getTotalPages());
        commonResponse.setTotalElements(page.getTotalElements());
        commonResponse.setLast(page.isLast());

        return commonResponse;
    }

    @Override
    public Object convertToDto(Object type) {
        //map entity to dto
        return modelMapper.map(type, Object.class);
    }

    @Override
    public Object convertToEntity(Object type) {
        return modelMapper.map(type, Object.class);
    }
}
