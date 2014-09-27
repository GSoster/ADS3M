
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;


public class House extends JPanel{

	private Graphics2D g2d;
	
	public House(){
		super();
	}
	
	public void paintComponent(Graphics g){
		g2d = (Graphics2D) g;
		g2d.setColor(Color.MAGENTA);
		g2d.fillRect(Janela.WIDTH/2, Janela.HEIGHT/2 - 100 , 140, 200);//desenha a casa
		g2d.setColor(Color.orange);
		g2d.fillRect(Janela.WIDTH/2+2, Janela.HEIGHT/2,  50, 100);//desenha porta
		g2d.setColor(Color.BLUE);
		g2d.fillRect(Janela.WIDTH/2+65, Janela.HEIGHT/2-70,  55, 55);//desenha janela
		//desenhando linhas para desenhar o telhado
		g2d.setColor(Color.BLACK);
		g2d.drawLine(Janela.WIDTH/2, Janela.HEIGHT/2 - 100, Janela.WIDTH/2 + 70, Janela.HEIGHT/2 - 200);
		g2d.drawLine(Janela.WIDTH/2 + 70, Janela.HEIGHT/2 - 200,Janela.WIDTH/2 + 140, Janela.HEIGHT/2 -100);
	}
	
}
