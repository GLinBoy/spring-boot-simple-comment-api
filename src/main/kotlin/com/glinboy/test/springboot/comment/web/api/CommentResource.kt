package com.glinboy.test.springboot.comment.web.api

import com.glinboy.test.springboot.comment.service.CommentService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/comments")
class CommentResource(val commentService: CommentService) {

}
