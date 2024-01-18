package com.glinboy.test.springboot.comment.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ModelMapperConfig {
    @Bean
    fun modelMapper(): ModelMapper = ModelMapper()
}

class UUIDToStringConverter: AbstractConverter<UUID, String>() {
    override fun convert(source: UUID?): String? = source?.toString()
}

class StringToUUIDConverter: AbstractConverter<String, UUID>(){
    override fun convert(source: String?): UUID? = source?.let{ UUID.fromString(it) }
}
