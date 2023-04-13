package cat.dao;

import cat.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession session;
    private static String namespace="cat.dao.UserMapper.";

    @Override
    public UserDto selectUser(String id) throws Exception {
        return session.selectOne(namespace + "select", id);
    }
    @Override
    public UserDto selectAdmin(String id) throws Exception {
        return session.selectOne(namespace+"selectAdmin",id);
    }

    @Override
    public List<UserDto> selectAllUser() throws Exception {
        System.out.println(" select all ");
        return session.selectList(namespace + "selectAllUser");
    }


    // 출결 관련
    @Override
    public int upAttendance(String id) throws Exception {
        return session.update(namespace+"updateAttendance",id);
    }

    @Override
    public int upLate(String id) throws Exception {
        return session.update(namespace+"updateLate",id);
    }

    @Override
    public int upEarlyLeave(String id) throws Exception {
        return session.update(namespace+"updateEarlyLeave",id);
    }


    @Override
    public int upAbsence(String id) throws Exception {
        System.out.println("upAbsence"+id);
        return session.update(namespace+"updateAbsence",id);
    }

}
