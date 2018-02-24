package com.kru.kotboot.repository

import com.kru.kotboot.model.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional


@Repository
@Transactional(Transactional.TxType.MANDATORY)
internal interface ProjectRepository : JpaRepository<Project, Long>

