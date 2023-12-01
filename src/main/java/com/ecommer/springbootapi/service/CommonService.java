package com.ecommer.springbootapi.service;

import com.ecommer.springbootapi.dto.response.CommonResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommonService<T> {
    CommonResponse getResponseContent(Page<T> page, List<T> dtoList);

}
