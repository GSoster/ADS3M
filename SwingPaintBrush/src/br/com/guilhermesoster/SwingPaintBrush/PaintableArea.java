package br.com.guilhermesoster.SwingPaintBrush;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class PaintableArea extends JPanel{

	private Graphics2D g2d;	
	
	
	public PaintableArea(){
		super();		
		configPaintableArea();				
	}
	
	/**
	 * Responsavel por configurar a tela de desenho
	 */
	private void configPaintableArea(){		
		setSize(MainWindow.MAINWINDOW_WIDTH, MainWindow.MAINWINDOW_HEIGHT);
		setBackground(Color.lightGray);
	}
	
	/**
	 * Desdenha um quadrado dentro da area disponivel.
	 * @param g
	 * @throws IllegalArgumentException
	 */
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
	
	/**
	 * Desenha um circulo dentro da area disponivel
	 * @param g
	 * @throws IllegalArgumentException
	 */
	public void drawCircle(Graphics g) throws IllegalArgumentException{
		int posX = Integer.parseInt(JOptionPane.showInputDialog("Insira posicao X: "));
		if(posX > MainWindow.MAINWINDOW_WIDTH)
			throw new IllegalArgumentException("X maior que a tela disponível para desenho!");
		
		int posY = Integer.parseInt(JOptionPane.showInputDialog("Insira posicao Y: "));
		if(posY > MainWindow.MAINWINDOW_HEIGHT)
			throw new IllegalArgumentException("Y maior que a tela disponível para desenho!");
		
		int rectWidth = Integer.parseInt(JOptionPane.showInputDialog("Insira tamanho horizontal: "));				
		int rectHeight = Integer.parseInt(JOptionPane.showInputDialog("Insira tamanho vertical: "));
		
		g2d = (Graphics2D)g;
		g2d.drawOval(posX, posY, rectWidth, rectHeight);
	}
	
	
	/**
	 * Limpa a tela 
	 * @param g
	 */
	public void clearScreen(Graphics g){
		g2d = (Graphics2D)g;
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, 30, this.getWidth(), this.getHeight());		
	}
	
}
