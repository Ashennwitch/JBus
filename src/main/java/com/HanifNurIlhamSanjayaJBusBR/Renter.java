package com.HanifNurIlhamSanjayaJBusBR;

import com.HanifNurIlhamSanjayaJBusBR.dbjson.Serializable;

public class Renter extends Serializable {
    private static final String REGEX_PHONE = "^[0-9]{9,12}$";
    private static final String REGEX_NAME = "^[A-Z][A-Z0-9_]{3,19}$";
    public String address;
    public String companyName;
    public String phoneNumber;

    public Renter(String companyName) {
        super();
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = "";
    }

    public Renter(String companyName, String phoneNumber) {
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = "";
    }

    public Renter(String companyName, String phoneNumber, String address) {
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean validate() {
        boolean isNameValid = companyName.matches(REGEX_NAME);
        boolean isPhoneValid = phoneNumber.matches(REGEX_PHONE);

        return isNameValid && isPhoneValid;
    }
}
