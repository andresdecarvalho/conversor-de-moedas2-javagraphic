import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Conversor extends JFrame {

	private JPanel contentPane;
	private JTextField txtCotacao;
	private JTextField txtDolar;
	private JTextField txtReal;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conversor() {
		setTitle("Conversor de Moedas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setBounds(83, 146, 89, 23);
		contentPane.add(btnCalcular);
		
		txtCotacao = new JTextField();
		txtCotacao.setBounds(147, 95, 86, 20);
		contentPane.add(txtCotacao);
		txtCotacao.setColumns(10);
		
		txtDolar = new JTextField();
		txtDolar.setBounds(37, 95, 86, 20);
		contentPane.add(txtDolar);
		txtDolar.setColumns(10);
		
		txtReal = new JTextField();
		txtReal.setBounds(259, 95, 86, 20);
		contentPane.add(txtReal);
		txtReal.setColumns(10);
		
		JLabel lblReal = new JLabel("Valor do Real");
		lblReal.setBounds(259, 70, 86, 14);
		contentPane.add(lblReal);
		
		JLabel lblCotacao = new JLabel("Cota\u00E7\u00E3o");
		lblCotacao.setBounds(147, 70, 89, 14);
		contentPane.add(lblCotacao);
		
		JLabel lblDolarEuro = new JLabel("Dolar / Euro");
		lblDolarEuro.setBounds(37, 70, 86, 14);
		contentPane.add(lblDolarEuro);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(211, 146, 89, 23);
		contentPane.add(btnLimpar);
	}
	private void calcular() {
		double cotacao,dolar,real;
		DecimalFormat formatador= new DecimalFormat();
		dolar = Double.parseDouble(txtDolar.getText().replace(",","."));
		cotacao = Double.parseDouble(txtCotacao.getText().replace(",","."));
		real = dolar * cotacao;
		txtReal.setText(formatador.format(real));
		
	}
	private void limpar() {
		txtDolar.setText(null);
		txtReal.setText(null);
		txtCotacao.setText(null);
		
	}
}
