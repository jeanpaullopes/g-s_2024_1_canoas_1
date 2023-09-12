
package com.mycompany.funcionariomvc.view;

import java.util.Scanner;

/**
 *
 * @author rafaelamoreira
 */
public class AppView {

    public static int menuInicial() {

        Scanner scan = new Scanner(System.in);

        System.out.println("-------------------");
        System.out.println("Escolha uma opcao: ");
        System.out.println("[1] Inserir Funcionário");
        System.out.println("[2] Listar Funcionários");
        System.out.println("[3] Atualizar Funcionário");
        System.out.println("[4] Sair");
        System.out.println("-------------------");

        return scan.nextInt();

    }

    public static int menuAtualiza() {

        Scanner scan = new Scanner(System.in);

        System.out.println("-------------------");
        System.out.println("Escolha uma opcao: ");
        System.out.println("[1] Aumentar salario de um Funcionario");
        System.out.println("[2] Aniversario do Funcionario");
        System.out.println("[3] Promover Funcionario");
        System.out.println("[4] Voltar ao Menu Inicial");
        System.out.println("-------------------");
        return scan.nextInt();

    }

    public static void mostraMsgInvalida() {
        System.out.println("-------------------------------");
        System.out.println("\"OPCAO INVALIDA!!!!\"");
        System.out.println("-------------------------------");
    }

    public static void mostraMsgFim() {
        System.out.println("-------------------------------");
        System.out.println("ATÉ LOGO..");
        System.out.println("-------------------------------");
    }

    public static void mostraMsgNaoEncontrado() {
        System.out.println("-------------------------------");
        System.out.println("Registro não encontrado!");
        System.out.println("-------------------------------");
    }

    public static void mostraMsgListaVazia() {
        System.out.println("-------------------------------");
        System.out.println("Nenhum registro encontrado!");
        System.out.println("-------------------------------");
    }

}
