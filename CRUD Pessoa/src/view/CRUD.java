package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import model.Pessoa;

public class CRUD extends JFrame implements ActionListener {

	private JPanel painelPricipal, painelBotoes, painelLista;
	private JButton btNovo, btEditar, btRemover, btNovoToolBar,
			btEditarToolBar, btRemoverToolBar;
	private CadastroPessoa cadPessoa;
	private EditarPessoa editPessoa;
	private DefaultListModel model;
	private JList<String> listaDePessoas;
	private JToolBar toolBar;

	public CRUD() {
		super("CRUD de Pessoas");
		configurarFrame();
		iniciarElementos();
		setVisible(true);
	}

	/**
	 * Aqui ficam as definicoes da janela geral (Frame)
	 */
	private void configurarFrame() {
		setSize(500, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	/**
	 * Método que agrega todos os outros responsaveis por iniciar/configurar
	 * elementos.
	 */
	private void iniciarElementos() {
		iniciarPaineis();
		iniciarBotoes();
		iniciarMenu();
		inciciarListaDePessoas();
		adicionarElementos();
		iniciarToolBar();
	}

	/**
	 * Cria um modelo (onde sao inseridos os dados) e o atribui a lista.
	 */
	private void inciciarListaDePessoas() {
		model = new DefaultListModel();
		listaDePessoas = new JList(model);
	}

	/**
	 * Executa o construtor dos paineis e seta os layouts.
	 */
	private void iniciarPaineis() {
		painelPricipal = new JPanel();
		painelPricipal.setLayout(new BorderLayout());
		painelBotoes = new JPanel();
		painelBotoes.setLayout(new FlowLayout());
		painelLista = new JPanel();
	}

	/**
	 * executa o construtor dos botoes e adiciona listeners a eles.
	 */
	private void iniciarBotoes() {
		btNovo = new JButton("Novo");
		btEditar = new JButton("Editar");
		btRemover = new JButton("Remover");
		btNovoToolBar = new JButton("Novo");
		btEditarToolBar = new JButton("Editar");
		btRemoverToolBar = new JButton("Remover");

		btNovo.addActionListener(this);
		btEditar.addActionListener(this);
		btRemover.addActionListener(this);
		btNovoToolBar.addActionListener(this);
		btEditarToolBar.addActionListener(this);
		btRemoverToolBar.addActionListener(this);
	}

	/**
	 * inicia um objeto JMenu adiciona os itens ao menu adiciona Mnemonico
	 * adiciona atalho para os itens do menu
	 */
	private void iniciarMenu() {
		// criando menubar e menus
		JMenuBar menuBar = new JMenuBar();
		JMenu menuArquivo = new JMenu("Arquivo");
		JMenu menuAjuda = new JMenu("Ajuda");

		JMenuItem itemNovo = new JMenuItem("Novo");
		JMenuItem itemEditar = new JMenuItem("Editar");
		JMenuItem itemRemover = new JMenuItem("Remover");
		JMenuItem itemSair = new JMenuItem("Sair");

		itemNovo.addActionListener(this);
		itemEditar.addActionListener(this);
		itemRemover.addActionListener(this);

		itemSair.setMnemonic(KeyEvent.VK_S);
		itemSair.setToolTipText("Finaliza a aplicação");// adiciona testo de
														// ajuda
		itemSair.setAccelerator(// adiciona uma tecla de atalho
		// KeyStroke.getKeyStroke("control X")// apertando apenas control + x se
		// fecha a aplicação
		KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK)// tecla +
																	// mascara
																	// (control/alt,
																	// etc)
		);
		itemSair.setIcon(createImageIcon("jv.png", "jv.png"));

		itemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// adicionando itens ao menu
		menuArquivo.add(itemNovo);
		menuArquivo.add(itemEditar);
		menuArquivo.add(itemRemover);
		menuArquivo.add(itemSair);

		// adicionando mnemonicos
		menuArquivo.setMnemonic(KeyEvent.VK_A);
		menuAjuda.setMnemonic(KeyEvent.VK_J);
		// adicionando menus ao menu bar
		menuBar.add(menuArquivo);
		menuBar.add(Box.createHorizontalGlue());// 'gruda'(glue = cola) os
												// elementos que forem
												// adicionados a seguir na
												// direita.
		menuBar.add(menuAjuda);
		this.setJMenuBar(menuBar);
	}

	/**
	 * Inicia a toolBar e adiciona os botoes a ela.
	 */
	private void iniciarToolBar() {
		JButton btNovoToolBar = btNovo;
		toolBar = new JToolBar();
		toolBar.add(this.btNovoToolBar);
		toolBar.add(this.btEditarToolBar);
		toolBar.add(this.btRemoverToolBar);
		toolBar.setBackground(Color.BLUE);

		this.add(toolBar, BorderLayout.NORTH);
	}

	protected static ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = CRUD.class.getResource(path);
		if (imgURL != null) {
			System.out.println(imgURL);
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("arquivo nao encontrado" + path);
			return null;
		}
	}

	/**
	 * Adiciona os elementos a seus respectivos paineis, adiciona os paineis ao
	 * frame (janela principal)
	 */
	private void adicionarElementos() {
		painelLista.add(listaDePessoas);
		painelBotoes.add(btNovo);
		painelBotoes.add(btEditar);
		painelBotoes.add(btRemover);
		painelPricipal.add(painelLista, BorderLayout.CENTER);
		painelPricipal.add(painelBotoes, BorderLayout.SOUTH);

		this.add(painelPricipal);
	}

	/**
	 * responsavel por atualizar o componente grafico listaDePessoas (JList)
	 * para que exiba corretamente as pessoas após uma inclusao/edicao ou
	 * alteracao
	 */
	private void atualizarLista() {
		listaDePessoas.updateUI();
	}

	/**
	 * Metodo que e executado a partir da tela "CadastroPessoa" Recebe uma
	 * objeto do tipo pessoa(p) e adiciona a listaDePessoas(JList)
	 * 
	 * @param p
	 */
	public void adicionarPessoaALista(Pessoa p) {
		model.addElement(p);
		atualizarLista();
	}

	public void editarPessoaDaLista(Pessoa p, int indice) {
		model.remove(indice);
		model.add(indice, p);
		atualizarLista();
	}

	/**
	 * Trata escolhas feitas pelo usuario ao clicar nos botoes/menuItem
	 */
	public void actionPerformed(ActionEvent e) {
		JButton botao = null;
		JMenuItem item = null;
		int index;
		if (e.getSource() instanceof JButton) {
			botao = (JButton) e.getSource();
			switch (botao.getText()) {
			case "Novo":
				System.out.println("novo!");				
				cadPessoa = new CadastroPessoa(this);
				break;
			case "Editar":
				index = listaDePessoas.getSelectedIndex();
				editPessoa = new EditarPessoa(this, index,
						(Pessoa) model.get(index));

				break;
			case "Remover":
				index = listaDePessoas.getSelectedIndex();
				System.out.println(index);
				model.remove(index);
				atualizarLista();
				break;
			}

		}

		if (e.getSource() instanceof JMenuItem) {
			item = (JMenuItem) e.getSource();
			switch (item.getText()) {
			case "Novo":
				System.out.println("novo!");				
				cadPessoa = new CadastroPessoa(this);
				break;
			case "Editar":
				index = listaDePessoas.getSelectedIndex();
				editPessoa = new EditarPessoa(this, index,
						(Pessoa) model.get(index));

				break;
			case "Remover":
				index = listaDePessoas.getSelectedIndex();
				System.out.println(index);
				model.remove(index);
				atualizarLista();
				break;
			}

		}

	}

}
