package ks.ac.memo.domain;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long indx;

    private String name;

    @ManyToOne
    private Category category;

    public Long getIndx() {
        return indx;
    }

    public String getName() {
        return name;
    }

    public void setIndx(Long indx) {
        this.indx = indx;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
//        if(this.category != null) this.category = category;
        //set이 제일 중요하다!!!
        if(this.category != null){
            this.category.getBook().remove(this);
        }
        this.category = category;
        if(category != null){
            category.getBook().add(this);
        }
    }
}
