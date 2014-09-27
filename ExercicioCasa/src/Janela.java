import javax.swing.JFrame;
public class Janela extends JFrame{

	private House h;
	public static final int WIDTH = 500;
	public static final  int HEIGHT = 500;
	
	
	public Janela(){
		super();
		h = new House();
		setSize(WIDTH,HEIGHT);
		setTitle("DESENHO DE CASA - GUILHERME SOSTER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(h);
		h.repaint();
		setVisible(true);
	}
	
	
}
