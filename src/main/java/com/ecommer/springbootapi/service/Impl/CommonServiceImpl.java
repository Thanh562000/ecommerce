package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.dto.response.CommonResponse;
import com.ecommer.springbootapi.service.CommonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@AllArgsConstructor
@Slf4j
public class CommonServiceImpl implements CommonService {
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
}
