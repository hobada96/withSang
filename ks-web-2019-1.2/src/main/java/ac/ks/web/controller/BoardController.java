package ac.ks.web.controller;

import ac.ks.web.domain.Board;
import ac.ks.web.repository.BoardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BoardController {

    private BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    //Get / board -> 200 OK 게시글 Title 전체
    @GetMapping("/")
    public String home(){
        return "home.html";
    }

    @GetMapping("/board")
    public List<String> getBoardTitleAll(){
        List<Board> boardList = boardRepository.findAll();

        List<String> stringList = new ArrayList<>();

        //for-loop -> 향상된 for-loop
//        for(Board b : boardList){
//            stringList.add(b.getTitle());
//        }

        //for-loop
        return boardList.stream().map(i->i.getContent())
                                 .collect(Collectors.toList());
    }
}
