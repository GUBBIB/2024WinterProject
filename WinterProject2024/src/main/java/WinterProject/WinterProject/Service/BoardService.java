package WinterProject.WinterProject.Service;

import WinterProject.WinterProject.Repository.BoardRepository;
import WinterProject.WinterProject.Entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getBoardList(){

        List<Board> boards = boardRepository.findAll();

        return boards;
    }
}
