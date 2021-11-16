package com.teamB.goodwillDonationForm.services;

import com.teamB.goodwillDonationForm.exceptions.DonationNotFoundException;
import com.teamB.goodwillDonationForm.models.Donation;
import com.teamB.goodwillDonationForm.repos.DonationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationServiceImpl implements DonationService {

    private static Logger logger = LoggerFactory.getLogger(DonationServiceImpl.class);

    private DonationRepo donationRepo;

    @Autowired
    public DonationServiceImpl(DonationRepo donationRepo){

        this.donationRepo = donationRepo;
    }

    @Override
    public Donation create(Donation donation) {
        Donation savedDonation = donationRepo.save(donation);
        return savedDonation;
    }

    @Override
    public Donation getDonationbyId(Long id) throws DonationNotFoundException {
        Optional<Donation> donationOptional = donationRepo.findById(id);
        if(donationOptional.isEmpty()){
            logger.error("Donation with id {} does not exist", id);
            throw new DonationNotFoundException("Donation not found");
        }
        return donationOptional.get();
    }

    @Override
    public List<Donation> getAllDonation() {
        return donationRepo.findAll();
    }
}
