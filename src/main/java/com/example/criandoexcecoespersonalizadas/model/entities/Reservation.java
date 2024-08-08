package com.example.criandoexcecoespersonalizadas.model.entities;

import com.example.criandoexcecoespersonalizadas.model.exception.DomainException;

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

    public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException{
        if (!checkout.after(checkin)) {
            throw new DomainException("Check-Out date must be after check-in date") ;
        }
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

    public void updateDates(Date checkIn, Date checkOut) throws DomainException{

        Date now = new Date();
        //validação se a date de CheckIn foi atualizado para depois da data da primeira reserva-
        if (checkIn.before(now) || checkOut.before(now)) {
            /*lançando uma exceção, caso a verificação entre no if.
            IllegalArgumentException - para tradar metodos da exceção.
            DomainException - Exceção criada.*/

            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check-Out date must be after check-in date") ;
        }
        this.checkin = checkin;
        this.checkout = checkout;
        //caso retorne null, é pq não deu error
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
