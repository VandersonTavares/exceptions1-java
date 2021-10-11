package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Excepptions1 {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        int roomNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Check-In date (dd/MM/yyyy)");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-Out date (dd/MM/yyyy)");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check-In date (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-Out date (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());

            //data atual
            Date agora = new Date();
            if (checkIn.before(agora) || checkOut.before(agora)) {
                System.out.println("Error in Reservation: Reservation dates for update must be future dates");
            } else if(!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: check-out date must be after check-in date");
            }else{
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }

        }
        sc.close();
    }

}
