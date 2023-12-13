/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.moreira.jovencio.model.grafico;

import org.jfree.chart.JFreeChart;

/**
 *
 * @author Eriani M
 */
public class Grafico implements Elemento {

	JFreeChart chart;

	public Grafico( JFreeChart chart ) {
		this.chart = chart;
	}

	@Override
	public void plotar() {
	}

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart( JFreeChart chart ) {
		this.chart = chart;
	}

}
