package juegoDeDado.S052.service;

import juegoDeDado.S052.dto.PlayerDTO;
import juegoDeDado.S052.models.Player;

public interface PlayerService {

    PlayerDTO createPlayer(PlayerDTO playerDTO);

    Object updatePlayer(Long id, PlayerDTO playerDTO);

    Player getPlayerById(Long id);

}
