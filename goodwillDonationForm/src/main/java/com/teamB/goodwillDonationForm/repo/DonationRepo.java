package com.teamB.goodwillDonationForm.repo;

import com.teamB.goodwillDonationForm.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepo extends JpaRepository<Donation, Long> {

}
