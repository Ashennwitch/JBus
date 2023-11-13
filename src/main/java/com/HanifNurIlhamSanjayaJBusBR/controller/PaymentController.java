package com.HanifNurIlhamSanjayaJBusBR.controller;

import com.HanifNurIlhamSanjayaJBusBR.*;
import com.HanifNurIlhamSanjayaJBusBR.controller.BaseResponse;
import com.HanifNurIlhamSanjayaJBusBR.dbjson.JsonAutowired;
import com.HanifNurIlhamSanjayaJBusBR.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {

    @JsonAutowired(value = Payment.class, filepath = "C:\\Users\\Hanif\\Documents\\DEV\\Praktikum OOP\\JBus\\src\\main\\java\\com\\HanifNurIlhamSanjayaJBusBR\\dbjson\\payment.json")
    public static JsonTable<Payment> paymentTable;

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @RequestMapping(value = "/makeBooking", method = RequestMethod.POST)
    public BaseResponse<Payment> makeBooking(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int busId,
            @RequestParam List<String> busSeats,
            @RequestParam String departureDate
    ) {
        // Find the buyer account
        Account buyer = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == buyerId && acc.company != null);

        // Find the bus
        Bus bus = Algorithm.<Bus>find(BusController.busTable, b -> b.id == busId && b.accountId == renterId);

        // Check if buyer and bus are not null
        if (buyer == null || bus == null) {
            return new BaseResponse<>(false, "Invalid buyer or bus", null);
        }

        // Calculate the total price based on the number of seats booked


        // Check if buyer has sufficient balance
        double totalPrice = bus.price.price;
        if (buyer.balance < totalPrice)
            return new BaseResponse<>(false, "Booking gagal dibuat: Saldo tidak mencukupi", null);

        // Parse departureDate to Timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate;
        try {
            parsedDate = dateFormat.parse(departureDate);
        } catch (ParseException e) {
            return new BaseResponse<>(false, "Invalid departure date format", null);
        }

        Timestamp departureTimestamp = new Timestamp(parsedDate.getTime());

        Schedule schedule = Algorithm.<Schedule>find(bus.schedules, s -> s.departureSchedule.equals(departureTimestamp));
        if (schedule == null)
            return new BaseResponse<>(false, "Booking gagal dibuat: Schedule tidak ditemukan/tersedia", null);
        if (!schedule.isSeatAvailable(busSeats))
            return new BaseResponse<>(false, "Booking gagal dibuat: Kursi tidak tersedia", null);
        if (!Payment.makeBooking(departureTimestamp, busSeats, bus))
            return new BaseResponse<>(false, "Booking gagal dibuat: Booking gagal ", null);

        // Make booking
        boolean bookingSuccess = Payment.makeBooking(departureTimestamp, busSeats, bus);

        if (!bookingSuccess) {
            return new BaseResponse<>(false, "Booking failed", null);
        }

        // Update buyer balance
        buyer.topUp(-totalPrice);

        // Create a new Payment object with status WAITING
        Payment payment = new Payment(buyerId, renterId, busId, busSeats, departureTimestamp);
        payment.status = Invoice.PaymentStatus.WAITING;

        // Add the payment to the paymentTable
        paymentTable.add(payment);

        return new BaseResponse<>(true, "Booking successful", payment);
    }

    @PostMapping(value = "/{id}/accept")
    public BaseResponse<Payment> processAcceptance(@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pay -> pay.id == id);
        if (payment == null)
            return new BaseResponse<>(false, "Gagal menerima pembayaran: Pembayaran tidak ditemukan", null);
        payment.status = Invoice.PaymentStatus.SUCCESS;
        return new BaseResponse<>(true, "Penerimaan pembayaran berhasil", payment);
    }

    @PostMapping(value = "/{id}/cancel")
    public BaseResponse<Payment> processCancellation(@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pay -> pay.id == id);
        if (payment == null)
            return new BaseResponse<>(false, "Gagal membatalkan pembayaran: Pembayaran tidak ditemukan", null);
        payment.status = Invoice.PaymentStatus.FAILED;
        return new BaseResponse<>(true, "Pembatalan pembayaran berhasil", payment);
    }

}
