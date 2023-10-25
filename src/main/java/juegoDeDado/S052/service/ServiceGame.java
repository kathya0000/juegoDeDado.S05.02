package juegoDeDado.S052.service;

import juegoDeDado.S052.dto.RankingDTO;
import juegoDeDado.S052.models.Game;
import juegoDeDado.S052.models.Player;
import juegoDeDado.S052.repository.GameRepository;
import juegoDeDado.S052.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ServiceGame implements GameService {

    private final PlayerService playerService;
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;



    @Override
    public Object playGame(Long id) {
        Player player = playerService.getPlayerById(id);

        Game game = new Game(player, throwDices());
        gameRepository.save(game);
        return game;
    }

    @Override
    public String deleteGamesByIdPlayer(Long id) {

        List<Object> objets = gameRepository.findGamesByPlayer_Id(id);
        if (objets.isEmpty() || objets.size() == 0)
            return "Player with id " + id + " has no games";
        else {
            objets.stream().forEach(game -> {
                gameRepository.delete((Game) game);
            });

            return "Games deleted";
        }
    }

    @Override
    public List<Object> getAllGamesByIdPlayer(Long id) {

        return gameRepository.findGamesByPlayer_Id(id);
    }

    @Override
    public List<RankingDTO> getRankingGames() {

        List<RankingDTO> rankingDTOS = calcRanking();

        return rankingDTOS;

    }

    @Override
    public String getWinnerRankingPlayer() {
        List<RankingDTO> rankingDTOS = calcRanking();
        if (!rankingDTOS.isEmpty())
            //TODO Returns all the best ones with the same ranking.
            return rankingDTOS.stream()
                    .filter(x -> x.getSuccessRate() == rankingDTOS.get(0).getSuccessRate())
                    .toList()
                    .toString();
        else
            return "There aren't games";
    }

    @Override
    public String getLoserRankingPlayer() {
        List<RankingDTO> rankingDTOS = calcRanking();
        if (!rankingDTOS.isEmpty())
            //TODO Returns all the worst with the same ranking
            return rankingDTOS.stream()
                    .filter(x -> x.getSuccessRate() == rankingDTOS.get(rankingDTOS.size() - 1).getSuccessRate())
                    .toList()
                    .toString();
        else
            return "There aren't games";
    }

    private List<RankingDTO> calcRanking() {
        List<RankingDTO> rankingDTOS = new ArrayList<>();
        List<Player> players = playerRepository.findAll();
        List<Game> games = gameRepository.findAll();

        for (Player player : players) {
            Long id = player.getId();
            int countGameWin = (int) games.stream()
                    .filter(x -> x.getPlayer().getId() == id && x.getPoints() == 7)
                    .count();
            int totalGames = (int) games.stream()
                    .filter(x -> x.getPlayer().getId() == id)
                    .count();
            double successRate = 0.0;
            if (countGameWin > 0) {
                successRate = (double) countGameWin / totalGames;
            }
            // Si un jugador no ha jugado ningún juego, no entra en el ranking
            if (totalGames != 0) {
                RankingDTO rankingDTO = new RankingDTO(player.getId(), player.getName(), countGameWin,
                        totalGames, successRate);
                rankingDTOS.add(rankingDTO);
            }
        }

        // Usando lambda para ordenar la lista en orden descendente según SuccessRate
        rankingDTOS.sort(Comparator.comparing(RankingDTO::getSuccessRate).reversed());

        return rankingDTOS;
    }


    private Integer throwDices() {
        Integer dado1 = new Random().nextInt(6) + 1;
        Integer dado2 = new Random().nextInt(6) + 1;
        return dado1 + dado2;
    }

}

