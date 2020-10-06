package com.aaberkcanitez.photoapp.api.users.PhotoAppApiUsers.Service;

import com.aaberkcanitez.photoapp.api.users.PhotoAppApiUsers.Shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersService extends UserDetailsService {
    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email);

}
