package com.teamB.goodwillDonationForm.services;

import com.teamB.goodwillDonationForm.repo.DonationRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class DonationServiceTest {

    @MockBean
    private DonationRepo mockDonationRepo;

    @Autowired
    private DonationService donationService;

    @Test
    @DisplayName("Donation Service: Create Donation - Success")
    public void createDonationTestSuccess() {
    }

    @Test
    @DisplayName("Donation Service: Get Donation by Id - Success")
    public void getDonationByIdTestSuccess() {
    }

    @Test
    @DisplayName("Donation Service: Get All Donation- Success")
    public void getAllDonationTestSuccess() {
    }
}
