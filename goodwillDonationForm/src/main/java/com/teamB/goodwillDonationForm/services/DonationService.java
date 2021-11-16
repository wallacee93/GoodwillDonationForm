package com.teamB.goodwillDonationForm.services;

import com.teamB.goodwillDonationForm.exceptions.DonationNotFoundException;
import com.teamB.goodwillDonationForm.models.Donation;

import java.util.List;

public interface DonationService {

    Donation create (Donation donation);// interface with Donation class to create id's for donors

    Donation getDonationbyId(Long id) throws DonationNotFoundException;

    List<Donation> getAllDonation();

}
