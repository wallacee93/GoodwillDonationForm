package com.teamB.goodwillDonationForm.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;
    private Integer taxYear;

    public Donor(){}
    public Donor (String name, String address, Integer taxYear){
        this.name = name;
        this.address = address;
        this.taxYear = taxYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTaxYear() {
        return taxYear;
    }

    public void setTaxYear(Integer taxYear) {
        this.taxYear = taxYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donor donor = (Donor) o;
        return id.equals(donor.id) && name.equals(donor.name) && address.equals(donor.address) && taxYear.equals(donor.taxYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, taxYear);
    }

    @Override
    public String toString() {
        return "Donor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", taxYear=" + taxYear +
                '}';
    }
}
