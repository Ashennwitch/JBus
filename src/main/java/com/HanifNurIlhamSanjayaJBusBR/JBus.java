package com.HanifNurIlhamSanjayaJBusBR;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.concurrent.locks.StampedLock;
import static com.HanifNurIlhamSanjayaJBusBR.Algorithm.paginate;

import com.HanifNurIlhamSanjayaJBusBR.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Write a description of class JBus here.
 *
 * @author Hanif Nur Ilham Sanjaya
 * @version (a version number or a date)
 */
@SpringBootApplication
public class JBus {

    public static void main(String[] args) throws InterruptedException {
        JsonDBEngine.Run(JBus.class);
        SpringApplication.run(JBus.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));

        //testRegexForAccount();
        //testRegexForRenter();
        /*
        String filePath = "C:\\Users\\Hanif\\Documents\\DEV\\Praktikum OOP\\JBus\\data\\accountDatabase.json";

        try {
            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filePath);
            Account account1 = new Account("Hanif", "hanif24@gmail.com", "Qwerty90");
            tableAccount.add(account1);
            tableAccount.writeJson();

            System.out.println("Account ID: " + account1.id + " Name: " + account1.name +
                    " Email: " + account1.email + " Password: " + account1.password);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        Bus bus = createBus();
        bus.schedules.forEach(Schedule::printSchedule);
        for(int i =0; i < 10; i++){
            BookingThread thread = new BookingThread("Thread " + i,bus,
                    Timestamp.valueOf("2023-07-27 19:00:00"));
        }
        Thread.sleep(1000);
        bus.schedules.forEach(Schedule::printSchedule);
    }

    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus("Netlab Bus", Facility.LUNCH, price, 25,
                BusType.REGULER, City.BANDUNG, new Station("Depok Terminal", City.DEPOK, "Jl. Margonda Raya"),
                new Station("Halte UI", City.JAKARTA, "Universitas Indonesia"));
        Timestamp timestamp = Timestamp.valueOf("2023-07-27 19:00:00");
        bus.addSchedule(timestamp);
        return bus;
    }

    public static List<Bus> filterByDeparture(List<Bus> buses, City departure, int page, int pageSize) {
        List<Bus> filteredBuses = new ArrayList<>();

        // Filter buses by departure city
        for (Bus bus : buses) {
            if (bus.departure.city.equals(departure)) {
                filteredBuses.add(bus);
            }
        }

        // Calculate the start and end index for the specified page and pageSize
        int startIndex = page * pageSize;
        int endIndex = Math.min(startIndex + pageSize, filteredBuses.size());

        // Retrieve the buses for the specified page
        List<Bus> pageBuses = filteredBuses.subList(startIndex, endIndex);

        return pageBuses;

         */
    }

    public static List<Bus> filterByPrice(List<Bus> buses, int minPrice, int maxPrice) {
        List<Bus> filteredBuses = new ArrayList<>();

        for (Bus bus : buses) {
            if (bus.price.price >= minPrice && bus.price.price <= maxPrice) {
                filteredBuses.add(bus);
            }
        }

        return filteredBuses;
    }

    //bus.getId() == id)
    public static Bus filterBusId(List<Bus> buses, int id) {
        for (Bus bus : buses) {
            if (bus.id == id) {
                return bus;
            }
        }
        return null;
    }

    public static List<Bus> filterByDepartureAndArrival(List<Bus> buses, City departure, City arrival, int page, int pageSize) {
        Predicate<Bus> filterPredicate = bus -> bus.departure.city.equals(departure) && bus.arrival.city.equals(arrival);

        return paginate(buses, page, pageSize, filterPredicate);
    }

    /*// Method untuk test Regex
    public static void testRegexForAccount() {
        String[] validEmails = {
                "example@example.com",
                "myemail@mydomain.co",
                "user1234@company.net"
        };

        String[] invalidEmails = {
                "notanemail",
                "no@tld",
                "spaces @domain.com",
                "@no_username.com",
                "_rafieamandio@ui.ac.id",
                "hanif.sanjaya@gmail.com",
                "hanif-sanjaya@gmail.com",
                "as@gamil23.com"
        };

        String[] validPasswords = {
                "P@ssw0rd",
                "Secure123",
                "A1b2C3d4"
        };

        String[] invalidPasswords = {
                "weak",
                "12345678",
                "no_uppercase",
                "NO_LOWERCASE",
                "asd asdasd"
        };

        for (String email : validEmails) {
            boolean isValid = email.matches(Account.REGEX_EMAIL);
            System.out.println(email + " is valid: " + isValid);
        }

        for (String email : invalidEmails) {
            boolean isValid = email.matches(Account.REGEX_EMAIL);
            System.out.println(email + " is valid: " + isValid);
        }

        for (String password : validPasswords) {
            boolean isValid = password.matches(Account.REGEX_PASSWORD);
            System.out.println(password + " is valid: " + isValid);
        }

        for (String password : invalidPasswords) {
            boolean isValid = password.matches(Account.REGEX_PASSWORD);
            System.out.println(password + " is valid: " + isValid);
        }
    }

    public static void testRegexForRenter() {
        String[] validPhones = {
                "123456789",
                "123456789123",
                "99999999999"
        };

        String[] invalidPhones = {
                "1234567891234",
                "12abc3456",
                "12345678",
                "1234567890123",
                "abcde12345"
        };

        String[] validNames = {
                "John_Doe1234",
                "A_BC12345",
                "Xyz1234",
                "A_12",
                "Abcdefghijklmopqrst"
        };

        String[] invalidNames = {
                "1234Name",
                "Name with spaces",
                "Invalid#Name",
                "Abcdefghijklmopqrstu",
                "Abc"
        };

        for (String phone : validPhones) {
            boolean isValid = phone.matches(Renter.REGEX_PHONE);
            System.out.println(phone + " is valid: " + isValid);
        }

        for (String phone : invalidPhones) {
            boolean isValid = phone.matches(Renter.REGEX_PHONE);
            System.out.println(phone + " is valid: " + isValid);
        }

        for (String name : validNames) {
            boolean isValid = name.matches(Renter.REGEX_NAME);
            System.out.println(name + " is valid: " + isValid);
        }

        for (String name : invalidNames) {
            boolean isValid = name.matches(Renter.REGEX_NAME);
            System.out.println(name + " is valid: " + isValid);
        }
    }
*/
}
