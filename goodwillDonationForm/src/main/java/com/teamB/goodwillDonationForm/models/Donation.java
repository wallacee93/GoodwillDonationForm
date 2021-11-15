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

    private String name;
    private List<DonationType> donationType;
    private String donationDate;

    public Donation(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return id.equals(donation.id) && name.equals(donation.name) && donationType.equals(donation.donationType) && donationDate.equals(donation.donationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, donationType, donationDate);
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", donationType=" + donationType +
                ", donationDate='" + donationDate + '\'' +
                '}';
    }
}
