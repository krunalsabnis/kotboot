package com.kru.kotboot.service

import com.kru.kotboot.exceptions.DuplicateException
import com.kru.kotboot.exceptions.ResourceNotFoundException
import com.kru.kotboot.model.*
import com.kru.kotboot.repository.UserRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional
import kotlin.collections.ArrayList

@Service
@Transactional
class UserService internal constructor(val userRepo: UserRepository,
                                       val projectService: ProjectService) {

    fun getUser(userId: Long): Optional<UserDto> {
        return userRepo.findById(userId).map{x -> x.toDto()}
    }

    fun save(userReq: UserCreateRequest): UserDto {
        try {
            return userRepo.save(User.fromDto(userReq)).toDto()
        } catch (e: DataIntegrityViolationException){
            throw DuplicateException("user already exists")
        }
    }

    fun updateEntity(dbRec: User, updateReq: UserUpdateRequest): User {
        dbRec.active = updateReq.active
        dbRec.activatedAt = updateReq.activatedAt
        dbRec.loginAt = updateReq.loginAt
        dbRec.logoutAt = updateReq.logoutAt
        dbRec.uid = updateReq.uid
        dbRec.provider = updateReq.provider
        return dbRec
    }

    fun update(userId: Long, userUpdateReq: UserUpdateRequest): UserDto {
        val existingRec = userRepo.findById(userId)

        existingRec.orElseThrow { throw ResourceNotFoundException("user "+ userId + "not found") }

        try {
            return userRepo.save(updateEntity(existingRec.get(), userUpdateReq)).toDto()
        } catch (e: DataIntegrityViolationException){
            throw DuplicateException("Data integrity exception")
        }
    }

    fun delete(userId: Long) {
        if(userRepo.existsById(userId)) userRepo.deleteById(userId) else throw ResourceNotFoundException("user does not exists")
    }

    fun getUsers(pageable: Pageable): Page<UserDto> {
        return userRepo.findAll(pageable).map { x -> x.toDto() }
    }

    fun getProject(userId: Long): List<ProjectDTO> {
        if (getUser(userId).isPresent)
          return ArrayList<ProjectDTO>(getUser(userId).get().projects)
        else
            throw ResourceNotFoundException("user $userId does not exists")
    }

    fun assignProject(userId: Long, projectId: Long) {
        if(userRepo.existsById(userId))
            projectService.assignProject(userId, projectId)
        else throw ResourceNotFoundException("user $userId does not exists")
    }
}