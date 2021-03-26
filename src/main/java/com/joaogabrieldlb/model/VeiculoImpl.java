package com.joaogabrieldlb.model;

import java.text.NumberFormat;

public abstract class VeiculoImpl implements Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private double valor;

    public VeiculoImpl(String placa, String marca, String modelo, int ano, double valor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Tipo: "+this.getClass().getSimpleName()+ "\n\tPlaca: "+this.placa+"| Marca: "+this.marca+"| Modelo: "+this.modelo+"| Ano: "+this.ano+"| Valor: "+NumberFormat.getCurrencyInstance().format(this.valor);
    }

    @Override
    public int getAno() {
        return this.ano;
    }

    @Override
    public String getMarca() {
        return this.marca;
    }

    @Override
    public String getModelo() {
        return this.modelo;
    }

    @Override
    public String getPlaca() {
        return this.placa;
    }

    @Override
    public double getValor() {
        return this.valor;
    }


    
}
