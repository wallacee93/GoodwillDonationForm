package com.teamB.goodwillDonationForm.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "donation_type_id")
    private DonationType donationType;

    @ManyToOne
    @JoinColumn(name = "donors_id")
    private Donor donors;
=======
    private List<DonationType> donationType;
//Angie
    private List<Donor> donors;
>>>>>>> 4286b7c6f84db9fa3d7ef8e45c7118e0a7dd4587

    private String donationDate;

    public Donor getDonors() {
        return donors;
    }

    public Donation(){}

    public Donation(DonationType donationType, Donor donors, String donationDate){

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

    public DonationType getDonationType() {
        return donationType;
    }

    public void setDonationType(DonationType donationType) {
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
