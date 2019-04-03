package ac.ks.web.domain;

import ac.ks.web.repository.BoardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BoardTest {
    @Autowired
    BoardRepository boardRepository;
    Board savedBoard;
    @Before
    public void init(){
        Board board = Board.builder()
                .title("제목1")
                .subTitle("제목2")
                .content("내용1")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        //id는 자동으로 db에서 만들어줌
        savedBoard = boardRepository.save(board);
    }
    @Test
    public void testRead(){
        Board findBoard = boardRepository.findById(savedBoard.getIdx()).orElse(null);
        assertThat(findBoard.getIdx()).isEqualTo(savedBoard.getIdx());
    }
}
