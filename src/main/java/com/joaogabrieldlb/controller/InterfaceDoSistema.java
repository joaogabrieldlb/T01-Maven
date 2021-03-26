package com.joaogabrieldlb.controller;

import java.util.List;
import java.util.Scanner;

import com.joaogabrieldlb.model.Veiculo;

public class InterfaceDoSistema {
    
    private List<Veiculo> listaDaConsulta;
    private CatalogoVeiculos cv = new CatalogoVeiculos();
    private Scanner sc = new Scanner(System.in);
    private String resposta;

    public void executa() {
        while(true) {
            System.out.println("Seja bem-vindo a interface do sistema de veículos!" + System.lineSeparator());
            if(menuConsulta() == false) {
                break;
            }
        }
    }

    private boolean menuConsulta() {
        while(true) {
            System.out.println("--= Menu de Consulta =--");
            System.out.println("Digite:");
            System.out.println("1. Consultar por placa");
            System.out.println("2. Consultar por marca");
            System.out.println("3. Consultar por ano de " + System.lineSeparator() + "fabricação");
            System.out.println("4. Consultar por tipo");
            System.out.println("------------------------");
            System.out.println("0. Sair");
            System.out.println("________________________");
            System.out.print("-> ");
            resposta = sc.nextLine();
            System.out.println();
            
            if(resposta.equals("0")) return false;

            if(resposta.equals("1") || resposta.equals("2") ||
             resposta.equals("3") || resposta.equals("4")) consulta(resposta);
            else System.out.println("Erro: Foi digitada uma opção inválida!" + System.lineSeparator() +
            "Tente novamente..." + System.lineSeparator());
        }
    }

    private boolean consulta(String tipoDaConsulta) {
        if(tipoDaConsulta.equals("1")){
            Veiculo v = consultaPorPlaca();
            if(v == null) {
                System.out.println("Erro: Veículo não encontrado no sistema!" + System.lineSeparator() +
                "Tente novamente..." + System.lineSeparator());
                return false;
            }
            System.out.println(v + System.lineSeparator());
            System.out.println("Pressione ENTER para continuar...");
            sc.nextLine();
            return true;
        }
        
        if(tipoDaConsulta.equals("2")) {
            listaDaConsulta = consultaPorMarca();
        }
        
        if(tipoDaConsulta.equals("3")) {
            listaDaConsulta = consultaPorAnoDeFabricacao();
        }
        
        if(tipoDaConsulta.equals("4")) {
            listaDaConsulta = consultaPorTipo();
        }
        
        if(listaDaConsulta.isEmpty() && (tipoDaConsulta.equals("2") || tipoDaConsulta.equals("3") || tipoDaConsulta.equals("4"))) {
            System.out.println("Erro: Nenhum veículo foi encontrado no sistema!" + System.lineSeparator() +
            "Tente novamente..." + System.lineSeparator());
            return false;
        } else if(tipoDaConsulta.equals("2") || tipoDaConsulta.equals("3") || tipoDaConsulta.equals("4")) {
            listaDaConsulta.forEach(veiculo -> System.out.println(veiculo));
            System.out.println();
            System.out.println("Pressione ENTER para continuar...");
            sc.nextLine();
            return true;
        }
        
        if(resposta.equals("0")) return false;
        return false;
    }

    private Veiculo consultaPorPlaca() {
        System.out.print("Número da placa: ");
        resposta = sc.nextLine();
        System.out.println();
        return cv.consultaPorPlaca(resposta);
    }

    private List<Veiculo> consultaPorMarca() {
        System.out.print("Marca do veículo: ");
        resposta = sc.nextLine();
        System.out.println();
        return cv.consultaPorMarca(resposta);
    }

    private List<Veiculo> consultaPorAnoDeFabricacao() {
        System.out.print("Ano de Fabricação: ");
        resposta = sc.nextLine();
        int ano = Integer.parseInt(resposta);
        System.out.println();
        return cv.consultaPorAno(ano);
    }

    private List<Veiculo> consultaPorTipo() {
        System.out.println("1. Veículo Passeio");
        System.out.println("2. Veículo Passageiros");
        System.out.println("3. Veículo Utilitário");
        System.out.print("Tipo do veículo: ");
        resposta = sc.nextLine();
        System.out.println();
        switch(resposta) {
            case "1":
            resposta = "VeiculoPasseio";
            break;
            case "2":
            resposta = "VeiculoPassageiros";
            break;
            case "3":
            resposta = "VeiculoUtilitario";
            break;
            default:
            resposta = null;
        }
        return cv.consultaPorTipo(resposta);
    }

}
