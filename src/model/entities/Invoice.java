package model.entities;

public class Invoice {
    private Double basicPayment;
    private Double tax;

    public Invoice() {

    }

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotalPayment() { //Aqui utilizamos os get porque se no futuro precisarmos mudar a lógica do tax() ou do basicPayment() não vai afetar
        return getBasicPayment() + getTax();
    }
}
