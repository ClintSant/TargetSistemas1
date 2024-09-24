/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.targetsistemas;

/**
 *
 * @author Administrador
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraJSONManual {
    public static void main(String[] args) {
        StringBuilder jsonContent = new StringBuilder();
         String caminhoArquivo = "C:\\Users\\Administrador\\Documents\\NetBeansProjects\\TargetSistemas\\dados.json";
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                jsonContent.append(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convertendo o JSON string em uma lista de objetos Dados
        List<Dados> listaDados = parseJsonManual(jsonContent.toString());

        // Exibindo os dados
        for (Dados dado : listaDados) {
            System.out.println(dado);
        }
    }

    private static List<Dados> parseJsonManual(String json) {
        List<Dados> listaDados = new ArrayList<>();

        // Remove os colchetes iniciais e finais da string JSON
        json = json.trim();
        json = json.substring(1, json.length() - 1);  // remove "[" e "]"

        // Quebra a string JSON nos objetos individuais
        String[] objetos = json.split("\\},\\{");

        for (String obj : objetos) {
            obj = obj.replace("{", "").replace("}", "");  // remove as chaves

            String[] campos = obj.split(",");

            Dados dados = new Dados();
            for (String campo : campos) {
                String[] keyValue = campo.split(":");
                String key = keyValue[0].trim().replace("\"", "");
                String value = keyValue[1].trim();

                if (key.equals("dia")) {
                    dados.setDia(Integer.parseInt(value));
                } else if (key.equals("valor")) {
                    dados.setValor(Double.parseDouble(value));
                }
            }
            listaDados.add(dados);
        }

        return listaDados;
    }
}
