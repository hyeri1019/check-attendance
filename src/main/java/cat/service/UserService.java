package cat.service;

import cat.dto.UserDto;

import java.util.List;

public interface UserService {

    // 로그인 id,pwd 검증
    UserDto read(String id) throws  Exception;
    UserDto readAdmin(String id) throws Exception;
    List<UserDto> readAll() throws Exception;

}
