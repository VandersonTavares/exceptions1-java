package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    //static pra nao seja instanciado um novo para cada objeto reservation que tiver
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }
    /* Tem método para fazer isso
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }
    */
    public Date getCheckOut() {
        return checkOut;
    }

    /*Tem método para fazer isso
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
    */
    
    //esquema para calcular a data vai retornar um long
    public long duration(){
        //- pego a diferença entre as dadas em milisegundos 
        long diff = checkOut.getTime() - checkIn.getTime(); //getTime, retorna a quantidade de ms daquela data 
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte o diff que está em miliseconds em dias
    }

    public void updateDates(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                +roomNumber
                +", CheckIn"
                +sdf.format(checkIn)
                +", CheckOut"
                +sdf.format(checkOut)
                +", "
                +duration()
                +" nights";
    }
   
}
