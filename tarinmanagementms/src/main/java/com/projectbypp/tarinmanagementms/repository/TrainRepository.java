package com.projectbypp.tarinmanagementms.repository;


import com.projectbypp.tarinmanagementms.model.Train;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TrainRepository extends MongoRepository<Train, Integer> {

    @Query("{'route.stationName':?0,destination:?1,daysOfRunning:?2}")
    List<Train> search(String source, String destination, String daysOfRunning);

    @Query("{destination:?0}")
    List<Train> findByDest(String destination);
}


