package com.joaogabrieldlb.controller;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.joaogabrieldlb.model.Veiculo;
import com.joaogabrieldlb.model.VeiculoPassageiros;
import com.joaogabrieldlb.model.VeiculoPasseio;
import com.joaogabrieldlb.model.VeiculoUtilitario;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CatalogoVeiculos {
    private List<Veiculo> veiculos;
    
    public CatalogoVeiculos() {
        this.veiculos = new ArrayList<>();
        carregaCsv("VeiculoDePassageiros.csv");
        carregaCsv("VeiculoDePasseio.csv");
        carregaCsv("VeiculoUtilitario.csv");

    }

    private void carregaCsv(String fileName) {
        try (
            Reader reader = Files.newBufferedReader(Paths.get("src/main/java/com/joaogabrieldlb/resources/" + fileName));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
        ) {
                for (CSVRecord csvRecord : csvParser) {
                String placa = csvRecord.get(0);
                String marca = csvRecord.get(1);
                String modelo = csvRecord.get(2);
                int ano = Integer.parseInt(csvRecord.get(3));
                double valor = Double.parseDouble(csvRecord.get(4));
                if(fileName.equals("VeiculoDePassageiros.csv")) {
                    int nroPass = Integer.parseInt(csvRecord.get(5));
                    this.veiculos.add(new VeiculoPassageiros(placa, marca, modelo, ano, valor, nroPass));
                }
                if(fileName.equals("VeiculoDePasseio.csv")) {
                    double consumoKmLt = Double.parseDouble(csvRecord.get(5));
                    this.veiculos.add(new VeiculoPasseio(placa, marca, modelo, ano, valor, consumoKmLt));
                }
                if(fileName.equals("VeiculoUtilitario.csv")) {
                    int capCargaKg = Integer.parseInt(csvRecord.get(5));
                    int nroEixos = Integer.parseInt(csvRecord.get(6));
                    this.veiculos.add(new VeiculoUtilitario(placa, marca, modelo, ano, valor, capCargaKg, nroEixos));
                }
            }
        }catch(Exception e) {
            System.err.println(e.getMessage()+System.lineSeparator()+e.getCause());
        }

    }
    
    public Veiculo consultaPorPlaca(String placa){
        return veiculos.stream()
            .filter(f -> f.getPlaca().equals(placa))
            .findAny()
            .orElse(null);
    }

    public List<Veiculo> consultaPorMarca(String marca){
        return Collections.unmodifiableList(veiculos.stream()
        .filter(f -> f.getMarca().equals(marca))
        .collect(Collectors.toList()));
    }

    public List<Veiculo> consultaPorAno(int ano){
        return Collections.unmodifiableList(veiculos.stream()
            .filter(f -> f.getAno() == ano)
            .collect(Collectors.toList()));
    }

    public List<Veiculo> consultaPorTipo(String tipo){
        return Collections.unmodifiableList(veiculos.stream()
            .filter(f -> f.getClass().getSimpleName().equals(tipo))
            .collect(Collectors.toList()));
    }
}
