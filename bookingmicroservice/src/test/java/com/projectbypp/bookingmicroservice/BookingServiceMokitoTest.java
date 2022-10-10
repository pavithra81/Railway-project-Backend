package com.projectbypp.bookingmicroservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.projectbypp.bookingmicroservice.controller.BookingController;
import com.projectbypp.bookingmicroservice.service.BookingService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;



@RunWith(MockitoJUnitRunner.Silent.class)
public class BookingServiceMokitoTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();
    @Mock
    BookingService bookingService;
    @InjectMocks
    BookingController bookingController;
/*
    Passengers pass_1 = new Passengers("pavana", 45, "female");

    Passengers pass_2 = new Passengers("pav", 4, "female");

    List<Passengers> pass_list_1 = new ArrayList(Arrays.asList(pass_1, pass_2));


    Booking record_1 = new Booking(1, 2, "manglore express", 1, "pavithra", "pav@gmail.com", "9898989898", "9:0:8", "8:9:9", "Banglore", "manglore", "ac", 4, 900, pass_list_1);
    Booking record_2 = new Booking(2, 2, "manglore express", 1, "pavithra", "pav@gmail.com", "9898989898", "9:0:8", "8:9:9", "Banglore", "manglore", "ac", 4, 900, pass_list_1);
    Booking record_3 = new Booking(3, 2, "manglore express", 1, "pavithra", "pav@gmail.com", "9898989898", "9:0:8", "8:9:9", "Banglore", "manglore", "ac", 4, 900, pass_list_1);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();
    }
   /* @Test
    public void bookingView_success() throws Exception{
        List<Booking> records=new ArrayList<>(Arrays.asList(record_1,record_2));

        when(bookingService.getorders()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/order/listallorders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));

    }*/

  /*  @Test
    public void addorder_success() throws Exception{
        Booking record= Booking.builder()
                .bookingId(6)
                //.trainId(9)
                .trainName("Mumbai")
                .passengerId(9)
                .passengerName("Pav")
                .email("pav@gmail.com")
                .phone("9898989898")
                .bookingDate("9:0:9")
                .journeyDate("9:0:0")
                .sourceStation("manglore")
                .destinationStation("banglore")
                .trainClass("ac")
               // .seatCount(9)
                .price(9000.0)
                .passengers(pass_list_1)
                .build();

        when(bookingService.addorder(record)).thenReturn(record);

        String content=objectWriter.writeValueAsString(record);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder=MockMvcRequestBuilders.post("/order/addorder")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()));
    }
    @Test
    public void deleteOrder_success() throws Exception {
        willDoNothing().given(bookingService).deleteOrder(record_2.getBookingId());
        ResultActions resultActions = mockMvc.perform(delete("/order/del/1" + record_2.getBookingId()));
        resultActions.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getBookingById_success() throws Exception{
        when(bookingService.listOrder(record_2.getTrainId())).thenReturn(java.util.Optional.of(record_2));
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/order/listby/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
*/


}