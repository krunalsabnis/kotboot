package com.kru.kotboot.controller

import USER_PATH
import com.kru.kotboot.service.UserService
import com.kru.kotboot.model.UserDto
import com.kru.kotboot.model.UserRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping(USER_PATH,
        produces = [MediaType.APPLICATION_JSON_VALUE] )
class UserController(private  val userService: UserService) {
    /*
    @GetMapping("/user")
    fun getAllUsers(@PageableDefault(value = 50) pageable: Pageable): Page<User> =
            userRepository.findAll(pageable)
     */

    @GetMapping("{userId}")
    fun getAllUser(@PathVariable("userId") userId: String): Optional<UserDto> =
            userService.getUser(userId.toLong())

    @PostMapping("/user")
    fun createUser(@Valid @RequestBody userReq: UserRequest): UserDto =
            userService.save(userReq)

    @PutMapping("{userId}")
    fun updateUser(@PathVariable("userId") userId: String,
                   @Valid @RequestBody userUpdateReq: UserDto): UserDto =
            userService.update(userId.toLong(), userUpdateReq)

    @DeleteMapping("{userId}")
    fun deleteUser(@PathVariable("userId") userId: String) =
           userService.delete(userId.toLong())

    @GetMapping
    fun getUsers(@PageableDefault(value = 50)  pageable: Pageable): Page<UserDto> =
            userService.getUsers(pageable);
}