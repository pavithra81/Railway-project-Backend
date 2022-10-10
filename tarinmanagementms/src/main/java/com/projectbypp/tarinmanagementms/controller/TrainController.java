package com.projectbypp.tarinmanagementms.controller;



import com.projectbypp.tarinmanagementms.customexception.InvalidTrainDateException;
import com.projectbypp.tarinmanagementms.model.Train;
import com.projectbypp.tarinmanagementms.service.TrainService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@CrossOrigin( "*")
@RestController
@RequestMapping("/train")
public class TrainController {

    Logger logger= LoggerFactory.getLogger(TrainController.class);

    @Autowired
    private TrainService trainService;

    @PostMapping("/addtrain")

    public Train addtrain(@RequestBody Train train) {
        logger.info("[addtrain] info message added");
        return trainService.addtrain(train);

    }

    @GetMapping("/listalltrains")

    public List<Train> getTrains(){
        logger.info("[listalltrains] info message added");
        return trainService.getTrains();
    }

    @GetMapping("/viewtrainbyno/{trainId}")

    public Optional<Train> listTrain(@PathVariable("trainId") int trainId){
        logger.info("[viewtrainbyno/trainId] info message added");

        return trainService.listTrain(trainId);
    }









    @DeleteMapping("/delete/{trainId}")

    public String deleteTrain(@PathVariable("trainId") int trainId)
    {
        logger.info("[delete/trainId] info message added");
        trainService.deleteTrain(trainId);
        return "data deleted successfully";
    }
    @PutMapping("/update/{trainId}")

    public Train updateTrain(@RequestBody Train train,@PathVariable("trainId")int trainId)
    {
        logger.info("[update/trainId] info message added");
        return  trainService.updateTrain(trainId,train);
    }
   @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "HEAD", "DELETE"));
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }


    @GetMapping("/listalltrains/{destination}")
    public  List<Train> findByDest(@PathVariable("destination")String destination)
    {
        return trainService.findByDest(destination);
    }




}

