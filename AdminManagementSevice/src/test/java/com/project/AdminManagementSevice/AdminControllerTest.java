package com.project.AdminManagementSevice;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.project.AdminManagementSevice.controller.AdminController;
import com.project.AdminManagementSevice.model.Admin;
import com.project.AdminManagementSevice.service.AdminService;
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

import java.util.Optional;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AdminControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();

    @Mock
    private AdminService adminService;
    @InjectMocks
    private AdminController adminController;


    Admin admin_1 = new Admin( 1,"pavi","pavi1234", "pavi12@gmail.com","9874564567", "adcsfvhf");

    Admin admin_2 = new Admin( 2,"pavana","pavana1234", "shanta12@gmail.com", "9746310051", "adcggggf");

    Admin admin_3 = new Admin( 3,"surya","sunday675", "Surya12@gmail.com", "988563105", "rrrrrf");

    Admin admin_4 = new Admin( 4,"shanta","shantha456", "shanta@gmail.com", "988831005", "adkkkkhf");

    Admin admin_5 = new Admin( 5,"pavithra","pavithra2345", "pavithra12@gmail.com", "333563105", "sssshf");


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void getAdmin_success() throws Exception {
        when(adminService.view(admin_1.getAdminId())).thenReturn(java.util.Optional.of(admin_1));
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/admin/view/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void addAdmin_success() throws Exception{
        Admin record=Admin.builder()
                .adminId(1)
                .userName("pavithra")
                .password("pavi***1234")
                .email("pavi12@gmail.com")
                .phone("9874564567")
                .address("udupi")
                .build();

        when(adminService.add(record)).thenReturn(record);

        String content=objectWriter.writeValueAsString(record);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder=MockMvcRequestBuilders.post("/admin/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isOk());


    }

    @Test
    public void updateAdmin_success() throws Exception{
        Admin updateRecord= Admin.builder()
                .adminId(1)
                .userName("pavithra")
                .password("pavii***1234")
                .email("pavi2@gmail.com")
                .phone("9874564567")
                .address("udupi")
                .build();


        when(adminService.updateAdmin(admin_1.getAdminId(),updateRecord)).thenReturn(updateRecord);

        String updatedContent= objectWriter.writeValueAsString(updateRecord);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder=MockMvcRequestBuilders.put("/admin/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(updatedContent);

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isOk());


    }

    @Test
    public void deleteAdmin_success() throws Exception{
        willDoNothing().given(adminService).deleteAdmin(admin_4.getAdminId());
        ResultActions resultActions = mockMvc.perform(delete("/admin/delete/" + admin_4.getAdminId()));
        resultActions.andExpect(status().isOk())
                .andDo(print());

    }



}
