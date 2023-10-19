package juegoDeDado.S052.repository;

import juegoDeDado.S052.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {

    List<Object> findGamesByPlayer_Id (Long playerId);

}
