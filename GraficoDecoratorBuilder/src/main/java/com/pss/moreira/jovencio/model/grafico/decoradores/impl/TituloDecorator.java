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
public class TituloDecorator extends GraficoDecorator {

	public TituloDecorator( Elemento elementoDecorater, String titulo ) {
		super( elementoDecorater );

	}

	@Override
	public void plotar() {
	}

}
