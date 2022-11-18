package cat.Service;

import cat.dto.UserListResponseDTO;

import java.util.List;

public interface UserListService {
    // DTO를 통해 데이터를 가져옴.
    public List<UserListResponseDTO> getUserListService();
}
