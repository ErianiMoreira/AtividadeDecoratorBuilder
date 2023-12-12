
package com.pss.moreira.jovencio.model.grafico.builders;

import com.pss.moreira.jovencio.model.grafico.Grafico;

/**
 *
 * @author marlan
 */
public class DiretorGraficoBuilder {

	public static Grafico construir( AbstractGraficoBuilder builder ) {
		builder.adicionaTitulo();
		builder.adicionaLegenda();
		builder.adicionaTituloEixos();
		builder.adicionaRotuloDadosPorcentagem();
		builder.adicionaRotuloDadosValor();
		builder.adicionaCorBarras();
		builder.adicionaCorBarrasPorGrupo();
		builder.adicionaGrade();
		return ( Grafico ) builder.getGrafico();
	}

}
