
package com.pss.moreira.jovencio.model.grafico.builders;

import com.pss.moreira.jovencio.model.grafico.Grafico;

/**
 *
 * @author marlan
 */
public abstract class AbstractGraficoBuilder {

	protected Grafico grafico;

	public abstract void adicionaTitulo();

	public abstract void adicionaLegenda();

	public abstract void adicionaTituloEixos();

	public abstract void adicionaRotuloDadosPorcentagem();

	public abstract void adicionaRotuloDadosValor();

	public abstract void adicionaCorBarras();

	public abstract void adicionaCorBarrasPorGrupo();

	public abstract void adicionaGrade();

	public final Grafico getGrafico() {
		return grafico;
	}

}
