package com.glinboy.test.springboot.comment.service.dto

import java.util.*

data class CommentDTO(
    var id: String? = null,
    var fullName: String,
    var email: String,
    var content: String
)
