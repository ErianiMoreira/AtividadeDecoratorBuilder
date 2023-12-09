/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.moreira.jovencio;

/**
 *
 * @author Eriani M
 */
public class BarraDecorador extends GraficoDecorator {

    public BarraDecorador(Elemento elementoDecorater, posicao) { //necessário receber a posição também
        super(elementoDecorater);
    }
    
    

    @Override
    public void plotar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
