package com.example.criandoexcecoespersonalizadas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data de entrada e data de sáida)
* e montrar os dados da reserva, inclusive, suas duração em dias. Em seguida, ler novas datas de entrada e saida,
* atualizar a reserva, mostrar novametne a reserva com os dados atualizados. O programa não deve aceitar dados inválidos,
* para a reserva, conforme as seguintes regras:
* - Alterações de reserva só podem ocorrer para datas futuras.
* - A data de saída deve ser maior que a data de entrada.*/

@SpringBootApplication
public class CriandoExcecoesPersonalizadasApplication {

    public static void main(String[] args) {
        SpringApplication.run(CriandoExcecoesPersonalizadasApplication.class, args);
    }

}
