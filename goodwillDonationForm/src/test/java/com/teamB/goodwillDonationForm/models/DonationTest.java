package com.teamB.goodwillDonationForm.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DonationTest {

    private Donation donation;
    private Donation donation1;

    private Donation emptyDonation;
    private Donation emptyDonation1;

    @BeforeEach
    public void setUp(){
        emptyDonation = new Donation();
        emptyDonation1 = new Donation();

        List<DonationType> donationTypes = new ArrayList<>();
        donationTypes.add(new DonationType("clothes", 5));
        donationTypes.add(new DonationType("chairs", 3));

        List<Donor> donors = new ArrayList<>();
        donors.add(new Donor("Marty", " 112 French Street", 2001));
        donors.add(new Donor("Tommy", " 114 French Street", 2010));

        donation = new Donation(donationTypes, donors, "11/21/2020");
        donation.setId(1L);

        donation1 = new Donation(donationTypes, donors, "10/21/2020");
        donation1.setId(2L);
    }

    @Test
    public void testEmptyEquals() throws Exception {

        assertTrue(
                emptyDonation.equals(emptyDonation1),
                "Both empty Donation instances should be equal");
    }

    @Test
    public void testContentEquals() throws Exception {

        assertTrue(
                donation.equals(donation1),
                "Both non-empty Donation instances should be equal");
    }

    @Test
    public void testNotEquals() throws Exception {

        assertFalse(
                emptyDonation.equals(donation),
                "The Donation instances should not be equal");
    }

    @Test
    public void testEmptyHashCode() throws Exception {

        assertEquals(
                emptyDonation.hashCode(),
                emptyDonation1.hashCode(),
                "Both empty Donation instances should have the same hashCode");
    }

    @Test
    public void testContentHashCode() throws Exception {

        assertEquals(
                donation.hashCode(),
                donation1.hashCode(),
                "Both non-empty Donation instances should have the same hashCode");
    }

    @Test
    public void testHashCode() throws Exception {

        assertNotEquals(
                emptyDonation.hashCode(),
                donation1.hashCode(),
                "The Donation instances should not have the same hashCode");
    }

    @Test
    public void testEmptyToString() throws Exception {

        assertEquals(
                donation.toString(),
                donation1.toString(),
                "Both empty Donation instances should have the same toString");
    }

    @Test
    public void testContentToString() throws Exception {

        assertEquals(
                donation.toString(),
                donation1.toString(),
                "Both non-empty Donation instances should have the same toString");
    }

    @Test
    public void testNotToString() throws Exception {

        assertNotEquals(
                emptyDonation.toString(),
                donation1.toString(),
                "The Donation instances should not have the same toString");
    }
}
