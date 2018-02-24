package com.kru.kotboot.controller

import com.kru.kotboot.com.kru.kotboot.repository.UserRepository
import com.kru.kotboot.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1")
class UserController(private  val userRepository: UserRepository) {
    @GetMapping("/user")
    fun getAllUsers(@PageableDefault(value = 50) pageable: Pageable): Page<User> =
            userRepository.findAll(pageable)

    @PostMapping("/user")
    fun createUser(@Valid @RequestBody user: User): User =
            userRepository.save(user)

    /*@GetMapping("/user/{id}")
    fun getUserById(@PathVariable(value = "userId") userId: Long): ResponseEntity<User> {
        val user = userRepository.findByUserId(userId)
                .orElse(ResponseEntity.notFound().build())

    }

    @PutMapping("/user/{id}")
    fun updateArticleById(@PathVariable(value = "userId") userId: Long,
                          @Valid @RequestBody newUser: User): ResponseEntity<User> {

        return userRepository.findOne(userId){ existingArticle ->
            val updatedArticle: Article = existingArticle
                    .copy(title = newArticle.title, content = newArticle.content)
            ResponseEntity.ok().body(articleRepository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())

    }
    */
}