package frame_class;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code_class.Fofficer;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FOfficerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Create the frame.
	 */
	public FOfficerLogin() {
		setTitle("Welcome!");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenue = new JLabel("Front Management System");
		lblBienvenue.setFont(new Font("Arial", Font.BOLD, 35));
		lblBienvenue.setBounds(45, 46, 454, 88);
		contentPane.add(lblBienvenue);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 25));
		lblUsername.setBounds(197, 213, 136, 38);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPassword.setBounds(197, 301, 124, 29);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fofficer userA = new Fofficer();
				
				if(userA.loginCheck(textField.getText(), String.copyValueOf(passwordField.getPassword()))) {

					FOfficerMain newWIn = new FOfficerMain();
					FOfficerLogin.this.dispose();
					
				}else {
					JOptionPane.showMessageDialog(null, "Your account or password is wrong, please enter it again!", "Warning",JOptionPane.ERROR_MESSAGE); 
					textField.setText("");
					passwordField.setText("");
				}
				
				
			
			}
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 20));
		btnLogin.setBounds(220, 401, 124, 38);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index newWIn1 = new Index();
				FOfficerLogin.this.dispose();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancel.setBounds(427, 401, 124, 38);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 25));
		textField.setBounds(349, 222, 191, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 25));
		passwordField.setBounds(349, 301, 191, 29);
		contentPane.add(passwordField);
	}
}
