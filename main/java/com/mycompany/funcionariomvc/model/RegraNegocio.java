/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionariomvc.model;

/**
 *
 * @author rafaelamoreira
 */
public class RegraNegocio {

    private static final int idadeLimite = 18;
    private static final double aumentoPromo = 25;

    public static int getIdadeLimite() {
        return idadeLimite;
    }

    public static double getAumentoPromo() {
        return aumentoPromo;
    }

    public static boolean permitePromover(Funcionario f) {
        return f.getIdade() >= idadeLimite;
    }

    public static double getPercentualPromover(Funcionario f) {
        double r = 0;
        if (permitePromover(f)) {
            r = aumentoPromo;
        }
        return r;
    }
}
