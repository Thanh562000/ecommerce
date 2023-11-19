package com.ecommer.springbootapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto {
    private Long id;
    private String review;
    private Integer rate;
    private String status;
}
