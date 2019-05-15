package ac.ks.web.controller;

import ac.ks.web.domain.Board;
import ac.ks.web.domain.BoardType;
import ac.ks.web.repository.BoardRepository;
import ac.ks.web.service.BoardService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class BoardController {

    private BoardService boardService;
    private BoardRepository boardRepository;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String list(@PageableDefault Pageable pageable, Model model) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "index";
    }

    @GetMapping("/new")
    public String from(Board board) {
        return "new";
    }

    @PostMapping("/add")
    public String add(Board board, Model model){
        board.setBoardType(BoardType.free);
        board.setCreatedDate(LocalDateTime.now());
        board.setUpdatedDate(LocalDateTime.now());
        Board saveBoard = boardRepository.save(board);

        model.addAttribute("board",boardService.findBoardByIdx(saveBoard.getIdx()));
        return "item";
    }

    @GetMapping("/{idx}") // 밑에있는 idx와 이름이 같아야함.
    public String read(@PathVariable Long idx, Model model) {
        model.addAttribute("board", boardService.findBoardByIdx(idx));
        return "item";
    }
}
