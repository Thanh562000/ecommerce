package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.Comment;
import com.ecommer.springbootapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByProduct_ProductId(Long productId);

    List<Comment> findByCustomer(User customer);
}
