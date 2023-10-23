package juegoDeDado.S052.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Date date;

    @Override
    public String toString() {
        return "Player " + id + "-" + name;
    }
}
