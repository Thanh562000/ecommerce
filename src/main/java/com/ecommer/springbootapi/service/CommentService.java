package com.ecommer.springbootapi.service;

import com.ecommer.springbootapi.dto.request.CommentDto;
import com.ecommer.springbootapi.entities.User;

import java.util.List;

public interface CommentService {
    CommentDto create(User customer, Long productId, CommentDto commentDto);

    List<CommentDto> findCommentByUser(User customer);

    List<CommentDto> getAll();

    List<CommentDto> getCommentByProductId(Long productId);

    CommentDto getCommentById(Long productId, Long commentId);

    CommentDto update(Long productId, CommentDto commentDto, Long commentId);

    void delete(Long productId, Long commentId);
}
