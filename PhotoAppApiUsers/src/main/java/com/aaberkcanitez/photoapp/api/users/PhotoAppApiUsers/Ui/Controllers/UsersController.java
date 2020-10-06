package com.aaberkcanitez.photoapp.api.users.PhotoAppApiUsers.Ui.Controllers;


import com.aaberkcanitez.photoapp.api.users.PhotoAppApiUsers.Service.UsersService;
import com.aaberkcanitez.photoapp.api.users.PhotoAppApiUsers.Shared.UserDto;
import com.aaberkcanitez.photoapp.api.users.PhotoAppApiUsers.Ui.Model.CreateUserRequestModel;
import com.aaberkcanitez.photoapp.api.users.PhotoAppApiUsers.Ui.Model.CreateUserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {


    @Autowired
    private Environment env;

    @Autowired
    UsersService usersService;

    @GetMapping
    public String check(){
        return "hi";
    }


    @GetMapping("/status/check")
    public String status(){
        return "Working on port: " + env.getProperty("local.server.port");
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userDetails, UserDto.class);

        UserDto createdUser = usersService.createUser(userDto);

        CreateUserResponseModel responseModel = modelMapper.map(createdUser, CreateUserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }



}
