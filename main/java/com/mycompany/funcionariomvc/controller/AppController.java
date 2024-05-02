/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionariomvc.controller;

import com.mycompany.funcionariomvc.DAO.FuncionarioDAO;
import com.mycompany.funcionariomvc.DAO.FuncionarioDAOMySQL;
import com.mycompany.funcionariomvc.model.Funcionario;
import com.mycompany.funcionariomvc.view.AppView;
import com.mycompany.funcionariomvc.view.FuncionarioView;
import java.util.List;

/**
 *
 * @author rafaelamoreira
 */
public class AppController {

    private List<Funcionario> funcionarios;
    private FuncionarioView fv;
    private FuncionarioController fc;
    private Funcionario f;

    public AppController() {

        this.funcionarios = FuncionarioDAOMySQL.getInstance().getFuncionarios();
        this.fv = new FuncionarioView();
        this.fc = new FuncionarioController(fv, funcionarios);
    }

    public void iniciar() {
        int id, op= -1, op1 = -1;
        do {
            op = AppView.menuInicial();
            switch (op) {
                case 1: // inserir funcionario
                    boolean status = fc.criaFuncionario();
                    if (status == true) {
                        fv.mostraMsgCriacao();
                        
                    }
                    break;
                case 2: // listar funcionarios
                    if (!funcionarios.isEmpty()) {
                        fv.listarFuncionarios(this.funcionarios);
                    } else {
                        AppView.mostraMsgListaVazia();
                    }
                    break;
                case 3: // atualizar funcionario
                    do {
                        op1 = AppView.menuAtualiza();
                        switch (op1) {
                            case 1: // aumentar salario
                                id = fv.defineFuncionario();
                                if (!funcionarios.isEmpty()) {
                                    if ((id - 1) < funcionarios.size()) {
                                        double perc = fv.definePercentual();
                                        fc.aumentarSalario(funcionarios.get(id - 1), perc);
                                        fv.mostraMsgAumento(funcionarios.get(id - 1), perc);
                                    } else {
                                        AppView.mostraMsgNaoEncontrado();
                                    }
                                } else {
                                    AppView.mostraMsgListaVazia();
                                }
                                break;

                            case 2: // aniversario 
                                fc.operacaoFazerAniversario();
                               break;
                            case 3: // promover
                                id = fv.defineFuncionario();
                                if (!funcionarios.isEmpty()) {
                                    if ((id - 1) < funcionarios.size()) {
                                        if (fc.promover(funcionarios.get(id - 1))) {
                                            fv.mostraMsgPromocaoOk(funcionarios.get(id - 1));
                                        } else {
                                            fv.mostraMsgPromocaoErro(funcionarios.get(id - 1));
                                        }
                                    } else {
                                        AppView.mostraMsgNaoEncontrado();
                                    }
                                } else {
                                    AppView.mostraMsgListaVazia();
                                }
                                break;
                            case 4: // voltar ao menu inicial
                                op1 = -1;
                                break;
                            default:
                                AppView.mostraMsgInvalida();
                        }

                    } while (op1 > 0);
                    break;
                case 4:
                    AppView.mostraMsgFim();
                    op = -1;
                    break;
                default:
                    AppView.mostraMsgInvalida();
            }

        } while (op > 0);

    }

}
