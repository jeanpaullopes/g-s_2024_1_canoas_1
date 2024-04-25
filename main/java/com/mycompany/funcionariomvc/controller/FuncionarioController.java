/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionariomvc.controller;

import com.mycompany.funcionariomvc.DAO.FuncionarioDAO;
import com.mycompany.funcionariomvc.model.Funcionario;
import com.mycompany.funcionariomvc.model.RegraNegocio;
import com.mycompany.funcionariomvc.view.AppView;
import com.mycompany.funcionariomvc.view.FuncionarioView;
import java.util.List;

/**
 *
 * @author rafaelamoreira
 */
public class FuncionarioController {

    private Funcionario f;
    private FuncionarioView fv;
    private List<Funcionario> funcionarios;

    //private RegraNegocio rn;
    public FuncionarioController(FuncionarioView fv, List<Funcionario> funcionarios) {
        this.fv = fv;
        this.funcionarios = funcionarios;
    }

    public boolean criaFuncionario() {
        boolean status = false;
        int id = FuncionarioDAO.buscaCodigo()+1;
        this.f = fv.inputData(id);
        if (this.f != null) {
            funcionarios.add(f);
            FuncionarioDAO.salvarFuncionario(f);
            status = true;
        }
        return status;
    }

    public boolean promover(Funcionario f) {
        boolean status = false;
        double r = RegraNegocio.getPercentualPromover(f);
        if (r != 0) {
            aumentarSalario(f, r);
            status = true;
        }
        return status;
    }
    public boolean operacaoFazerAniversario() {
                   int id = fv.defineFuncionario();
                                if (!funcionarios.isEmpty()) {
                                    if ((id - 1) < funcionarios.size()) {
                                        fazerAniversario(funcionarios.get(id - 1));
                                        fv.mostraMsgAniversario(funcionarios.get(id - 1));
                                    } else {
                                        AppView.mostraMsgNaoEncontrado();
                                    }
                                } else {
                                    AppView.mostraMsgListaVazia();
                                }
                     return true;
    }
    public void aumentarSalario(Funcionario f, double percentual) {
        double aumento = (f.getSalario() * percentual) / 100;
        f.setSalario(f.getSalario() + aumento);
    }

    public void fazerAniversario(Funcionario f) {
        f.setIdade(f.getIdade() + 1);
    }

    public boolean validarFuncionario(int id, Funcionario f) {
        return true;
    }
}
