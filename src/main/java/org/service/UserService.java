package org.service;

import org.dto.UserDTO;
import org.model.User;

public class UserService {
    public UserDTO UserToDto(User user){
        return new UserDTO(user);
    }
}
