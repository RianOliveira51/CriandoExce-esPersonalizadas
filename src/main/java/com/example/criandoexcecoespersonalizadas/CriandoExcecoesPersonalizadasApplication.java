package com.example.criandoexcecoespersonalizadas;

import com.example.criandoexcecoespersonalizadas.model.entities.Reservation;
import com.example.criandoexcecoespersonalizadas.model.exception.DomainException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data de entrada e data de sáida)
* e montrar os dados da reserva, inclusive, suas duração em dias. Em seguida, ler novas datas de entrada e saida,
* atualizar a reserva, mostrar novametne a reserva com os dados atualizados. O programa não deve aceitar dados inválidos,
* para a reserva, conforme as seguintes regras:
* - Alterações de reserva só podem ocorrer para datas futuras.
* - A data de saída deve ser maior que a data de entrada.*/

//Jeito Bom
@SpringBootApplication
public class CriandoExcecoesPersonalizadasApplication {
    //throws - propraga a exceção para o proximo programa.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check- in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check- Out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            //.after para saber se uma data é posterior a outra.

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation");
            System.out.print("Check- in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check- Out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            //Como vai retornar um String, declaramos o metodo como String.
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        //catch - tratamento de exceções;
        catch(ParseException e) {
                System.out.println("Invalid date format");
        }
        catch (DomainException e ){
            //getMessage é a mensagem incluida no metodo na classe Reservation
            System.out.println("Error in reservation : " + e.getMessage());
        }
        /*usamos RuntimeException, para quando der qualquer exceção inesperada que não mapeamos
        assim o programa não irá quebrar.*/
        catch (RuntimeException e ){
            System.out.println("Unexpected error");
        }
        sc.close();
    }
}
