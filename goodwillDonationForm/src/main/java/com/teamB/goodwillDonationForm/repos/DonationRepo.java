package com.teamB.goodwillDonationForm.repos;

import com.teamB.goodwillDonationForm.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepo extends JpaRepository<Donation, Long> {

}
