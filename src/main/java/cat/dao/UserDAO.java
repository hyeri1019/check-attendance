package cat.dao;

import cat.dto.UserDto;

import java.util.List;

public interface UserDao {
    UserDto selectUser(String id) throws Exception;
    UserDto selectAdmin(String id) throws Exception;
    List<UserDto> selectAllUser() throws Exception;

    int upLate(String id) throws Exception;

    int upAttendance(String id) throws Exception;

    int upEarlyLeave(String id) throws Exception;

    int upAbsence(String id) throws Exception;

}
