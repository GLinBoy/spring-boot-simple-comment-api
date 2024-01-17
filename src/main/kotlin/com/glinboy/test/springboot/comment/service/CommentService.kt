package com.glinboy.test.springboot.comment.service

import com.glinboy.test.springboot.comment.service.dto.CommentDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CommentService {
    fun getComments(pageable: Pageable): Page<CommentDTO>
    fun getComment(id: String): CommentDTO?
    fun saveComment(commentDTO: CommentDTO): CommentDTO
    fun deleteComment(id: String)
}
