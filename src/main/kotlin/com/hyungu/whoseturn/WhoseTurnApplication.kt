package com.hyungu.whoseturn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController("/")
class WhoseTurnApplication

fun main(args: Array<String>) {
    runApplication<WhoseTurnApplication>(*args)
}

@GetMapping("/hello")
fun hello(): String {
    return "Hello, World!";
}
