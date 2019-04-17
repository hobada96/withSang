package ac.ks.example.doamin;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor

@Entity
@Table

public class Board extends Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;
}
