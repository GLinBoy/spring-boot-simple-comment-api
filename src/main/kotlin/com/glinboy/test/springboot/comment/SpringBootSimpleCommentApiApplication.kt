package com.glinboy.test.springboot.comment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootSimpleCommentApiApplication

fun main(args: Array<String>) {
    runApplication<SpringBootSimpleCommentApiApplication>(*args)
}
