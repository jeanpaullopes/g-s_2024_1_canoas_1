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
    public Funcionario inputData(Funcionario func) {

        this.scan = new Scanner(System.in);
        System.out.println("Informe o nome do funcionário: ("+
             (func != null?func.getNome():"")
              +")");
        String nome = scan.nextLine();
        if (!nome.isEmpty() && func != null) {
            func.setNome(nome);
        }

        System.out.println("Informe a idade do funcionario: ("+(func != null?func.getIdade():"")+" 0 mantém valor)");
        int idade = scan.nextInt();
        if (idade >0 && func != null) {
            func.setIdade(idade);
        }

        System.out.println("Informe o salario do funcionario: ("+(func != null?func.getSalario():"")+" 0 mantém valor)");
        double salario = scan.nextDouble();
        if (salario >0 && func != null) {
            func.setSalario(salario);
        }
        if (func == null) {
            return new Funcionario(0, nome, idade, salario);
        } else {
            return func;
        }
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
        this.scan = new Scanner(System.in);
        System.out.println("Informe o id do funcionario: ");
        return scan.nextInt();
    }
    /**
     * Define o percentual de aumento
     * @return percentual
     */
    public double definePercentual() {
        this.scan = new Scanner(System.in);
        System.out.println("Informe o percentual de aumento: ");
        return scan.nextDouble();
    }
    /**
     * Mostrar mensagem de aniversário
     * @param f - Funcionario
     */
    public void mostraMsgAniversario(Funcionario f) {
        this.scan = new Scanner(System.in);
        System.out.println("-------------------------------");
        System.out.printf("Agora o funcionario %s tem %d anos!\n", f.getNome(), f.getIdade());
        System.out.println("-------------------------------");
    }
    /**
     * Mostrar mensagem de promocao validada 
     * @param f Funcionario
     */
    public void mostraMsgPromocaoOk(Funcionario f) {
        this.scan = new Scanner(System.in);
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
        this.scan = new Scanner(System.in);
        System.out.println("-------------------------------");
        System.out.printf("Funcionario %s recebeu um aumento de %.0f%%! "
                + "\nNovo salario é R$ %.2f.\n", f.getNome(), p, f.getSalario());
        System.out.println("-------------------------------");
    }

}
