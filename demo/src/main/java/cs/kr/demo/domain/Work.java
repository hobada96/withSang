package cs.kr.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor

@Entity
@Table
public class Work {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String company;

    @Column
    private String position;

    @Column
    private String website;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private String summry;
}
