package com.example.criandoexcecoespersonalizadas.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    //Declarando como static, para não ser instanciado toda vez que tiver um novo objeto reservation
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Reservation(){

    }

    public Reservation(Integer roomNumber, Date checkin, Date checkout){
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }
    public Integer getRoomNumber(){
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber){
        this.roomNumber = roomNumber;
    }

    public Date getCheckin(){
        return checkin;
    }

    public Date getCheckout(){
        return checkout;
    }

    //long - inteiro mais longo.
    public long duration(){
        //getTime() - Devolve a quantidade de milessigundos daquela data.
        //pegando a diferança das duas datas em milissegundos.
        long diff = checkout.getTime() - checkin.getTime();
        //convertendo milessegundos para dias.
         return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    //Sempre colocar Override no ToString
    @Override
    public String toString(){
        return "Reservation: Room "
                + roomNumber
                + " Check-In: "
                + sdf.format(checkin)
                + ", Check-Out: "
                + sdf.format(checkout)
                +duration()
                + " nights";
    }
}
