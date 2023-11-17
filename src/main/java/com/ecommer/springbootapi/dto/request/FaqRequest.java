package com.ecommer.springbootapi.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FaqRequest {
    private Long id;
    private String question;
    private String answer;
    private String status;
}
