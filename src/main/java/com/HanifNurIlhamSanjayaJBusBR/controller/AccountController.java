package com.HanifNurIlhamSanjayaJBusBR.controller;
import com.HanifNurIlhamSanjayaJBusBR.Account;
import com.HanifNurIlhamSanjayaJBusBR.dbjson.JsonAutowired;
import com.HanifNurIlhamSanjayaJBusBR.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    @JsonAutowired(value = Account.class, filepath = "../account_db.json")
    public static JsonTable<Account> accountTable;

    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        return new Account(name, email, password);
    }

    @GetMapping("/{id}")
    String getById(@PathVariable int id) { return "account id " + id + " not found!"; }

    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    BaseResponse<Account> register(
            @RequestParam String name, String email, String
            ) {
        if (BaseResponse.name.isBlank()) {
            return new BaseResponse<>(false, "Nama tidak boleh kosong", null);
        }

        // Check if email and password match the regex
        if (!Account.validate(email, password)) {
            return new BaseResponse<>(false, "Email atau password tidak sesuai kriteria", null);
        }
    }

    BaseResponse<Double> topUp(int, double) {

    }

    BaseResponse<Account> login(String, String) {

    }

    BaseResponse<Account> login(String, String) {

    }

    BaseResponse<Renter> registerRenter(int, String, String, String) {

    }

}
