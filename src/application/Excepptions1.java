package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

public class Excepptions1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Room number: ");
            int roomNumber = sc.nextInt();
            sc.nextLine();
            System.out.println("Check-In date (dd/MM/yyyy)");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Check-Out date (dd/MM/yyyy)");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check-In date (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-Out date (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        } catch(DomainException e){
            System.out.println("Error in Reservation "+e.getMessage());
        }     //captura qualquer exception ex.: digitado texto ao inves de numero
        catch(RuntimeException e){
            System.out.println("Unexpected error");
        }

        sc.close();
    }

}
