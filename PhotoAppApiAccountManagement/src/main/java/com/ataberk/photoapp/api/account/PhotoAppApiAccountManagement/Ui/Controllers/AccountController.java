package com.ataberk.photoapp.api.account.PhotoAppApiAccountManagement.Ui.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping
    public String status(){
        return "Working";
    }
}
