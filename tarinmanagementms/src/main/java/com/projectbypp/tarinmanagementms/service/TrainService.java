package com.projectbypp.tarinmanagementms.service;


import com.projectbypp.tarinmanagementms.model.Train;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public interface TrainService {

    public  Train addtrain(Train train);
    public List<Train> getTrains();
    public Optional<Train> listTrain(int trainId);




    public void deleteTrain(int trainId);
    public Train updateTrain(int trainId,Train train);


    List<Train> findByDest(String destination);
}
