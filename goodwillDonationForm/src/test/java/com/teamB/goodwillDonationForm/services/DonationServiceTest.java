package com.teamB.goodwillDonationForm.services;

import com.teamB.goodwillDonationForm.exceptions.DonationNotFoundException;
import com.teamB.goodwillDonationForm.models.Donation;
import com.teamB.goodwillDonationForm.models.DonationTest;
import com.teamB.goodwillDonationForm.models.DonationType;
import com.teamB.goodwillDonationForm.models.Donor;
import com.teamB.goodwillDonationForm.repos.DonationRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DonationServiceTest {

        @MockBean
        private DonationRepo mockDonationRepo;

        @Autowired
        private DonationService donationService;

        private Donation mockDonation1;
        private Donation mockDonation2;
        private Donation inputDonation;

    //    public DonationServiceTest(DonationRepo mockDonationRepo) {
    //        this.mockDonationRepo = mockDonationRepo;
    //    }

        @BeforeEach
        public void setUp(){

            List<Donor> donors = new ArrayList<>();
            donors.add(new Donor("Marty", " 112 French Street", 2001));

            List<DonationType>donationTypes = new ArrayList<>();
            donationTypes.add(new DonationType("clothes", 5 ));

            inputDonation = new Donation(donationTypes, donors,  "11/27/2000" );

            mockDonation1 = new Donation(donationTypes, donors, "11/27/1998" );
            mockDonation1.setId(1L);

            mockDonation2 = new Donation(donationTypes, donors, "12/12/1978");
            mockDonation2.setId(2L);

        }

        @Test
        @DisplayName("Donation Service: Create Donation - Success")
        public void createDonationTestSuccess() {
            BDDMockito.doReturn(mockDonation1).when(mockDonationRepo).save(ArgumentMatchers.any());
            Donation returnedDonation = donationService.create(inputDonation);
            Assertions.assertNotNull(returnedDonation, "Donation should not be null");
            Assertions.assertEquals(returnedDonation.getId(),1 );
        }

        @Test
        @DisplayName("Donation Service: Get Donation by Id - Success")
        public void getDonationByIdTestSuccess() throws DonationNotFoundException {
            BDDMockito.doReturn(Optional.of(mockDonation1)).when(mockDonationRepo).findById(1L);
            Donation foundDonation = donationService.getDonationbyId(1L);
            Assertions.assertEquals(mockDonation1.toString(), foundDonation.toString());
        }

        @Test
        @DisplayName("Donation Service: Get All Donation- Success")
        public void getAllDonationTestSuccess() {
            List<Donation> donations = new ArrayList<>();
            donations.add(mockDonation1);
            donations.add(mockDonation2);

            BDDMockito.doReturn(donations).when(mockDonationRepo).findAll();

            List<Donation> responseDonations = donationService.getAllDonation();
            Assertions.assertIterableEquals(donations,responseDonations);
        }
}
