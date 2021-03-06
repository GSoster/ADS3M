package calcSoma;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class CalcSoma extends JFrame implements ActionListener{

	private double valor1, valor2, resultado;
	private JPanel painelPrincipal, painelEntrada, painelBotoes;
	private JLabel lbValor1, lbValor2, lbResultado;
	private JButton btSomar, btZerar;
	private JTextField tfValor1, tfValor2, tfResultado;
	
	public CalcSoma(){		
		super("Calculadora Simples - Soma");		
		setSize(300,300);
		setLocation(400, 400);
		setResizable(false);
		this.iniciarComponentes();
		this.adicionarElementos();
		setVisible(true);
	}
	
	
	private void iniciarComponentes(){
		painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new GridLayout(2,2));
		painelBotoes = new JPanel();		
		painelEntrada = new JPanel();

		lbValor1 = new JLabel("Valor: ");
		lbValor2 = new JLabel("Valor: ");
		lbResultado = new JLabel("Resultado: ");
		
		btSomar = new JButton("Somar");
		btZerar = new JButton("Zerar");
		
		tfValor1 = new JTextField(20);
		tfValor2 = new JTextField(20);
		tfResultado = new JTextField(20);
	}
	
	private void adicionarElementos(){
		btSomar.addActionListener(this);
		btZerar.addActionListener(this);
		
		
		painelEntrada.add(lbValor1);
		painelEntrada.add(tfValor1);
		painelEntrada.add(lbValor2);
		painelEntrada.add(tfValor2);
		painelEntrada.add(lbResultado);
		painelEntrada.add(tfResultado);
		
		painelBotoes.add(btSomar);
		painelBotoes.add(btZerar);
		
		painelPrincipal.add(painelEntrada);
		painelPrincipal.add(painelBotoes);
		
		this.add(painelPrincipal);
	}
	
	public void actionPerformed(ActionEvent e){
		JButton botao = null;
		if(e.getSource() instanceof JButton){
			botao = (JButton)e.getSource();
				
				if(botao.getText().equals(btZerar.getText())){
					tfValor1.setText("");
					tfValor2.setText("");
					tfResultado.setText("");
				}
			
				if(botao.getText().equals(btSomar.getText())){					
					valor1 = Double.parseDouble(tfValor1.getText());
					valor2 = Double.parseDouble(tfValor2.getText());
					resultado = valor1 + valor2;
					tfResultado.setText(resultado + "");
				}
			}
			
			
		}
		
	}


	
