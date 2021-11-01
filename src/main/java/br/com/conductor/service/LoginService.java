package br.com.conductor.service;


import br.com.conductor.utils.LoginUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);

    public ResponseEntity<Object> isValid(String password){
        boolean isValid = LoginUtils.getInstance().isValid(password);
        return new ResponseEntity<Object>(isValid, HttpStatus.OK);
    }

}
