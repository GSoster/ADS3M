package br.com.guilhermesoster.SwingPaintBrush;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class PaintableArea extends JPanel{

	private Graphics2D g2d;
	private JFrame parent;
	
	
	public PaintableArea(JFrame parent){
		super();
		parent = parent;
		configPaintableArea();				
	}
	
	/**
	 * Responsavel por configurar a tela de desenho
	 */
	private void configPaintableArea(){		
		setSize(MainWindow.MAINWINDOW_WIDTH, MainWindow.MAINWINDOW_HEIGHT);		
	}
	
	
	public void drawRect(Graphics g) throws IllegalArgumentException{
		int posX = Integer.parseInt(JOptionPane.showInputDialog("Insira posicao X: "));
		if(posX > MainWindow.MAINWINDOW_WIDTH)
			throw new IllegalArgumentException("X maior que a tela disponível para desenho!");
		
		int posY = Integer.parseInt(JOptionPane.showInputDialog("Insira posicao Y: "));
		if(posY > MainWindow.MAINWINDOW_HEIGHT)
			throw new IllegalArgumentException("Y maior que a tela disponível para desenho!");
		
		int rectWidth = Integer.parseInt(JOptionPane.showInputDialog("Insira tamanho horizontal: "));				
		int rectHeight = Integer.parseInt(JOptionPane.showInputDialog("Insira tamanho vertical: "));
		
		g2d = (Graphics2D)g;
		g2d.drawRect(posX, posY, rectWidth, rectHeight);
		
	}	
	
}
