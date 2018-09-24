package uts.im.IM_WhalesApplet.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uts.im.IM_WhalesApplet.model.Whale
import uts.im.IM_WhalesApplet.model.WhaleProjection
import uts.im.IM_WhalesApplet.repository.WhaleRepository

@RestController
@RequestMapping("/api")
class WhaleController(private val whaleRepository: WhaleRepository) {

    @GetMapping("/whales")
    fun getAllWhales() : List<Whale> =
            whaleRepository.findAll()

    @GetMapping("/whales/{id}")
    fun getWhaleById(@PathVariable("id") whaleId: Int) : ResponseEntity<Whale> {
        return whaleRepository.findById(whaleId).map { whale -> ResponseEntity.ok(whale) }
                .orElse(ResponseEntity.notFound().build())

    }

    @GetMapping("/whales/year/{startingYear}")
    fun getWhalesByYear(@PathVariable("startingYear") startingYear: Int) : List<Whale> {
        return whaleRepository.getWhalesByYear(startingYear.toString(), (startingYear + 9).toString())

    }


    @GetMapping("/whales/name/{commonName}")
    fun getWhalesByCommonName(@PathVariable("commonName") commonName: String): List<Whale> {
        return whaleRepository.getWhalesByCommonName(commonName)

    }

    @GetMapping("/whales/both/{startingYear}+{commonName}")
    fun getWhalesByNameAndYear(@PathVariable("startingYear") startingYear: Int,
                               @PathVariable("commonName") commonName: String): List<Whale> {
        return whaleRepository.getWhalesByNameAndYear(commonName, startingYear.toString(), (startingYear + 9).toString())

    }

    @GetMapping("/whale_projections/year/{startingYear}")
    fun getWhaleProjectionsByYear(@PathVariable("startingYear") startingYear: Int) : List<WhaleProjection> {
        return whaleRepository.getWhaleProjectionsByYear(startingYear.toString(), (startingYear + 9).toString())

    }

    @GetMapping("/whale_projections/name/{commonName}")
    fun getWhalesProjectionsByCommonName(@PathVariable("commonName") commonName: String): List<WhaleProjection> {
        return whaleRepository.getWhaleProjectionsByCommonName(commonName)

    }

    @GetMapping("/whale_projections/both/{startingYear}+{commonName}")
    fun getWhaleProjectionsByNameAndYear(@PathVariable("startingYear") startingYear: Int,
                               @PathVariable("commonName") commonName: String): List<WhaleProjection> {
        return whaleRepository.getWhaleProjectionsByNameAndYear(commonName, startingYear.toString(), (startingYear + 9).toString())

    }


}