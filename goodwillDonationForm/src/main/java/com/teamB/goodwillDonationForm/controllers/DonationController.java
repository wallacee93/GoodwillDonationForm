package com.teamB.goodwillDonationForm.controllers;

import com.teamB.goodwillDonationForm.exceptions.DonationNotFoundException;
import com.teamB.goodwillDonationForm.models.Donation;
import com.teamB.goodwillDonationForm.services.DonationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donation")
public class DonationController {

    private final Logger logger = LoggerFactory.getLogger(DonationController.class);

    private DonationService donationService;

    @Autowired
    public DonationController(DonationService widgetService){
        this.donationService = widgetService;
    }

    @PostMapping("/")
    public ResponseEntity<Donation> createWidgetRequest(@RequestBody Donation donation){
        Donation savedDonation = donationService.create(donation);
        ResponseEntity response = new ResponseEntity(savedDonation, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("/donations")
    public ResponseEntity<List<Donation>> getAllDonation(){
        List<Donation> donations = donationService.getAllDonation();
        ResponseEntity<List<Donation>> response = new ResponseEntity<>(donations, HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDonationById(@PathVariable Long id){
        try {
            Donation donation = donationService.getDonationbyId(id);
            ResponseEntity<?> response = new ResponseEntity<>(donation, HttpStatus.OK);
            return response;
        } catch (DonationNotFoundException donationNotFoundException) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }


}
