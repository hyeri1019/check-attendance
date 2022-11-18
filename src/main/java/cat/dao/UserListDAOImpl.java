package cat.dao;

import cat.dto.UserListResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("UserListDAO")   // 해당 클래스가 DAO임을 알리기 위한 어노테이션
public class UserListDAOImpl implements UserListDAO {

    // DAO는 데이터베이스에 실제 접근하여 읽기,삭제,수정,추가를 수행하고, DTO에게 데이터를 전달함.
    @Override
    public List<UserListResponseDTO> getUserListdao() {
        System.out.println(" dao call ");

        // 리스트 만들기
        List<UserListResponseDTO> userlist = new ArrayList<UserListResponseDTO>();

         // 총 3명의 학생을 만든다
        UserListResponseDTO list = new UserListResponseDTO();
        list.setUserName("홍길동");
        list.setUserAge("26");
        list.setUserAddress("경기도");
        list.setUserImage("peopleimage.png");
         // 위 데이터를 DTO에 저장
        userlist.add(list);

        UserListResponseDTO list2 = new UserListResponseDTO();
        list2.setUserName("김길동");
        list2.setUserAge("25");
        list2.setUserAddress("서울시");
        list2.setUserImage("peopleimage.png");
        userlist.add(list2);

        UserListResponseDTO list3 = new UserListResponseDTO();
        list3.setUserName("박길동");
        list3.setUserAge("20");
        list3.setUserAddress("서울시");
        list3.setUserImage("peopleimage.png");
        userlist.add(list3);

        System.out.println("list = "+ userlist);
        // DTO를 통해 데이터 전달
        return userlist;

    }
}
