package cat.dao;

import cat.dto.AttendDto;

import java.util.List;

public interface AttendDao {

    int insertInTime(AttendDto id) throws Exception;

    int updateCheckOut(AttendDto attendDto) throws Exception;

    AttendDto selectTime(String id) throws Exception;

    AttendDto selectOutTime(String id) throws Exception;

    List<AttendDto> selectTodayList() throws Exception;
    List<AttendDto> selectAllDayList() throws Exception;


}
