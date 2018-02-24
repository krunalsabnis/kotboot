package com.kru.kotboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class KotbootApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotbootApplication::class.java, *args)
}
