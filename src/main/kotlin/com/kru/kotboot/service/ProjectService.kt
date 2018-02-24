package com.kru.kotboot.service

import com.kru.kotboot.exceptions.DuplicateException
import com.kru.kotboot.exceptions.ResourceNotFoundException
import com.kru.kotboot.model.Project
import com.kru.kotboot.model.ProjectDTO
import com.kru.kotboot.repository.ProjectRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class ProjectService internal constructor(val projectRepo: ProjectRepository) {
    fun getProjects(pageReq: Pageable): Page<ProjectDTO> =
        projectRepo.findAll(pageReq).map { x -> x.toDto() }

    fun save(projectDto: ProjectDTO): ProjectDTO {
        try {
            return projectRepo.save(Project.fromDto(projectDto)).toDto()
        } catch (e: DataIntegrityViolationException) {
            throw DuplicateException("data integrity error")
        }
    }

    fun assignProject(userId: Long, projectId: Long) {
        val p = projectRepo.findById(projectId)
        if (p.isPresent) {
            p.get().userId = userId
            projectRepo.save(p.get())
        } else throw ResourceNotFoundException("project id $projectId not found")
    }
}