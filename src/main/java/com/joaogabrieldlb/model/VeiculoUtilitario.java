package com.joaogabrieldlb.model;

public class VeiculoUtilitario extends VeiculoImpl {
    private double capCargaKg;
    private int nroEixos;
    
    public VeiculoUtilitario(String placa, String marca, String modelo, int ano, double valor, double capCargaKg,
            int nroEixos) {
        super(placa, marca, modelo, ano, valor);
        this.capCargaKg = capCargaKg;
        this.nroEixos = nroEixos;
    }

    public double getCapCargaKg() {
        return capCargaKg;
    }

    public int getNroEixos() {
        return nroEixos;
    }

    @Override
    public String toString(){
        return super.toString() + " | Capacidade de carga(Kg): "+ this.capCargaKg +" | Eixos: "+this.nroEixos;
    }
}
