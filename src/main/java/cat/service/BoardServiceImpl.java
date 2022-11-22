package cat.service;

import cat.dao.BoardDAO;
import cat.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDAO boardDao;

    @Override
    public int getCount() throws Exception {
        return boardDao.count();
    }

    @Override
    public int remove(Integer board_num, String board_writer) throws Exception {
        return boardDao.delete(board_num, board_writer);
    }

    @Override
    public int write(BoardDTO boardDto) throws Exception {
        return boardDao.insert(boardDto);
    }

    @Override
    public List<BoardDTO> getList() throws Exception {
        return boardDao.selectAll();
    }

    @Override
    public BoardDTO read(Integer board_num) throws Exception {
        BoardDTO boardDto = boardDao.select(board_num);
//        boardDao.increaseViewCnt(board_num);

        return boardDto;
    }

    @Override
    public List<BoardDTO> getPage(Map map) throws Exception {
        return boardDao.selectPage(map);
    }



}


