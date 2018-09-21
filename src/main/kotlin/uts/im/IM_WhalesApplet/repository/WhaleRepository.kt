package uts.im.IM_WhalesApplet.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import uts.im.IM_WhalesApplet.model.Whale

@Repository
interface WhaleRepository : JpaRepository<Whale, Int>