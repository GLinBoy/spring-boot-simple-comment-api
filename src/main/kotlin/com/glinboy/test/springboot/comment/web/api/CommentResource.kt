package com.glinboy.test.springboot.comment.web.api

import com.glinboy.test.springboot.comment.service.CommentService
import com.glinboy.test.springboot.comment.service.dto.CommentDTO
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/comments")
class CommentResource(val commentService: CommentService) {

    @GetMapping
    fun getComments(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<CommentDTO>> =
        ResponseEntity.ok(commentService.getComments(pageable))

    @GetMapping("{id}")
    fun getBook(@PathVariable id: String): ResponseEntity<CommentDTO> =
        commentService.getComment(id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
}
