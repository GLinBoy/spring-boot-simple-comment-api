package com.glinboy.test.springboot.comment.service.impl

import com.glinboy.test.springboot.comment.entity.Comment
import com.glinboy.test.springboot.comment.repository.CommentRepository
import com.glinboy.test.springboot.comment.service.CommentService
import com.glinboy.test.springboot.comment.service.dto.CommentDTO
import org.modelmapper.ModelMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class CommentServiceImpl(
    val commentRepository: CommentRepository,
    val modelMapper: ModelMapper
) : CommentService {
    override fun getComments(pageable: Pageable): Page<CommentDTO> =
        commentRepository.findAll(pageable).map {
            modelMapper.map<CommentDTO>(it, Comment::class.java)
        }

    override fun getComment(id: String): CommentDTO? =
        commentRepository.findById(UUID.fromString(id))
            .map {
                modelMapper.map<CommentDTO>(it, Comment::class.java)
            }
            .orElse(null)

    override fun saveComment(commentDTO: CommentDTO): CommentDTO = throw NotImplementedError()

    override fun deleteComment(id: String) = throw NotImplementedError()
}
