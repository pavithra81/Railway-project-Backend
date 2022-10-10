package com.projectbypp.usermanagementmicroservices.service;


import com.projectbypp.usermanagementmicroservices.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class TrainService {
    @Autowired
    private RestTemplate restTemplate;



    public ResponseEntity<Train[]> findBySourceDestDate(String source, String destination, String Tdate) throws HttpClientErrorException {
        Train[] response= restTemplate.getForEntity("http://Train-management-service/train/findby/"+source +"/" +destination+ "/" +Tdate,
                Train[].class).getBody();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
