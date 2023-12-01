package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.dto.request.CommentDto;
import com.ecommer.springbootapi.entities.Comment;
import com.ecommer.springbootapi.entities.Product;
import com.ecommer.springbootapi.entities.User;
import com.ecommer.springbootapi.exception.ApiException;
import com.ecommer.springbootapi.exception.ResourceNotFoundException;
import com.ecommer.springbootapi.repository.CommentRepository;
import com.ecommer.springbootapi.repository.ProductRepository;
import com.ecommer.springbootapi.repository.UserRepository;
import com.ecommer.springbootapi.service.CommentService;
import com.ecommer.springbootapi.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private MapperService<Comment, CommentDto> mapperService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CommentDto create(User customer, Long productId, CommentDto commentDto) {
        User user = userRepository.findById(customer.getId()).orElseThrow(() -> new ResourceNotFoundException("User id", customer.getId()));
        Product product = findProductById(productId);

        Comment comment = mapperService.mapToEntity(commentDto);
        comment.setProduct(product);
        comment.setCustomer(user);

        return mapperService.mapToDto(comment);
    }

    @Override
    public List<CommentDto> findCommentByUser(User customer) {
        List<Comment> comments = commentRepository.findByCustomer(customer);
        if (comments.size() == 0) {
            throw new ApiException("User has no comment or review", HttpStatus.BAD_REQUEST);
        }

        return comments.stream().map(v -> mapperService.mapToDto(v))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(v -> mapperService.mapToDto(v))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getCommentByProductId(Long productId) {
        List<Comment> comments = commentRepository.findByProduct_ProductId(productId);
        return comments.stream().map(v -> mapperService.mapToDto(v))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long productId, Long commentId) {
        Product product = findProductById(productId);
        Comment comment = findCommentById(commentId);

        if (!comment.getProduct().getProductId().equals(product.getProductId())) {
            throw new ApiException("Comment doesn't belong to product", HttpStatus.BAD_REQUEST);
        }

        return mapperService.mapToDto(comment);
    }

    @Override
    public CommentDto update(Long productId, CommentDto commentDto, Long commentId) {
        Product product = findProductById(productId);
        Comment comment = findCommentById(commentId);

        if (!comment.getProduct().getProductId().equals(product.getProductId())) {
            throw new ApiException("Comment doesn't belong to product", HttpStatus.BAD_REQUEST);
        }

        comment.setReview(commentDto.getReview());
        comment.setRate(commentDto.getRate());
        comment.setStatus(commentDto.getStatus());

        Comment update = commentRepository.save(comment);
        return mapperService.mapToDto(update);
    }

    @Override
    public void delete(Long productId, Long commentId) {
        Product product = findProductById(productId);
        Comment comment = findCommentById(commentId);

        if (!comment.getProduct().getProductId().equals(product.getProductId())) {
            throw new ApiException("Comment doesn't belong to product", HttpStatus.BAD_REQUEST);
        }
        commentRepository.delete(comment);
    }

    private Product findProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", productId));
    }

    private Comment findCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", commentId));
    }
}
