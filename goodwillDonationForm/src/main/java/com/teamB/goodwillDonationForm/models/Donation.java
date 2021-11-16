package com.teamB.goodwillDonationForm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private List<DonationType> donationType;

    private List<Donor> donors;

    private String donationDate;

    public Donation(){}

    public Donation(List<DonationType> donationType, List<Donor> donors, String donationDate){

        this.donationType = donationType;
        this.donors = donors;
        this.donationDate = donationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DonationType> getDonationType() {
        return donationType;
    }

    public void setDonationType(List<DonationType> donationType) {
        this.donationType = donationType;
    }

    public String getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(String donationDate) {
        this.donationDate = donationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return id.equals(donation.id) && donationType.equals(donation.donationType) && donationDate.equals(donation.donationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, donationType, donationDate);
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", donationType=" + donationType +
                ", donationDate='" + donationDate + '\'' +
                '}';
    }
}
