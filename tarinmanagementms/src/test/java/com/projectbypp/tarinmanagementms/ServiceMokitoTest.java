package com.projectbypp.tarinmanagementms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.projectbypp.tarinmanagementms.controller.TrainController;
import com.projectbypp.tarinmanagementms.model.Train;
import com.projectbypp.tarinmanagementms.service.TrainService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ServiceMokitoTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();

    @Mock
    private TrainService trainService;
    @InjectMocks
    private TrainController trainController;




    Train train_1=new Train(5,"MangaloreJN","Puttur-JN","MYSURU-JN","09:09:00", "15:00:00", 600,"genral", 400);
    Train train_2=new Train(5,"MangaloreJN","Puttur-JN","MYSURU-JN","09:09:00", "15:00:00", 600,"genral", 400);
    Train train_5=new Train(5,"MangaloreJN","Puttur-JN","MYSURU-JN","09:09:00", "15:00:00", 600,"genral", 400);
    Train train_4=new Train(5,"MangaloreJN","Puttur-JN","MYSURU-JN","09:09:00", "15:00:00", 600,"genral", 400);
    Train train_3=new Train(5,"MangaloreJN","Puttur-JN","MYSURU-JN","09:09:00", "15:00:00", 600,"genral", 400);
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(trainController).build();
    }

    @Test
    public void getTrains_success() throws Exception{
        List<Train> records=new ArrayList<>(Arrays.asList(train_1,train_2,train_3,train_4,train_5));

        when(trainService.getTrains()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/train/listalltrains")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    public void getTrainById_success() throws Exception{
        when(trainService.listTrain(train_1.getTrainId())).thenReturn(java.util.Optional.of(train_1));
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/train/viewtrainbyno/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }


    @Test
    public void addTrain_success() throws Exception{
        Train record= Train.builder()
                .trainId(6)
                .trainName("Mumbai-JNC")
                .source("Pune")
                .destination("Patna")
                .price(150)
                .timeOfArrival("14:00:00")
                .timeOfDeparture("04:20:00")

                .totalNumOfSeats(200)
                .className("SLEEPER")

                .build();

        when(trainService.addtrain(record)).thenReturn(record);

        String content=objectWriter.writeValueAsString(record);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder=MockMvcRequestBuilders.post("/train/addtrain")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isOk());

    }


    @Test
    public void updateTrain_success() throws Exception{
        Train updateRecord= Train.builder()
                .trainId(1)
                .trainName("Mangaluru JN")
                .source("Puttur-JN")
                .destination("udupi-JN")
                .price(150)
                .timeOfArrival("14:00:00")
                .timeOfDeparture("04:20:00")

                .totalNumOfSeats(200)
                .className("SLEEPER")
                .build();

        when(trainService.updateTrain(train_1.getTrainId(),updateRecord)).thenReturn(updateRecord);

        String updatedContent= objectWriter.writeValueAsString(updateRecord);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder=MockMvcRequestBuilders.put("/train/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(updatedContent);

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isOk());



    }


    @Test
    public void deleteTrain_success() throws Exception{
        willDoNothing().given(trainService).deleteTrain(train_4.getTrainId());
        ResultActions resultActions = mockMvc.perform(delete("/train/delete/4" + train_4.getTrainId()));
        resultActions.andExpect(status().isOk())
                .andDo(print());

    }


}
