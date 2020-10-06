package com.aaberkcanitez.photoapp.api.users.PhotoAppApiUsers.Data;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

}
