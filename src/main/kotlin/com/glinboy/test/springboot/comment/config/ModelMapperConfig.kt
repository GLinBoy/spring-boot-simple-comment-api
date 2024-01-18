package com.glinboy.test.springboot.comment.config

import org.modelmapper.AbstractConverter
import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.UUID

@Configuration
class ModelMapperConfig {
    @Bean
    fun modelMapper(): ModelMapper {
        val modelMapper = ModelMapper()
        modelMapper.addConverter(UUIDToStringConverter())
        modelMapper.addConverter(StringToUUIDConverter())
        return modelMapper
    }
}

class UUIDToStringConverter: AbstractConverter<UUID, String>() {
    override fun convert(source: UUID?): String? = source?.toString()
}

class StringToUUIDConverter: AbstractConverter<String, UUID>(){
    override fun convert(source: String?): UUID? = source?.let{ UUID.fromString(it) }
}
