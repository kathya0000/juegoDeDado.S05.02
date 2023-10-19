package juegoDeDado.S052.service;

import juegoDeDado.S052.dto.RankingDTO;
import java.util.List;

public interface GameService {


    Object playGame(Long id);

    String deleteGamesByIdPlayer(Long id);

    List<Object> getAllGamesByIdPlayer(Long id);

    List<RankingDTO> getRankingGames();

    public String getWinnerRankingPlayer();

    public String getLoserRankingPlayer();

}
