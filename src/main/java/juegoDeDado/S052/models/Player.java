package juegoDeDado.S052.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Date date;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player " + id + "-" + name;
    }
}
