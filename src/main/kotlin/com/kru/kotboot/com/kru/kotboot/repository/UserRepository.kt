package com.kru.kotboot.com.kru.kotboot.repository

import com.kru.kotboot.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional


@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface UserRepository : JpaRepository<User, Long>

