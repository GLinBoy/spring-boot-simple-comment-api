package com.glinboy.test.springboot.comment.service.impl

import com.glinboy.test.springboot.comment.entity.Comment
import com.glinboy.test.springboot.comment.repository.CommentRepository
import com.glinboy.test.springboot.comment.service.CommentService
import com.glinboy.test.springboot.comment.service.dto.CommentDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class CommentServiceImpl(
    val commentRepository: CommentRepository
) : CommentService {
    override fun getComments(pageable: Pageable): Page<CommentDTO> =
        commentRepository.findAll(pageable).map {
            CommentDTO(it.id?.toString(), it.fullName, it.email, it.content, it.pageId)
        }

    override fun getComment(id: String): CommentDTO? =
        commentRepository.findById(UUID.fromString(id))
            .map {
                CommentDTO(it.id?.toString(), it.fullName, it.email, it.content, it.pageId)
            }
            .orElse(null)

    override fun saveComment(commentDTO: CommentDTO): CommentDTO {
        var comment = Comment(
            commentDTO.id?.let { UUID.fromString(it) },
            commentDTO.fullName,
            commentDTO.email,
            commentDTO.content,
            commentDTO.pageId
        )
        comment = commentRepository.save(comment)
        return CommentDTO(
            comment.id?.toString(),
            comment.fullName,
            comment.email,
            comment.content,
            comment.pageId
        )
    }

    override fun deleteComment(id: String) = commentRepository.deleteById(UUID.fromString(id))
}
