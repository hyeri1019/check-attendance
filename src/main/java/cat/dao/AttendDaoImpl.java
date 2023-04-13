package cat.dao;

import cat.dto.AttendDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AttendDaoImpl implements AttendDao {

    @Autowired
    private SqlSession session;
    private static String namespace="cat.dao.AttendMapper.";
    @Override
    public int insertInTime(AttendDto attendDto) throws Exception{
        return session.insert(namespace+"insertInTime", attendDto);
    }

    @Override
    public int updateCheckOut(AttendDto attendDto) throws Exception {
        return session.update(namespace+"updateCheckOut",attendDto);
    }

    @Override
    public AttendDto selectTime(String id) throws Exception {
        return session.selectOne(namespace+"selectInTime",id);
    }

    @Override
    public AttendDto selectOutTime(String id) throws Exception {
        return session.selectOne(namespace+"selectOutTime",id);
    }

    // 오늘 날짜에 출석한 사람 조회
    @Override
    public List<AttendDto> selectTodayList() throws Exception {
        return session.selectList(namespace+"selectTodayList");
    }

    @Override
    public List<AttendDto> selectAllDayList() throws Exception {
        return session.selectList(namespace+"selectAllDayList");
    }

}
