package juegoDeDado.S052.repository;

import juegoDeDado.S052.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {

    static List<Game> findAllByPlayerId(Long id) {
        return null;
    }

    List<Object> findGamesByPlayer_Id (Long playerId);

}
