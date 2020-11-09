package frame_class;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code_class.Client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ClientLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField passwordPsd;
	/**
	 * Create the frame.
	 */
	public ClientLogin() {
		setVisible(true);
		setResizable(false);
		setTitle("Welcome to Banque de soleil !");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenue = new JLabel("Bienvenue!");
		lblBienvenue.setFont(new Font("Ink Free", Font.BOLD, 66));
		lblBienvenue.setBounds(45, 46, 356, 88);
		contentPane.add(lblBienvenue);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Arial", Font.PLAIN, 30));
		textUsername.setBounds(412, 230, 223, 38);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		passwordPsd = new JPasswordField();
		passwordPsd.setFont(new Font("Arial", Font.PLAIN, 30));
		passwordPsd.setBounds(412, 299, 223, 38);
		contentPane.add(passwordPsd);
		
		JLabel lblNewLabel = new JLabel("Authorization Code:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel.setBounds(110, 230, 269, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(236, 299, 143, 38);
		contentPane.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index newIndex = new Index();
				ClientLogin.this.dispose();
			}
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 25));
		btnBack.setBounds(317, 477, 110, 38);
		contentPane.add(btnBack);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Client userA = new Client();
			if(userA.loginCheck(textUsername.getText(), String.copyValueOf(passwordPsd.getPassword()))) {
				userA = userA.getInfo(textUsername.getText());
				if(userA.clientSex.equals("0")) {
					JOptionPane.showMessageDialog(null, "Your account has not been registered yet, please register first.");
					textUsername.setText("");
					passwordPsd.setText("");
				}else {
					ClientMain userB = new ClientMain(userA.clientId);
					ClientLogin.this.dispose();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Your account or password is wrong, please enter it again!", "Warning",JOptionPane.ERROR_MESSAGE); 
				textUsername.setText("");
				passwordPsd.setText("");
			}
		}});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 25));
		btnLogin.setBounds(163, 408, 134, 38);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientRegister newRegis = new ClientRegister();
				ClientLogin.this.dispose();
			}
		});
		btnRegister.setFont(new Font("Arial", Font.PLAIN, 25));
		btnRegister.setBounds(444, 408, 134, 38);
		contentPane.add(btnRegister);
		
		
	}
}
	

