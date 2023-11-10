package com.HanifNurIlhamSanjayaJBusBR.controller;

import com.HanifNurIlhamSanjayaJBusBR.Account;
import com.HanifNurIlhamSanjayaJBusBR.Algorithm;
import com.HanifNurIlhamSanjayaJBusBR.Renter;
import com.HanifNurIlhamSanjayaJBusBR.controller.BasicGetController;
import com.HanifNurIlhamSanjayaJBusBR.controller.BaseResponse;
import com.HanifNurIlhamSanjayaJBusBR.dbjson.JsonAutowired;
import com.HanifNurIlhamSanjayaJBusBR.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.springframework.util.DigestUtils.md5Digest;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {

    @JsonAutowired(value = Account.class, filepath = "../account_db.json")
    public static JsonTable<Account> accountTable;

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/register")
    public BaseResponse<Account> register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {
        // Create an Account object
        Account account = new Account(name, email, password);

        // Check if name is not blank
        if (account.name.isBlank()) {
            return new BaseResponse<>(false, "Gagal register: Nama tidak boleh kosong", null);
        }

        // Validate email and password using regex
        if (!account.validate()) {
            return new BaseResponse<>(false, "Gagal register: Format email atau password tidak sesuai", null);
        }
        //bus -> bus.departure.city.equals(departure)
        // Check if email is unique
        if (Algorithm.<Account>exists(accountTable, acc -> account.email.equals(account.email))) {
            return new BaseResponse<>(false, "Gagal register: Email sudah terdaftar", null);
        }

        // Hash the password using MD5 algorithm
        // Set the hashed password to the account
        account.password = md5Digest(account.password);

        // Add the account to the table
        accountTable.add(account);

        return new BaseResponse<>(true, "Berhasil register", account);
    }

    @PostMapping("/login")
    public BaseResponse<Account> login(
            @RequestParam String email,
            @RequestParam String password
    ) {

        // Check if email is not blank
        if (email.isBlank()) {
            return new BaseResponse<>(false, "Gagal login: Email tidak boleh kosong", null);
        }

        // Check if password is not blank
        if (password.isBlank()) {
            return new BaseResponse<>(false, "Gagal login: Password tidak boleh kosong", null);
        }

        // Find the account based on the provided email
        Account account = Algorithm.<Account>find(accountTable, acc -> email.equals(email));
       //acc -> account.email.equals(account.email))
        // Check if the account is found
        if (account == null) {
            return new BaseResponse<>(false, "Gagal login: Akun tidak ditemukan", null);
        }

        // Hash the provided password using MD5 algorithm
        String hashedPassword = md5Digest(password);

        // Check if the hashed password matches the stored hashed password
        if (!hashedPassword.equals(account.password)) {
            return new BaseResponse<>(false, "Gagal login: Password salah", null);
        }

        // Return successful response with the account as payload
        return new BaseResponse<>(true, "Berhasil login", account);
    }

    @PostMapping("/{id}/registerRenter")
    public BaseResponse<Renter> registerRenter(
            @PathVariable int id,
            @RequestParam String companyName,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ) {
        // Find the account based on the provided id
        Account account = Algorithm.<Account>find(accountTable, acc -> acc.id == id);

        // Check if the account is found
        if (account == null) {
            return new BaseResponse<>(false, "Gagal registrasi renter: Akun tidak ditemukan", null);
        }

        // Check if the account is already a renter
        if (account.company != null) {
            return new BaseResponse<>(false, "Gagal registrasi renter: Akun sudah terdaftar sebagai renter", null);
        }

        // Create a new Renter
        Renter renter = new Renter(companyName, address, phoneNumber);

        // Set the renter for the account
        account.company = renter;

        // Return successful response with the newly created renter as payload
        return new BaseResponse<>(true, "Berhasil registrasi renter", renter);
    }

    @PostMapping("/{id}/topUp")
    public BaseResponse<Double> topUp(@PathVariable int id, @RequestParam double amount) {
        // Find the account based on the provided id
        Account account = Algorithm.<Account>find(accountTable, acc -> acc.id == id);
        // Algorithm.find(accountTable, acc -> id.equals(id))

        // Check if the account is found
        if (account != null) {
            // Perform the top-up
            boolean success = account.topUp(amount);

            // Check if the top-up was successful
            if (success) {
                return new BaseResponse<>(true, "Top-up successful", amount);
            } else {
                return new BaseResponse<>(false, "Top-up failed. Please provide a positive amount.", null);
            }
        } else {
            return new BaseResponse<>(false, "Account not found", null);
        }
    }

    private String md5Digest(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
