package com.project.AdminManagementSevice.service;

import com.project.AdminManagementSevice.model.Train;
import com.project.AdminManagementSevice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<User[]> viewUsers() throws HttpClientErrorException {
        User[] response= restTemplate.getForEntity("/user/viewusers"
                ,User[].class).getBody();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
