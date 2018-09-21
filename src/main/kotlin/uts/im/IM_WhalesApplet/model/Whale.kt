package uts.im.IM_WhalesApplet.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "whale")
data class Whale (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int = -1,

    @Column(name = "data_owner")
    @get: NotBlank
    val dataOwner: String = "",

    @Column(name = "latitude")
    @get: NotBlank
    val latitude: Double = 1.2,

    @Column(name = "longitude")
    @get: NotBlank
    val longitude: Double = 0.0,

    @Column(name = "common_name")
    @get: NotBlank
    val commonName: String = "",

    @Column(name = "scientific_name")
    @get: NotBlank
    val scientificName: String = "",

    @Column(name = "total_individuals")
    @get: NotBlank
    val totalIndividuals: Int = 0,

    @Column(name = "year_observed")
    @get: NotBlank
    val yearObserved: Int = 0


)