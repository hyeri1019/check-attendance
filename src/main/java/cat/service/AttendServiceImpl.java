package cat.service;

import cat.dao.AttendDao;
import cat.dao.UserDao;
import cat.dto.AttendDto;
import cat.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AttendServiceImpl implements AttendService {
    int count = 0;

    @Autowired
    AttendDao attendDao;

    @Autowired
    UserDao userDao;

    @Override
    public int checkIn(AttendDto attendDto) throws Exception {
        return attendDao.insertInTime(attendDto);
    }

    @Override
    public int checkOut(AttendDto attendDto) throws Exception {
        return attendDao.updateCheckOut(attendDto);
    }

    @Override
    public AttendDto readCheckIn(String id) throws Exception {
        return attendDao.selectTime(id);
    }

    @Override
    public AttendDto readCheckOut(String id) throws Exception {
        return attendDao.selectOutTime(id);
    }

    @Override
    public List<AttendDto> getTodayList() throws Exception {
        return attendDao.selectTodayList();
    }

    @Override
    public List<AttendDto> getAllDayList() throws Exception {
        return attendDao.selectAllDayList();
    }



    @Override
    public List<UserDto> attendCommit() throws Exception {
        count = 0;
        List<UserDto> getUser = userDao.selectAllUser();
        System.out.println("getUser = " + getUser);

        for (UserDto getUserId : getUser) {
            System.out.println("getUserId = " + getUserId);
            checkAttend(getUserId.getId());
        }
        return getUser;
    }

    // 출석/지각/조퇴/결석 판별
    @Override
    public int checkAttend(String id) throws Exception {

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date startTime = df.parse("2022-12-17 09:40:00");
//        Date endTime = df.parse("2022-12-17 18:00:00");

        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String today = sf2.format(now);
        String sTime = today+" 09:40:00";
        String eTime = today+" 18:00:00";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startTime = df.parse(sTime);
        Date endTime = df.parse(eTime);

        Date inTime = null;
        Date outTime = null;
        try {
            inTime = readCheckIn(id).getInTime();
            outTime = readCheckOut(id).getOutTime();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" inTime null ");
            return countEx(id);
        }

        System.out.println("inTime = " + inTime);
        System.out.println("outTime = " + outTime);

        // ~9시40분 입실 AND 18시~ 퇴실 체크한 경우
        if (inTime.compareTo(startTime) <= 0 && outTime.compareTo(endTime) >= 0) {
            System.out.println(" 출석 ");
            return userDao.upAttendance(id);
        }
        // 9시40분~ 입실 AND 18시~ 퇴실 체크한 경우
        if (inTime.compareTo(startTime) > 0 && outTime.compareTo(endTime) >= 0) {
            System.out.println("지각");
            return userDao.upLate(id);
        }
        // ~9시40분 입실 AND 18시 이전 퇴실 체크한 경우
        if (inTime.compareTo(startTime) <= 0 && outTime.compareTo(endTime) < 0) {
            System.out.println("조퇴");
            return userDao.upEarlyLeave(id);
        }
        return 0;
    }

        private int countEx(String id) throws Exception {
            if(count==0) {
                userDao.upAbsence(id);
                count++;
                System.out.println("count = " + count);
                return count;
            }
            return 0;
    }

}


