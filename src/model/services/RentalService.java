package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.Duration;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService;


    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }



    public void processInvoice(CarRental carRental){
        //Esse comando Duration vai calcular o tempo entre um momento inicial e um momento final, neste caso em particular em minutos
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60;
        double basicPayment;
        if (hours <= 12.0){
            basicPayment = pricePerHour * Math.ceil(hours); //Aqui ele tá falando o seguinte: Pega a fração da hora, arredonda pra cima e multiplica pela hora
        }
        else {
            basicPayment = pricePerDay * Math.ceil(hours / 24.0); // Aqui queremos pegar a duração em dias, então dividimos as horas na quantidade de um dia
        }

        double tax = taxService.tax(basicPayment); // chamando o serviço de taxa e passando por parametro o pagamento para ser calculado REVISAR

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
