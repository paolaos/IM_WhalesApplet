package uts.im.IM_WhalesApplet.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uts.im.IM_WhalesApplet.model.Whale
import uts.im.IM_WhalesApplet.repository.WhaleRepository

@RestController
@RequestMapping("/api")
class WhaleController(private val whaleRepository: WhaleRepository) {

    @GetMapping("/whales")
    fun getAllWhales() : List<Whale> =
            whaleRepository.findAll()

    @GetMapping("/whales/{id}")
    fun getWhaleById(@PathVariable(value = "id") whaleId: Int) : ResponseEntity<Whale> {
        return whaleRepository.findById(whaleId).map { whale -> ResponseEntity.ok(whale) }
                .orElse(ResponseEntity.notFound().build())

    }

}