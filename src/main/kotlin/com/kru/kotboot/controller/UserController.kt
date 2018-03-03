package com.kru.kotboot.controller

import USER_PATH
import com.kru.kotboot.model.ProjectDTO
import com.kru.kotboot.service.UserService
import com.kru.kotboot.model.UserDto
import com.kru.kotboot.model.UserCreateRequest
import com.kru.kotboot.model.UserUpdateRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping(USER_PATH,
        produces = [MediaType.APPLICATION_JSON_VALUE] )
class UserController(private  val userService: UserService) {

    @GetMapping("{userId}")
    @ResponseStatus(HttpStatus.OK)
    fun getAllUser(@PathVariable("userId") userId: String): Optional<UserDto> =
            userService.getUser(userId.toLong())

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@Valid @RequestBody userReq: UserCreateRequest): UserDto =
            userService.save(userReq)

    @PutMapping("{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateUser(@PathVariable("userId") userId: String,
                   @Valid @RequestBody userUpdateReq: UserUpdateRequest): UserDto =
            userService.update(userId.toLong(), userUpdateReq)

    @DeleteMapping("{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable("userId") userId: String) =
           userService.delete(userId.toLong())

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getUsers(@PageableDefault(value = 50)  pageable: Pageable): Page<UserDto> =
            userService.getUsers(pageable)

    @GetMapping("{userId}/project")
    @ResponseStatus(HttpStatus.OK)
    fun getProjectForUser(@PathVariable("userId") userId: String): List<ProjectDTO> =
            userService.getProject(userId.toLong())

    @PutMapping("{userId}/project/{projectId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun assignProject(@PathVariable("userId") userId: String,
                      @PathVariable("projectId") projectId: String) =
            userService.assignProject(userId.toLong(), projectId.toLong())

}