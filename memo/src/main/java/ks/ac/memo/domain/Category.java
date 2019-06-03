package ks.ac.memo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    private String genre;

    @OneToMany(mappedBy = "category") //mappedBy를 붙지 않은 아이가 ownership을 가진다. => 이 경우 Book이 ownership을 가진다.
    //    //개발자 관례 => OneToMany 쪽에 붙는다.
    //many에 붙어 다닌다. 이렇게 해서 안된다면, 반대로 걸어라.
    private List<Book> book = new ArrayList<>();

    public Long getIdx() {
        return idx;
    }

    public String getGenre() {
        return genre;
    }

    public void Idx(Long idx) {
        this.idx = idx;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
