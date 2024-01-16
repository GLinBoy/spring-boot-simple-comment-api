package com.glinboy.test.springboot.comment.service.impl

import com.glinboy.test.springboot.comment.service.CommentService
import com.glinboy.test.springboot.comment.service.dto.CommentDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl: CommentService {
    override fun getComments(pageable: Pageable): Page<CommentDTO> {
        TODO("Not yet implemented")
    }

    override fun getComment(id: Long): CommentDTO? {
        TODO("Not yet implemented")
    }

    override fun saveComment(commentDTO: CommentDTO): CommentDTO {
        TODO("Not yet implemented")
    }

    override fun deleteComment(id: Long) {
        TODO("Not yet implemented")
    }
}
