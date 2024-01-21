package com.glinboy.test.springboot.comment.repository

import com.glinboy.test.springboot.comment.entity.Comment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CommentRepository: JpaRepository<Comment, UUID> {
    fun findAllByPageId(pageId: String, pageable: Pageable): Page<Comment>
}
