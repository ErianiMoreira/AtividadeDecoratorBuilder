/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.moreira.jovencio.model.grafico.decoradores.impl;

import com.pss.moreira.jovencio.model.grafico.Elemento;
import com.pss.moreira.jovencio.model.grafico.decoradores.GraficoDecorator;

/**
 *
 * @author Eriani M
 */
public class BarraDecorador extends GraficoDecorator {

	public BarraDecorador( Elemento elementoDecorater, int posicao ) { // necessário receber a posição também
		super( elementoDecorater );
	}

	@Override
	public void plotar() {
	}

}
