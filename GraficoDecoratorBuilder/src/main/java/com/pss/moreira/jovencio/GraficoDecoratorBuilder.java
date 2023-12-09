/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pss.moreira.jovencio;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Eriani M
 */
public class GraficoDecoratorBuilder {

    public static void main(String[] args) {
        //List<String> femininos = new ArrayList<>();
        int contagemFemininos = 0;
        XYSeries series = new XYSeries("Femininos");


        try{
            BufferedReader bf = new BufferedReader(new FileReader ("pessoas.csv"));
            String linha;
            //System.out.println(linha);
            while ((linha = bf.readLine()) != null) {
                String[] dados = linha.split(",");

                // Verifica se a palavra "Feminino" está na coluna 1 (índice 0)
                if (dados.length > 0 && dados[0].equals("Feminino")) {
                    //femininos.add(linha);
                    contagemFemininos++;
                }
            }
            System.out.println("Total de 'Feminino' na coluna 1: " + contagemFemininos);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        var dataset = new XYSeriesCollection();
        series.add(1, contagemFemininos);
        dataset.addSeries(series);
        
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Comparativo",
                "Evolução",
                "Numero de ocorrencias",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
                
        );
        XYPlot plot = chart.getXYPlot();
        var renderer = new XYLineAndShapeRenderer();
        
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);

        chart.getLegend().setFrame(BlockBorder.NONE);

        ChartFrame frame1 = new ChartFrame("Gráfico de linhas", chart);
        frame1.setVisible(true);
        frame1.setSize(1300, 800);
        
    }
}
    
