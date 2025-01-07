package WinterProject.WinterProject.Service;

import WinterProject.WinterProject.Repository.BoardRepository;
import WinterProject.WinterProject.Entity.Board;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);


    public List<Board> getBoardList(){

        List<Board> boards = boardRepository.findAll();
        logger.debug("Fetched boards: {}", boards);
        return boards;
    }

    public Board createBoard(String boardName, String boardDescription) {
        Board board = new Board();
        board.setBoardName(boardName);
        board.setBoardDescription(boardDescription);

        return boardRepository.save(board);
    }
}
