package cat.service;

import cat.dao.UserDao;
import cat.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDto read(String id) throws Exception {
        return userDao.selectUser(id);
    }
    @Override
    public List<UserDto> readAll() throws Exception {
        System.out.println(" readAll ");
        return userDao.selectAllUser();
    }
    @Override
    public UserDto readAdmin(String id) throws Exception {
        return userDao.selectAdmin(id);
    }

}
