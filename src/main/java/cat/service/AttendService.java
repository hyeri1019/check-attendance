package cat.service;


import cat.dto.AttendDto;
import cat.dto.UserDto;

import java.util.List;

public interface AttendService {

    int checkIn(AttendDto attendDto) throws Exception;
    int checkOut(AttendDto attendDto) throws Exception;

    List<UserDto> attendCommit() throws Exception;

    AttendDto readCheckIn(String id) throws Exception;

    AttendDto readCheckOut(String id) throws Exception;

    int checkAttend(String id) throws Exception;

    List<AttendDto> getTodayList() throws Exception;
    List<AttendDto> getAllDayList() throws Exception;

}



