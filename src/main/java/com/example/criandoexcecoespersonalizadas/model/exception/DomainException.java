package com.example.criandoexcecoespersonalizadas.model.exception;

/*Existe dois tipos de extensão para criar uma exceção personalizada.
* 1 - RuntimeException - Não obriga voce a tratar = tratamento feito na classe Reservation.
* 2 - Exception - O compilador irá obrigar voce a tratar.*/

public class DomainException extends RuntimeException{
    // Declara a versão de uma classe serialise.
    private static final long serialVersionUID = 1L;

    //construtor - podemos instanciar a classe DomainException e podemos incluir uma mensagem.
    public DomainException(String msg){
        super(msg);
    }


}
