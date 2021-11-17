package com.teamB.goodwillDonationForm.controllers;


import com.teamB.goodwillDonationForm.BaseControllerTest;
import com.teamB.goodwillDonationForm.models.Donation;
import com.teamB.goodwillDonationForm.models.DonationType;
import com.teamB.goodwillDonationForm.models.Donor;
import com.teamB.goodwillDonationForm.services.DonationService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class DonationControllerTest extends BaseControllerTest {

    @MockBean
    private DonationService mockDonationService;

    @Autowired
    private MockMvc mockMvc;

    private Donation inputDonation;
    private Donation mockResponseDonation1;
    private Donation mockResponseDonation2;
    private List<Donation> mockDonationsList;


    @BeforeEach
    public void setUp(){

        Donor donor = new Donor("Marty", " 112 French Street", 2001);

        DonationType donationType = new DonationType("clothes", 5);

        inputDonation = new Donation(donationType, donor,  "11/27/2000");
        inputDonation.setId(3L);

        mockResponseDonation1 = new Donation(donationType, donor, "11/27/1998" );
        mockResponseDonation1.setId(1L);

        mockResponseDonation2 = new Donation(donationType, donor, "12/12/1978");
        mockResponseDonation2.setId(2L);

        mockDonationsList = new ArrayList<>();
        mockDonationsList.add(mockResponseDonation1);
        mockDonationsList.add(mockResponseDonation2);
    }

    @Test
    @DisplayName("Donation Post: /donation/ - success")
    public void createDonationRequestSuccess() throws Exception {

        Donor donor1 = new Donor("Marty", " 112 French Street", 2001);

        DonationType donationType1 = new DonationType("clothes", 5);

        BDDMockito.doReturn(mockResponseDonation1).when(mockDonationService).create(any());

        mockMvc.perform(MockMvcRequestBuilders.post("/donation/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(inputDonation)))

                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.donationType", Is.is(donationType1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.donors", Is.is(donor1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.donationDate", Is.is("11/27/2000")));
    }

    @Test
    @DisplayName("GET /donations/1 - Found")
    public void getWidgetByIdTestSuccess() throws Exception{

        BDDMockito.doReturn(mockResponseDonation1).when(mockDonationService).getDonationbyId(1L);

        mockMvc.perform(get("/donation/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName(("GET all /donation/donations - Success"))
    public void getAllDonationsSuccess() throws Exception{

        BDDMockito.doReturn(mockDonationsList).when(mockDonationService).getAllDonation();

        mockMvc.perform(MockMvcRequestBuilders.get("/donation/donations"))
                .andExpect(status().isOk());


    }
}
