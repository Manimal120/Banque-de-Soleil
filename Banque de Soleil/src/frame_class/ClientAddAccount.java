package frame_class;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code_class.Account;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ClientAddAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField CardIdText;
	private JPasswordField passwordField;


	/**
	 * Create the frame.
	 */
	public ClientAddAccount(String a) {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddYourNew = new JLabel("Add Your New Card");
		lblAddYourNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddYourNew.setFont(new Font("Arial", Font.PLAIN, 25));
		lblAddYourNew.setBounds(256, 112, 273, 48);
		contentPane.add(lblAddYourNew);
		
		JLabel lblNewLabel = new JLabel("Card ID:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(275, 249, 100, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblTransactionPassword = new JLabel("Transaction Password:");
		lblTransactionPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTransactionPassword.setBounds(149, 302, 213, 24);
		contentPane.add(lblTransactionPassword);
		
		CardIdText = new JTextField();
		CardIdText.setFont(new Font("Arial", Font.PLAIN, 20));
		CardIdText.setBounds(385, 249, 171, 24);
		contentPane.add(CardIdText);
		CardIdText.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(385, 302, 171, 25);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CardIdText.getText().equals("") || String.copyValueOf(passwordField.getPassword()).equals("")){
					JOptionPane.showMessageDialog(null, "Invalid Input!", "Warning",JOptionPane.ERROR_MESSAGE);
				}else {
					
					Account acc = new Account();
					
					ArrayList<String> cardsID = new ArrayList<String>();
					
					cardsID = acc.getAllAccId();
					int errorCount = 0;
					
					for(int m=0;m<cardsID.size();m++) {
						if(CardIdText.getText().equals(cardsID.get(m))){
							errorCount++;
						}	
					}
					
					if(errorCount!=0) {
						JOptionPane.showMessageDialog(null, "This card can't be added.", "Warning",JOptionPane.ERROR_MESSAGE);
					}else {
					
					acc.cardBalance = 0;
					acc.cardId = CardIdText.getText();
					acc.cardPsd = String.copyValueOf(passwordField.getPassword());
					acc.cardOwnerId = a;
					acc.setAcc(acc);
					JOptionPane.showMessageDialog(null, "Operated successfully.");
					
					ClientAccountInfo newWin = new ClientAccountInfo(a);
					ClientAddAccount.this.dispose();
					}
				
			}}});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(215, 421, 128, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientAccountInfo newWin1 = new ClientAccountInfo(a);
				ClientAddAccount.this.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1.setBounds(475, 421, 117, 33);
		contentPane.add(btnNewButton_1);
		
		
	}

}
