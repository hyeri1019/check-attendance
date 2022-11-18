package cat.Service;

import cat.dao.UserListDAOImpl;
import cat.dto.UserListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 해당 서비스에 맞는 데이터를 불러오기 위해 DAO 호출

@Service("userListService")
public class UserListServiceImpl implements UserListService {
    // Service - DAO 연결
    @Autowired
    UserListDAOImpl userListDAO;

    // DTO가 Service에 데이터를 전달함.
    @Override
    public List<UserListResponseDTO> getUserListService(){
        System.out.println(" service call ");
        return userListDAO.getUserListdao();
    }

}
