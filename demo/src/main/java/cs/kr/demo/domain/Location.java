package cs.kr.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor

@Entity
@Table
public class Location implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String address;

    @Column
    private String postCode;

    @Builder
    public Location(String address, String postCode){
        this.address = address;
        this.postCode = postCode;
    }
}