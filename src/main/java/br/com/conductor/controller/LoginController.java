package br.com.conductor.controller;

import br.com.conductor.service.LoginService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginControllerApi {

    @Autowired
    private LoginService service;

    @GetMapping("/login")
    public ResponseEntity<Object> login(
            @ApiParam(value = "Value password", required=true) @RequestParam("password") String password){
        return service.isValid(password);
    }
}
