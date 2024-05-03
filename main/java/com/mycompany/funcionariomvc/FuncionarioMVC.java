
package com.mycompany.funcionariomvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.mycompany.funcionariomvc.controller.AppController;

/**
 *
 * @author rafaelamoreira
 */
public class FuncionarioMVC {

    public static void main(String[] args) {
            String tipo = "memoria";
            if (args.length > 0) {
                tipo = args[0];
            }
            // colocar o caminho absoluto do arquivo de configuração
            File f = new File("/Volumes/ssd_jean/reposAnima/gestao_e_qualidade_24_1/funcionario-mvc/main/java/com/mycompany/funcionariomvc/funcionarioMVC.cfg");
            try{
                Scanner scan = new Scanner(f);
                String linha = "";
                try {
                    while (true) {
                        linha = scan.nextLine();
                        if (linha.contains("banco:")) {
                            tipo = linha.split(":")[1];
                            break;
                        }
                        System.out.println(linha);

                        }
                    } catch (Exception e) {
                        System.out.println("Erro1 ao ler arquivo de configuração");
                    }
            } catch (FileNotFoundException e) {
                System.out.println("Erro2 arquivo de configuração não encontrado");
            }

            AppController ac = new AppController(tipo);
            ac.iniciar();
    }
}
