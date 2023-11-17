package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
