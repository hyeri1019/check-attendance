package cat.dao;

import cat.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDAOImpl implements BoardDAO {

    @Autowired
    private SqlSession session;
    private static String namespace ="cat.dao.BoardMapper.";

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    @Override
    public int deleteAll() throws  Exception {
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public int delete(Integer bno, String writer) throws Exception {
        Map map = new HashMap();
        map.put("board_num", bno);
        map.put("board_writer", writer);
        return session.delete(namespace+"delete", map);
    }

    @Override
    public int insert(BoardDTO dto) throws Exception {
        return session.insert(namespace+"insert", dto);
    }

    @Override
    public List<BoardDTO> selectAll() {
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public BoardDTO select(Integer bno) throws Exception {
        return session.selectOne(namespace + "select", bno);
    }

    @Override
    public List<BoardDTO> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }

    @Override
    public int update(BoardDTO dto) throws Exception {
        return session.update(namespace+"update", dto);
    }

    @Override
    public int increaseViewCnt(Integer bno) throws Exception {
        return session.update(namespace+"increaseViewCnt", bno);
    }


}
