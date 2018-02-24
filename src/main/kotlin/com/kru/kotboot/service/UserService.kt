package com.kru.kotboot.service

import com.kru.kotboot.exceptions.BadRequestException
import com.kru.kotboot.exceptions.DuplicateException
import com.kru.kotboot.exceptions.ResourceNotFoundException
import com.kru.kotboot.repository.UserRepository
import com.kru.kotboot.model.User
import com.kru.kotboot.model.UserDto
import com.kru.kotboot.model.UserRequest
import javassist.NotFoundException
import org.slf4j.Logger
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class UserService internal constructor(val userRepo: UserRepository, val log: Logger) {
    fun getUser(userId: Long): Optional<UserDto> {
        return userRepo.findById(userId).map{x -> x.toDto()}
    }

    fun save(userReq: UserRequest): UserDto {
        try {
            return userRepo.save(User.fromDto(userReq)).toDto()
        } catch (e: DataIntegrityViolationException){
            throw DuplicateException("user already exists")
        }
    }


    fun update(userId: Long, userUpdateReq: UserDto): UserDto {
        if (userId != userUpdateReq.userId)
            throw BadRequestException("userId in request body is not same as userId")
        if (!userRepo.existsById(userId))
            throw ResourceNotFoundException("user "+ userId + "not found")
        try {
            return userRepo.save(User.fromDto(userUpdateReq)).toDto()
        } catch (e: DataIntegrityViolationException){
            throw DuplicateException("email already exists")
        }
    }

    fun delete(userId: Long) {
        userRepo.deleteById(userId)
    }

    fun getUsers(pageable: Pageable): Page<UserDto> {
        return userRepo.findAll(pageable).map { x -> x.toDto() }
    }
}