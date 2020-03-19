package com.opsly.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@PropertySource("classpath:messages.properties")
@EnableAsync
class BackendApplication

fun main(args: Array<String>) {
	runApplication<BackendApplication>(*args)
}
