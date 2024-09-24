/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.targetsistemas;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Clinton Gonçalves dos Santos
 *https://github.com/ClintSant
 **/

public class TargetSistemas {

    private static String originalString;

    public static void main(String[] args) {
        
        questão1();
         questão2();
        questão3();
        questão4();
        questão5();

    }

    public static void questão1() {
        System.out.println("#### Programa 1 ####.\n");
        int INDICE = 13;
        int SOMA = 0;
        int K = 0;

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }
        System.out.println("O resultado da soma é: " + SOMA);
    }
        
    public static void questão2() {
        System.out.println("#### Programa 2 ####.\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int num = scanner.nextInt();

        if (num == 0 || num == 1) {
            System.out.println("O número " + num + " pertence à sequência de Fibonacci.\n\n");

        } else {
            long a = 0, b = 1, c = 1;

            while (c < num) {
                c = a + b;
                a = b;
                b = c;
            }
            if (num == c) {
                System.out.println("O número " + num + " pertence à sequência de Fibonacci.\n");
            } else {
                System.out.println("O número " + num + " NÃO pertence à sequência de Fibonacci.\n");
            }
        }
    }

    public static void questão3() {
        System.out.println("#### Programa 3 ####.\n");
        
        String caminhoArquivo = "C:\\Users\\Administrador\\Documents\\NetBeansProjects\\TargetSistemas\\dados.json";
       
        List<Double> valoresFaturamento = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
              
                if (linha.contains("\"valor\":")) {
                    String[] partes = linha.split(":");
                    double valor = Double.parseDouble(partes[1].trim().replace(",", ""));
                    valoresFaturamento.add(valor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        double menorFaturamento = Double.MAX_VALUE;
        double maiorFaturamento = Double.MIN_VALUE;
        double somaFaturamento = 0;
        int diasComFaturamento = 0;

        for (double valor : valoresFaturamento) {
            if (valor > 0) { 
                if (valor < menorFaturamento) {
                    menorFaturamento = valor;
                }
                if (valor > maiorFaturamento) {
                    maiorFaturamento = valor;
                }
                somaFaturamento += valor;
                diasComFaturamento++;
            }
        }

        
        double mediaMensal = somaFaturamento / diasComFaturamento;

        
        int diasAcimaDaMedia = 0;
        for (double valor : valoresFaturamento) {
            if (valor > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }

        
        System.out.println("Menor valor de faturamento: " + menorFaturamento);
        System.out.println("Maior valor de faturamento: " + maiorFaturamento);
        System.out.println("Número de dias com faturamento superior à média: " + diasAcimaDaMedia);
    }

    public static void questão4() {
        System.out.println("#### Programa 4 ####.\n");

        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        double faturamentoTotal = sp + rj + mg + es + outros;

        System.out.println("Percentual de representação por estado: ");
        System.out.printf("SP: %.2f%%\n", (sp / faturamentoTotal) * 100);
        System.out.printf("RJ: %.2f%%\n", (rj / faturamentoTotal) * 100);
        System.out.printf("MG: %.2f%%\n", (mg / faturamentoTotal) * 100);
        System.out.printf("ES: %.2f%%\n", (es / faturamentoTotal) * 100);
        System.out.printf("Outros: %.2f%%\n", (outros / faturamentoTotal) * 100);

    }

    public static void questão5() {
        System.out.println("#### Programa 5 ####.\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra para inverter: ");
        String originalString = scanner.nextLine();

        String stringInvertida = inverterString(originalString);

        System.out.println("String invertida: " + stringInvertida);
    }

    public static String inverterString(String str) {

        char[] caracteres = str.toCharArray();
        String stringInvertida = "";

        for (int i = caracteres.length - 1; i >= 0; i--) {
            stringInvertida += caracteres[i];
        }

        return stringInvertida;
    }
}
