package calc2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Calc2 extends JFrame{

	//Elementos
	private JTextField num1, num2, resultado;
	private JButton calcular, zerar;
	private JRadioButton somar, subtrair, multiplicar, dividir;
	private JLabel numero1, numero2, lbResultado;
	
	//paineis
	private JPanel painelGeral;
	private JPanel painelRadio;
	private JPanel painelBotoes;
	private JPanel painelEntrada;
	private JPanel painelResultado;
	private JPanel painelEntrada2;
	
	
	public Calc2(){
		super("calculadora 2");
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setLocationRelativeTo(null);//centraliza
		
		
		
		this.inicializarElementos();
		this.adicionarElementos();
		
		this.estilizar();
		
		this.setVisible(true);
		
	}
	
	private void estilizar(){
		Image im = null;
		try{
			im = ImageIO.read(new File("src/calc2/java.png"));
			
			this.setIconImage(im);			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void inicializarElementos(){
		//paineis
		this.painelGeral = new JPanel();
		this.painelGeral.setLayout(new GridLayout(5,0));//cinco linhas e zero colunas		
		
		this.painelRadio = new JPanel();
		this.painelRadio.setLayout(new FlowLayout());
		
		this.painelBotoes = new JPanel();
		this.painelBotoes.setLayout(new FlowLayout());
		
		this.painelEntrada = new JPanel();
		this.painelEntrada.setLayout(new FlowLayout());
		this.painelEntrada2 = new JPanel();
		this.painelEntrada2.setLayout(new FlowLayout());
		
		this.painelResultado = new JPanel();		
		
		//Campos de texto
		this.num1 = new JTextField(20);
		this.num2 = new JTextField(20);
		this.resultado = new JTextField(20);
		
		//botoes
		this.calcular = new JButton("Calcular");
		this.zerar = new JButton("Zerar");
		
		//radiobuttons
		this.somar = new JRadioButton("Somar");
		this.subtrair = new JRadioButton("Subtrair");
		this.multiplicar = new JRadioButton("Multiplicar");
		this.dividir = new JRadioButton("Dividir");		
		
		//labels
		this.numero1 = new JLabel("Numero1: ");
		this.numero2 = new JLabel("Numero2: ");
		this.lbResultado = new JLabel("Resultado: ");
		
		
		this.getContentPane().setBackground(Color.BLUE);			

	}
	

	
	private void adicionarElementos(){		
		this.painelEntrada.add(this.numero1);		
		this.painelEntrada.add(this.num1);
		this.painelEntrada2.add(this.numero2);
		this.painelEntrada2.add(this.num2);
		
		this.painelRadio.add(this.somar);
		this.painelRadio.add(this.subtrair);
		this.painelRadio.add(this.multiplicar);
		this.painelRadio.add(this.dividir);
		
		
		this.painelBotoes.add(this.calcular);
		this.painelBotoes.add(this.zerar);
		
		this.painelResultado.add(this.lbResultado);
		this.painelResultado.add(this.resultado);
		
		this.painelGeral.add(this.painelEntrada);
		this.painelGeral.add(this.painelEntrada2);
		this.painelGeral.add(this.painelRadio);
		this.painelGeral.add(this.painelResultado);
		this.painelGeral.add(this.painelBotoes);
		
		this.add(this.painelGeral);
	}
	
}
