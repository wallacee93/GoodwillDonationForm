package com.teamB.goodwillDonationForm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class DonationType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;
    private Integer quantity;

    public DonationType(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonationType that = (DonationType) o;
        return id.equals(that.id) && type.equals(that.type) && quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, quantity);
    }

    @Override
    public String toString() {
        return "DonationType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
