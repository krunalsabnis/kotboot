package com.kru.kotboot.controller

import PROJECT_PATH
import com.kru.kotboot.model.ProjectDTO
import com.kru.kotboot.service.ProjectService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping(PROJECT_PATH,
        produces = [MediaType.APPLICATION_JSON_VALUE] )
class ProjectController(private val projectService: ProjectService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getProjects(@PageableDefault(value = 50)  pageable: Pageable): Page<ProjectDTO> =
            projectService.getProjects(pageable)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProject(@Valid @RequestBody projectDto: ProjectDTO): ProjectDTO =
            projectService.save(projectDto)
}