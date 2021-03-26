package com.joaogabrieldlb.model;

public class VeiculoPasseio extends VeiculoImpl {

    private double consumoKmLt;

    public VeiculoPasseio(String placa, String marca, String modelo, int ano, double valor,double consumoKmLt) {
        super(placa, marca, modelo, ano, valor);
        this.consumoKmLt = consumoKmLt;
    }

    public double getConsumoKmLt() {
        return this.consumoKmLt;
    }

    @Override
    public String toString(){
        return super.toString() + " | Consumo Km/Litro: "+ this.consumoKmLt;
    }
}