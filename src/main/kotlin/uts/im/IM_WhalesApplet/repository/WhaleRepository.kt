package uts.im.IM_WhalesApplet.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import uts.im.IM_WhalesApplet.model.Whale
import uts.im.IM_WhalesApplet.model.WhaleProjection

@Repository
interface WhaleRepository : JpaRepository<Whale, Int> {

    @Query("FROM Whale WHERE year_observed BETWEEN :startingYear AND :endingYear")
    fun getWhalesByYear(@Param("startingYear") startingYear: String,
                        @Param("endingYear") endingYear: String): List<Whale>

    @Query("FROM Whale WHERE common_name = :commonName")
    fun getWhalesByCommonName(@Param("commonName") commonName: String): List<Whale>

    @Query("FROM Whale WHERE common_name = :commonName AND year_observed BETWEEN :startingYear AND :endingYear")
    fun getWhalesByNameAndYear(@Param("commonName") commonName: String,
                               @Param("startingYear") startingYear: String,
                               @Param("endingYear") endingYear: String): List<Whale>

    @Query("SELECT latitude, longitude, total_individuals FROM whale " +
            "WHERE common_name = :commonName AND year_observed BETWEEN :startingYear " +
            "AND :endingYear", nativeQuery = true)
    fun getWhaleProjectionsByNameAndYear(@Param("commonName") commonName: String,
                                 @Param("startingYear") startingYear: String,
                                 @Param("endingYear") endingYear: String): List<WhaleProjection>

    @Query("SELECT latitude, longitude, total_individuals FROM whale " +
            "WHERE common_name = :commonName", nativeQuery = true)
    fun getWhaleProjectionsByCommonName(@Param("commonName") commonName: String): List<WhaleProjection>

    @Query("SELECT latitude, longitude, total_individuals FROM whale " +
            "WHERE year_observed BETWEEN :startingYear AND :endingYear", nativeQuery = true)
    fun getWhaleProjectionsByYear(@Param("startingYear") startingYear: String,
                                        @Param("endingYear") endingYear: String): List<WhaleProjection>

}

