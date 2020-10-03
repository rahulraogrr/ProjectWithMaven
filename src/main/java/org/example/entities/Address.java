package org.example.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "STUDENT_ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private int addressId;

    @Column(name = "ADDRESS_1",length = 50)
    private String address1;

    @Column(name = "ADDRESS_2",length = 50)
    private String address2;

    @Column(name = "ADDRESS_3",length = 50, nullable = true)
    private String address3;

    @Column(name = "LANDMARK",length = 20)
    private String landmark;

    @Column(name = "CITY", length = 100)
    private String city;

    @Column(name = "STATE", length = 50)
    private String state;

    @Column(name = "COUNTRY", length = 30)
    private String country;

    @Column(name = "REGION", length = 20)
    private String region;

    @Column(name = "PINCODE", length = 6)
    private int pinCode;

    @Column(name = "IS_OPEN")
    private boolean isOpen;

    /**
     * If you mark a field as transient, hibernate will not persist the data into database
     */
    @Transient
    private double area;

    @Column(name = "ADDED_DATE")
    @Temporal(TemporalType.DATE)
    private Date addedDate;

    @Lob
    private byte[] image;

    public Address() {

    }

    public Address(String address1, String address2, String address3, String landmark, String city, String state, String country, String region, int pinCode, boolean isOpen, double area, Date addedDate, byte[] image) {
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.country = country;
        this.region = region;
        this.pinCode = pinCode;
        this.isOpen = isOpen;
        this.area = area;
        this.addedDate = addedDate;
        this.image = image;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", landmark='" + landmark + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", pinCode=" + pinCode +
                ", isOpen=" + isOpen +
                ", area=" + area +
                ", addedDate=" + addedDate +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
