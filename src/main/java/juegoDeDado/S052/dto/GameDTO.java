package juegoDeDado.S052.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import juegoDeDado.S052.models.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
public class GameDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer points;
    private Player player;

    @Override
    public String toString() {
        return  "id=" + id +
                ", points=" + points +
                ", player: " + player.getId() + "-" + player.getId();
    }
}
