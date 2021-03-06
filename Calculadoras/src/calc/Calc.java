package calc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calc extends JFrame implements ActionListener {

	private JButton btnumZero, btnumUm, btnumDois, btnumTres, btnumQuatro,
			btnumCinco, btnumSeis, btnumSete, btnumOito, btnumNove, btsomar,
			btsubtrair, btdividir, btmultiplicar, btigual, btBranco;

	private ArrayList<JButton> listaDeBotoes;
	private ArrayList<JButton> operacoes;
	private ArrayList<JButton> listaDeNumeros;

	private JPanel painelBotoes;
	private JPanel entrada;
	private JPanel geral;

	private double valor1, valor2;
	private String operacao = "";
	private JTextField caixaEntrada;

	public Calc() {
		// janela principal
		super("Calculadora");
		this.setSize(300, 300);
		this.setLocation(10, 20);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.listaDeBotoes = new ArrayList<JButton>();
		this.operacoes = new ArrayList<JButton>();
		this.listaDeNumeros = new ArrayList<JButton>();
		
		this.iniciaElementos();
		this.adicionarBotoesALista();// adiciona os botoes ao arraylist
		this.adicionarElementos();
		this.entrada.setVisible(true);
		this.painelBotoes.setVisible(true);
		this.setVisible(true);
	}

	private void iniciaElementos() {
		// paineis
		this.entrada = new JPanel();
		// painel de botoes
		this.painelBotoes = new JPanel();
		this.painelBotoes.setLayout(new GridLayout(0, 4));

		this.geral = new JPanel();
		this.geral.setLayout(new BorderLayout());

		// operacoes
		this.btsomar = new JButton("+");
		this.btdividir = new JButton("/");
		this.btmultiplicar = new JButton("*");
		this.btsubtrair = new JButton("-");
		this.btigual = new JButton("=");

		// numeros
		this.btnumZero = new JButton("0");
		this.btnumUm = new JButton("1");
		this.btnumDois = new JButton("2");
		this.btnumTres = new JButton("3");
		this.btnumQuatro = new JButton("4");
		this.btnumCinco = new JButton("5");
		this.btnumSeis = new JButton("6");
		this.btnumSete = new JButton("7");
		this.btnumOito = new JButton("8");
		this.btnumNove = new JButton("9");
		this.btBranco = new JButton();
		
		this.caixaEntrada = new JTextField(20);
		this.caixaEntrada.setVisible(true);
	}

	private void adicionarBotoesALista() {
		// linha 1
		this.listaDeBotoes.add(this.btnumSete);
		this.listaDeBotoes.add(this.btnumOito);
		this.listaDeBotoes.add(this.btnumNove);
		this.listaDeBotoes.add(this.btdividir);
		// linha 2
		this.listaDeBotoes.add(this.btnumQuatro);
		this.listaDeBotoes.add(this.btnumCinco);
		this.listaDeBotoes.add(this.btnumSeis);
		this.listaDeBotoes.add(this.btmultiplicar);

		// linha 3
		this.listaDeBotoes.add(this.btnumUm);
		this.listaDeBotoes.add(this.btnumDois);
		this.listaDeBotoes.add(this.btnumTres);
		this.listaDeBotoes.add(this.btsubtrair);
		// adicionando operacoes a lista do painel
		this.listaDeBotoes.add(btBranco);
		this.listaDeBotoes.add(this.btnumZero);
		this.listaDeBotoes.add(this.btigual);
		this.listaDeBotoes.add(this.btsomar);
		// adicionando operacoes a lista de operacoes
		this.operacoes.add(this.btsomar);
		this.operacoes.add(this.btsubtrair);
		this.operacoes.add(this.btmultiplicar);
		this.operacoes.add(this.btdividir);
		
		//adicionando numeros a lista de numeros:
		this.listaDeNumeros.add(this.btnumZero);
		this.listaDeNumeros.add(this.btnumUm);
		this.listaDeNumeros.add(this.btnumDois);
		this.listaDeNumeros.add(this.btnumTres);
		this.listaDeNumeros.add(this.btnumQuatro);
		this.listaDeNumeros.add(this.btnumCinco);
		this.listaDeNumeros.add(this.btnumSeis);
		this.listaDeNumeros.add(this.btnumSete);
		this.listaDeNumeros.add(this.btnumOito);
		this.listaDeNumeros.add(this.btnumNove);
	}

	private void adicionarElementos() {
		// adiciona botoes ao painel e adiciona os listeners.
		for (JButton botao : listaDeBotoes) {
			botao.addActionListener(this);
			this.painelBotoes.add(botao);
		}

		// adicionando numeracao ao painel

		this.entrada.add(this.caixaEntrada);
		this.geral.add(this.entrada, BorderLayout.NORTH);
		this.geral.add(this.painelBotoes, BorderLayout.CENTER);

		// this.add(entrada);
		this.add(this.geral);
	}

	public void actionPerformed(ActionEvent e) {
		JButton botao = null;
		if (e.getSource() instanceof JButton) {
			botao = (JButton) e.getSource();

			//adiciona apenas os numeros a caixa de visualizacao
			for(JButton numero : this.listaDeNumeros){
				if(botao.getText().equals(numero.getText())){
					caixaEntrada.setText(botao.getText());
				}
			}

			//verifica se foi selecionada uma operacao.
			//caso tenha sido pega o valor da caixa de entrada
			for (JButton op : this.operacoes) {
				if (botao.getText().equals(op.getText())) {
					valor1 = Double.parseDouble(caixaEntrada.getText());
					operacao = botao.getText();					
				}
			}
			//verifica se foi perguntado o resultado da operacao
			if (botao.getText().equals(btigual.getText())) {
				valor2 = Double.parseDouble(caixaEntrada.getText());				
				switch(operacao){
					case "+":
						caixaEntrada.setText(""+(valor1+valor2));
					break;
					case "-":
						caixaEntrada.setText(""+(valor1-valor2));
					break;
					case "*":
						caixaEntrada.setText(""+(valor1*valor2));
					break;
					case "/":
						caixaEntrada.setText(""+(valor1/valor2));
					break;
				}
			}
			//caso seja o CE, botao em branco, entao nao exibimos nada e esquecemos os valores.
			if(botao.getText().equals(btBranco.getText())){
				caixaEntrada.setText("");
				valor1 = 0;
				valor2 = 0;
			}

		}
	}
}
