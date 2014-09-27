package br.com.guilhermesoster.SwingPaintBrush;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class MainWindow extends JFrame implements ActionListener{

	//Constantes
	public static final int MAINWINDOW_WIDTH = 600;
	public static final int MAINWINDOW_HEIGHT = 600;
	public static final String MAINWINDOW_TITLE = "SwingPaintBrush - Guilherme Soster";
	
	private JPanel generalPanel;	
	private JToolBar toolBar;
	private JButton btDrawRect, btDrawCircle, btClearScreen;
	private PaintableArea paintableArea;	
	
	
	public MainWindow(){
		super();
		configureWindow();
		initElements();
		addElements();
		paintableArea.repaint();
	}
	
	/**
	 * Faz as configuracoes Basicas da janela principal
	 */
	private void configureWindow(){
		setSize(MAINWINDOW_WIDTH, MAINWINDOW_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(MAINWINDOW_TITLE);
		setLayout(new BorderLayout());
		setVisible(true);		
	}
	
	/**
	 * Metodo reponsavel por centralizar os outros metodos que iniciam/configuram
	 * os elementos (Jbuttons, etc..)
	 */
	private void initElements(){
		initPanels();
		initButtons();
		initToolBar();
	}
	
	/**
	 * Reponsavel por adicionar os elementos aos seus respectivos lugares/paineis
	 */
	private void addElements(){
		this.add(paintableArea, BorderLayout.CENTER);		
		toolBar.add(btDrawRect);
		toolBar.add(btDrawCircle);
		toolBar.add(Box.createHorizontalGlue());// 'gruda' os elementos a seguir na direita
		toolBar.add(btClearScreen);
		
		this.add(toolBar, BorderLayout.NORTH);
	}
	
	//Daqui para baixo ficam os metodos especificos de cada tipo de elemento
	private void initPanels(){			
		paintableArea = new PaintableArea(this);
	}
	
	/**
	 * configura todos os botoes disponiveis
	 */
	private void initButtons(){
		btDrawRect = new JButton("Quadrado");
		btDrawCircle = new JButton("Círculo");
		btClearScreen = new JButton("Limpar");
		
		btDrawRect.addActionListener(this);
		btDrawCircle.addActionListener(this);
		btClearScreen.addActionListener(this);
	}		
	
	private void initToolBar(){
		toolBar = new JToolBar();
	}
	
	public JToolBar getToolBar(){
		return this.toolBar;
	}
	
	public void actionPerformed(ActionEvent e){
		JButton botao = null;
		if(e.getSource() instanceof JButton){
			botao = (JButton)e.getSource();
			
			if(botao.equals(btDrawRect)){
				try{
					paintableArea.drawRect(this.getContentPane().getGraphics());
				}catch(IllegalArgumentException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
			
			if(botao.equals(btDrawCircle)){
				try{
					paintableArea.drawCircle(this.getContentPane().getGraphics());
				}catch(IllegalArgumentException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
			
			if(botao.equals(btClearScreen)){				
				paintableArea.clearScreen(this.getContentPane().getGraphics());
			}
		}
	}
	
}
