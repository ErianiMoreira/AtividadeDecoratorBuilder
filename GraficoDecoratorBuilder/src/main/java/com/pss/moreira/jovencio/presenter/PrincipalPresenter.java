
package com.pss.moreira.jovencio.presenter;

import com.pss.moreira.jovencio.views.PrincipalView;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author marlan
 */
public class PrincipalPresenter {

	private JFreeChart chart;
	private final PrincipalView view;

	public PrincipalPresenter() {
		view = new PrincipalView();
		view.setVisible( false );
		configurarView();
		configurarGrafico();
		view.setVisible( true );
	}

	private void configurarView() {
		view.getCboxDecoradores().setModel( gerarModel() );
		view.getBtnAdicionarDecorador().addActionListener( l -> adicionarDecorador() );
		view.getBtnRemoverDecorador().addActionListener( l -> removerDecorador() );
		view.getListDecoradoresAdicionados().setModel( gerarListDecoradoresAdicionados() );
		view.getCboxGraficosPadrao().setModel( gerarCboxGraficosPadrao() );
		view.getCboxGraficosPadrao().addActionListener( l -> reconstruirGrafico() );
		view.getBtnDesfazer().addActionListener( l -> desfazer() );
		view.getBtnRestaurarPadrao().addActionListener( l -> restaurarPadrao() );
		view.getBtnFechar().addActionListener( l -> fechar() );
	}

	private ComboBoxModel<String> gerarModel() {
		return new javax.swing.DefaultComboBoxModel<>( new String[]{ "Titulo", "Legenda", "Titulo dos eixos", "Rótulo dos Dados (%)", "Rótulo dos dados - Valor", "Rótulo dos dados - Valor (%)", "Cor das Barras", "Cor das barras (por grupo)", "Grade" } );
	}

	private void adicionarDecorador() {
		String selecionado = ( String ) view.getCboxDecoradores().getSelectedItem();
		adicionarItensListDecoradoresAdicionados( selecionado );
	}

	private void removerDecorador() {
		String selecionado = ( String ) view.getCboxDecoradores().getSelectedItem();
		removerItensListDecoradoresAdicionados( selecionado );
	}

	private void removerItensListDecoradoresAdicionados( String elemento ) {
		DefaultListModel model = ( DefaultListModel ) view.getListDecoradoresAdicionados().getModel();
		for( int i = 0; i < view.getListDecoradoresAdicionados().getModel().getSize(); i++ ) {
			if( model.get( i ) == elemento ) {
				model.remove( i );
			}
		}
		view.getListDecoradoresAdicionados().setModel( model );
	}

	private void adicionarItensListDecoradoresAdicionados( String elemento ) {
		DefaultListModel model = ( DefaultListModel ) view.getListDecoradoresAdicionados().getModel();
		var contains = false;
		for( int i = 0; i < view.getListDecoradoresAdicionados().getModel().getSize(); i++ ) {
			if( model.get( i ) == elemento ) {
				contains = true;
			}
		}
		if( !contains ) {
			model.addElement( elemento );
		}
		view.getListDecoradoresAdicionados().setModel( model );
	}

	private ListModel<String> gerarListDecoradoresAdicionados() {
		DefaultListModel model = new DefaultListModel();
		model.clear();
		return model;
	}

	private ComboBoxModel<String> gerarCboxGraficosPadrao() {
		return new javax.swing.DefaultComboBoxModel<>( new String[]{ "Barras Horizontais", "Barras Verticais" } );
	}

	private void reconstruirGrafico() {
		System.out.println( "com.pss.moreira.jovencio.presenter.PrincipalPresenter.reconstruirGrafico()" );
	}

	public void add( Component component ) {
		component.setVisible( true );
		view.getDesktopPane().add( component );
	}

	private void desfazer() {
		System.out.println( "com.pss.moreira.jovencio.presenter.PrincipalPresenter.desfazer()" );
	}

	private void restaurarPadrao() {
		System.out.println( "com.pss.moreira.jovencio.presenter.PrincipalPresenter.restaurarPadrao()" );
	}

	private void fechar() {
		System.out.println( "com.pss.moreira.jovencio.presenter.PrincipalPresenter.fechar()" );
	}

	private void configurarGrafico() {
		CategoryDataset dataset = createDataset();

		chart = ChartFactory.createBarChart( //
				"Analise de Dados", //
				"Estado Civil", //
				"Quantidade", //
				dataset, //
				PlotOrientation.HORIZONTAL, //
				true, //
				true, //
				true );
		chart.getLegend().setFrame( BlockBorder.NONE );
		ChartPanel frame1 = new ChartPanel( chart );
		frame1.setSize( 777, 441 );
		frame1.setVisible( true );
		add( frame1 );
	}

	private static CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int contadorFeminino = 0;
		int contadorFemininoSolteiro = 0;
		int contadorFemininoCasado = 0;
		int contadorMasculino = 0;
		int contadorMasculinoSolteiro = 0;
		int contadorMasculinoCasado = 0;
		try {
			BufferedReader bf = new BufferedReader( new FileReader( "pessoas.csv" ) );
			String linha;
			while( ( linha = bf.readLine() ) != null ) {
				String[] dados = linha.split( "," );
				if( dados.length > 0 && dados[0].equalsIgnoreCase( "Sexo" ) ) {
					continue;
				}

				if( dados[0].equalsIgnoreCase( "Feminino" ) ) {
					contadorFeminino++;
					if( dados[2].equalsIgnoreCase( "Solteiro(a)" ) ) {
						contadorFemininoSolteiro++;
					} else {
						contadorFemininoCasado++;
					}
				} else {
					contadorMasculino++;
					if( dados[2].equalsIgnoreCase( "Solteiro(a)" ) ) {
						contadorMasculinoSolteiro++;
					} else {
						contadorMasculinoCasado++;
					}
				}
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		var total = contadorFemininoSolteiro + contadorMasculinoSolteiro + contadorFemininoCasado + contadorMasculinoCasado;
		dataset.addValue( Double.valueOf( contadorFemininoSolteiro ) / total * 100, "Feminino", "Solteiro(a) %" );
		dataset.addValue( Double.valueOf( contadorMasculinoSolteiro ) / total * 100, "Masculino", "Solteiro(a) %" );
		dataset.addValue( Double.valueOf( contadorFemininoCasado ) / total * 100, "Feminino", "Casado(a) %" );
		dataset.addValue( Double.valueOf( contadorMasculinoCasado ) / total * 100, "Masculino", "Casado(a) %" );

		dataset.addValue( contadorFemininoSolteiro, "Feminino", "Solteiro(a)" );
		dataset.addValue( contadorMasculinoSolteiro, "Masculino", "Solteiro(a)" );
		dataset.addValue( contadorFemininoCasado, "Feminino", "Casado(a)" );
		dataset.addValue( contadorMasculinoCasado, "Masculino", "Casado(a)" );

		return dataset;
	}
}
