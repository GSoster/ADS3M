package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.*;

public class EditarPessoa extends JFrame implements ActionListener {

	private CRUD parent;

	private JPanel painelGeral, painelBotoes, painelEntrada;
	private JTextField tfNome, tfIdade;
	private JLabel lbNome, lbIdade;
	private JButton btOK, btCancelar;

	private Pessoa pessoaRecebida;

	private int indice;
	private Pessoa pessoa;

	public EditarPessoa(CRUD parent, int indice, Pessoa p) {
		super("Formulário Editar Pessoa");
		this.indice = indice;
		this.parent = parent;
		pessoaRecebida = p;

		setResizable(true);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
		setLocationRelativeTo(null);// centraliza
		iniciarElementos();
		adicionarElementos();
		setVisible(true);
	}

	private void iniciarElementos() {
		btOK = new JButton("OK");
		btCancelar = new JButton("Cancelar");

		lbNome = new JLabel("Nome: ");
		lbIdade = new JLabel("Idade: ");

		tfNome = new JTextField(20);
		tfNome.setText(pessoaRecebida.getNome());
		tfIdade = new JTextField(20);
		tfIdade.setText(pessoaRecebida.getIdade() + "");

		painelGeral = new JPanel();
		painelBotoes = new JPanel();
		painelBotoes.setLayout(new FlowLayout());
		painelEntrada = new JPanel();
		painelEntrada.setLayout(new GridLayout(2, 1));
	}

	private void adicionarElementos() {
		painelEntrada.add(lbNome, tfNome);
		painelEntrada.add(tfNome);
		painelEntrada.add(lbIdade, tfIdade);
		painelEntrada.add(tfIdade);

		painelBotoes.add(btOK);
		painelBotoes.add(btCancelar);

		painelGeral.add(painelEntrada);
		painelGeral.add(painelBotoes);

		btOK.addActionListener(this);
		btCancelar.addActionListener(this);

		this.add(painelGeral);
	}

	public void actionPerformed(ActionEvent e) {
		JButton botao = null;
		if (e.getSource() instanceof JButton) {
			botao = (JButton) e.getSource();

			switch (botao.getText()) {
			case "OK":
				pessoa = new Pessoa(tfNome.getText(), Integer.parseInt(tfIdade
						.getText()));
				JOptionPane.showConfirmDialog(this,
						"Alteração realizada com sucesso!", "Editar",
						JOptionPane.CLOSED_OPTION);
				parent.editarPessoaDaLista(pessoa, this.indice);
				this.dispose();
				break;
			case "Cancelar":
				this.dispose();
				break;
			}

		}
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

}
