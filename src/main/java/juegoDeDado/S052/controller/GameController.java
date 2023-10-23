package juegoDeDado.S052.controller;

import juegoDeDado.S052.dto.RankingDTO;
import juegoDeDado.S052.exceptions.InvalidElementException;
import juegoDeDado.S052.models.Player;
import juegoDeDado.S052.service.ServiceGame;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game")
public class GameController {

    private final ServiceGame gameService;

    //Realizar un tiro de Dado
    @PostMapping("/{id}/games")
    public ResponseEntity<String> playGame(@PathVariable Long id) {
        try {
            if (id == null) throw new InvalidElementException(Player.class);
            return ResponseEntity.ok().body(gameService.playGame(id).toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Listado de Jugadas por un jugador
    @GetMapping("/{id}/games")
    public ResponseEntity<String> getAllGames(@PathVariable Long id) {
        try {
            if (id == null) throw new InvalidElementException(Player.class);
            List<Object> games = gameService.getAllGamesByIdPlayer(id);
            return ResponseEntity.ok().body(games.toString());
        } catch (Exception e) {
            List<Object> objectList = Collections.singletonList(new Object());
            objectList.add(e.getMessage());
            return (ResponseEntity.badRequest().body(objectList.toString()));
        }
    }

    //Eliminar tirada del Jugador
    @DeleteMapping("/{id}/games")
    public ResponseEntity<String> deleteGames(@PathVariable Long id) {
        try {
            if (id == null) throw new InvalidElementException(Player.class);
            return ResponseEntity.ok().body(gameService.deleteGamesByIdPlayer(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Ranking Medio de Todos los Jugadores
    @GetMapping("/ranking")
    public ResponseEntity<String> getRankingGames() {
        try {
            List<RankingDTO> rankingGames = gameService.getRankingGames();
            if (rankingGames.size() == 0 || rankingGames.isEmpty())
                return ResponseEntity.ok().body("There aren't games");
            else
                return ResponseEntity.ok().body(rankingGames.toString());
        } catch (Exception e) {
            List<String> objectList = Collections.singletonList("");
            objectList.add(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Jugador Peor Porcentaje de Exito
    @GetMapping("/ranking/loser")
    public ResponseEntity<String> getRankingLoser() {
        try {
            String loser = gameService.getLoserRankingPlayer();
            return ResponseEntity.ok().body(loser.toString());
        } catch (Exception e) {
            List<String> objectList = Collections.singletonList("");
            objectList.add(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Jugador con Mejor Porcentaje de Exito
    @GetMapping("/ranking/winner")
    public ResponseEntity<String> getRankingWinner() {
        try {
            String winner = gameService.getWinnerRankingPlayer();
            return ResponseEntity.ok().body(winner);
        } catch (Exception e) {
            List<String> objectList = Collections.singletonList("");
            objectList.add(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
