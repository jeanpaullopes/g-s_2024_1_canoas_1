package com.mycompany.funcionariomvc.view;

import com.mycompany.funcionariomvc.model.Funcionario;
import com.mycompany.funcionariomvc.model.RegraNegocio;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rafaelamoreira
 */
public class FuncionarioView {
    
    private Scanner scan;
    //private List<Funcionario> funcionarios;
    /**
     * Construtor da Classe Funcionario
     * 
     */
    public FuncionarioView() {
        
    }
    /**
     * Listar os funcionarios cadastrados
     */
    public void listarFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("---------------------------");
        System.out.println("Funcionarios:");
        System.out.println("---------------------------"); 
         
        for (Funcionario f : funcionarios) {
            System.out.println(f.toString());
            System.out.println("---------------------------");
        }
        
    }
   /**
    * Entrar com os dados do funcionario
    * @param i - representa o id
    * @return Funcionario
    */
    public Funcionario inputData(int i) {

        this.scan = new Scanner(System.in);
        System.out.println("Informe o nome do funcionário " + i + " : ");
        String nome = scan.nextLine();

        System.out.println("Informe a idade do funcionario " + i + " : ");
        int idade = scan.nextInt();

        System.out.println("Informe o salario do funcionario " + i + " : ");
        double salario = scan.nextDouble();

        return new Funcionario(i, nome, idade, salario);
    }
    /**
     * Mostrar mensagem de criação do funcionário
     */
    public void mostraMsgCriacao() {
        System.out.println("-------------------------------");
        System.out.println("Funcionario criado com sucesso!");
        System.out.println("-------------------------------");
    }
    /**
     * Define o funcionario pelo id
     * @return id  
     */
    public int defineFuncionario() {
        System.out.println("Informe o id do funcionario: ");
        return scan.nextInt();
    }
    /**
     * Define o percentual de aumento
     * @return percentual
     */
    public double definePercentual() {
        System.out.println("Informe o percentual de aumento: ");
        return scan.nextDouble();
    }
    /**
     * Mostrar mensagem de aniversário
     * @param f - Funcionario
     */
    public void mostraMsgAniversario(Funcionario f) {
        System.out.println("-------------------------------");
        System.out.printf("Agora o funcionario %s tem %d anos!\n", f.getNome(), f.getIdade());
        System.out.println("-------------------------------");
    }
    /**
     * Mostrar mensagem de promocao validada 
     * @param f Funcionario
     */
    public void mostraMsgPromocaoOk(Funcionario f) {
        System.out.println("-------------------------------");
        System.out.printf("Funcionario %s promovido com %.0f%%! "
                + "\nNovo salario é R$ %.2f.\n", f.getNome(), RegraNegocio.getAumentoPromo(), f.getSalario());
        System.out.println("-------------------------------");
    }
    /**
     * Mostrar mensagem de erro para promocao 
     * @param f Funcionario
     */
    public void mostraMsgPromocaoErro(Funcionario f) {
        System.out.println("-------------------------------");
        System.out.println("Funcionario não tem idade para ser promovido!");
        System.out.println("-------------------------------");
    }
    /**
     * Mostrar mensagem e aumento
     * @param f Funcionario
     * @param p percentual
     */
    public void mostraMsgAumento(Funcionario f, double p) {
        System.out.println("-------------------------------");
        System.out.printf("Funcionario %s recebeu um aumento de %.0f%%! "
                + "\nNovo salario é R$ %.2f.\n", f.getNome(), p, f.getSalario());
        System.out.println("-------------------------------");
    }

}
