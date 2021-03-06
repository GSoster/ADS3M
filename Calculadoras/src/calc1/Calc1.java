package calc1;

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
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Calc1 extends JFrame{

	//Elementos
	private JTextField num1, num2, resultado;
	private JButton calcular, zerar;

	private JComboBox operacao;
	
	private JLabel numero1, numero2, lbResultado, lbOperacao;
	
	//paineis
	private JPanel painelGeral;
	private JPanel painelCombo;
	private JPanel painelBotoes;
	private JPanel painelEntrada;
	private JPanel painelResultado;
	private JPanel painelEntrada2;
	
	
	public Calc1(){
		super("calculadora 1");
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		//this.setLocationRelativeTo(null);//centraliza
		setLocation(400, 10);
		
		
		
		this.inicializarElementos();
		this.adicionarElementos();
		
		this.estilizar();//adiciona icone
		
		this.setVisible(true);
		
	}
	
	private void estilizar(){
		Image im = null;
		try{
			im = ImageIO.read(new File("src/calc1/jv.png"));
			
			this.setIconImage(im);			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void inicializarElementos(){
		//paineis
		this.painelGeral = new JPanel();
		this.painelGeral.setLayout(new GridLayout(5,0));//cinco linhas e zero colunas		
		
		this.painelCombo = new JPanel();
		this.painelCombo.setLayout(new FlowLayout());
		
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
		
		//comboBox
		this.operacao = new JComboBox();
		this.operacao.addItem("Somar");
		this.operacao.addItem("Subtrair");
		this.operacao.addItem("Multiplicar");
		this.operacao.addItem("Dividir");
		
		
		//labels
		this.numero1 = new JLabel("Numero1: ");
		this.numero2 = new JLabel("Numero2: ");
		this.lbResultado = new JLabel("Resultado: ");
		this.lbOperacao = new JLabel("Opera��o: ");
		
		
		this.getContentPane().setBackground(Color.BLUE);			

	}
	

	
	private void adicionarElementos(){		
		this.painelEntrada.add(this.numero1);		
		this.painelEntrada.add(this.num1);
		this.painelEntrada2.add(this.numero2);
		this.painelEntrada2.add(this.num2);
		
		this.painelCombo.add(this.lbOperacao);
		this.painelCombo.add(this.operacao);
				
		
		this.painelBotoes.add(this.calcular);
		this.painelBotoes.add(this.zerar);
		
		this.painelResultado.add(this.lbResultado);
		this.painelResultado.add(this.resultado);
		
		this.painelGeral.add(this.painelEntrada);
		this.painelGeral.add(this.painelEntrada2);
		this.painelGeral.add(this.painelCombo);
		this.painelGeral.add(this.painelResultado);
		this.painelGeral.add(this.painelBotoes);
		
		this.add(this.painelGeral);
	}
	
}
