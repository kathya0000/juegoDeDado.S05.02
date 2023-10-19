package juegoDeDado.S052.controller;

import juegoDeDado.S052.dto.PlayerDTO;
import juegoDeDado.S052.exceptions.ElementsDoesntEqualsException;
import juegoDeDado.S052.exceptions.InvalidElementException;
import juegoDeDado.S052.models.Player;
import juegoDeDado.S052.service.ServicePlayer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game/players")
public class PlayerController {

    ServicePlayer playerService;

    public PlayerController(ServicePlayer playerService) {
        this.playerService = playerService;
    }

    //TODO Create a player
    @PostMapping("")
    public ResponseEntity<Object> createPlayer(@RequestBody PlayerDTO playerDTO) {
        try {
            return ResponseEntity.ok().body(playerService.createPlayer(playerDTO));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //TODO Update Player name
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePlayer(@PathVariable Long id,
                                               @RequestBody PlayerDTO playerDTO) {
        try {
            if (playerDTO.getId() == null || id == null ) throw new InvalidElementException(Player.class);
            if (!playerDTO.getId().equals(id)) throw new ElementsDoesntEqualsException(Player.class, id, playerDTO.getId());
            return ResponseEntity.ok().body(playerService.updatePlayer(id, playerDTO));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
