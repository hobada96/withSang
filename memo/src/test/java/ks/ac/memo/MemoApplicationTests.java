package ks.ac.memo;

import ks.ac.memo.domain.Book;
import ks.ac.memo.domain.Category;
import ks.ac.memo.repository.BookRepository;
import ks.ac.memo.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemoApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void saveEntity(){
		Category category = new Category();
		category.setGenre("운영체제");
		categoryRepository.save(category);


		Book book = new Book();
		book.setName("공룡책");
		// OneToMany, ManyToOne 을 저장 할 때
		book.setCategory(category);
		book.getCategory().getBook().add(book);
		//
		bookRepository.save(book);


		Category newCategory = new Category();
		newCategory.setGenre("프로그래밍 언어");
		categoryRepository.save(newCategory);
		book.setCategory(newCategory);
		book.getCategory().getBook().add(book);
		bookRepository.save(book);
		bookRepository.findAll().forEach(b -> System.out.println(b.getCategory().getBook()));
		List<Category> categories = categoryRepository.findAll();
		for(Category c : categories){
			System.out.println(Arrays.toString(c.getBook()));
		}
	}
}
