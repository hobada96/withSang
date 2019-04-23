package cs.kr.demo.domain;

import lombok.Builder;
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
    private Long idx;

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

    @Builder
    public Work(String company, String position, String website, Date startDate, Date endDate, String summry){
        this.company = company;
        this.position = position;
        this.website = website;
        this.startDate = startDate;
        this.endDate = endDate;
        this.summry = summry;
    }
}
