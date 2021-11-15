package com.teamB.goodwillDonationForm.services;

import com.teamB.goodwillDonationForm.models.Donation;
import com.teamB.goodwillDonationForm.models.DonationType;
import com.teamB.goodwillDonationForm.repo.DonationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {
    private static Logger logger = LoggerFactory.getLogger(DonationServiceImpl.class);
    private DonationRepo donationRepo;

    @Autowired
    public DonationServiceImpl (DonationRepo donationRepo) {
        this.donationRepo = donationRepo;
    }
    @Override
    public Donation create(Donation donation) {
        return null;
    }

    @Override
    public Donation getDonationById(Long id) {
        return null;
    }

    @Override
    public List<Donation> getAllDonation() {
        return null;
    }
}
