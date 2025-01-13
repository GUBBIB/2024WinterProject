package WinterProject.WinterProject.Service;

import WinterProject.WinterProject.Repository.BoardRepository;
import WinterProject.WinterProject.Entity.Board;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

    public Board getBoardById(Long boardId){
        Board board = boardRepository.findById(boardId).orElse(new Board());

        return board;
    }

    public List<Board> getBoardList(){
        List<Board> boards = boardRepository.findAll();
        logger.debug("Fetched boards: {}", boards);
        return boards;
    }

    public void removeBoardList(List<Long> boardIdList){
        List<Board> deleteBoards = boardRepository.findAllById(boardIdList);
        boardRepository.deleteAll(deleteBoards);
    }

    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

}
