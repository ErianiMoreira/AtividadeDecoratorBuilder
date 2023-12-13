/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.moreira.jovencio.model.grafico.decoradores;

import com.pss.moreira.jovencio.model.grafico.Elemento;

/**
 *
 * @author Eriani M
 */
public abstract class GraficoDecorator implements Elemento {

	private Elemento elementoDecorater;

	public GraficoDecorator( Elemento elementoDecorater ) {
		this.elementoDecorater = elementoDecorater;
	}

	public Elemento getElementoDecorater() {
		return elementoDecorater;
	}

	public void setElementoDecorater( Elemento elementoDecorater ) {
		this.elementoDecorater = elementoDecorater;
	}

}
