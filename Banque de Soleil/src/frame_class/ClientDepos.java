package frame_class;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code_class.Account;
import code_class.Deposit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientDepos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAmount;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ClientDepos(String a) {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepositToYour = new JLabel("Deposit to Your Account");
		lblDepositToYour.setFont(new Font("Arial", Font.PLAIN, 25));
		lblDepositToYour.setBounds(245, 124, 283, 49);
		contentPane.add(lblDepositToYour);
		
		JLabel lblChooseAnAcount = new JLabel("Choose an Acount:");
		lblChooseAnAcount.setFont(new Font("Arial", Font.PLAIN, 20));
		lblChooseAnAcount.setBounds(178, 253, 192, 49);
		contentPane.add(lblChooseAnAcount);
		
		Account acc1 = new Account();
		ArrayList<Account> acc = acc1.getAcc(a);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBox.setBounds(401, 262, 111, 30);
		for(int i = 0;i<acc.size();i++) {
			comboBox.addItem(acc.get(i).cardId);
		}
		contentPane.add(comboBox);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAmount.setBounds(178, 324, 169, 37);
		contentPane.add(lblAmount);
		
		textFieldAmount = new JTextField();
		textFieldAmount.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldAmount.setBounds(401, 326, 111, 33);
		contentPane.add(textFieldAmount);
		textFieldAmount.setColumns(10);
		
		JLabel lblPassword = new JLabel("Transaction Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(169, 390, 212, 24);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(401, 382, 111, 33);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double amount = Double.valueOf(textFieldAmount.getText());
				Account accA = new Account();
				accA = accA.getOneAcc((String)comboBox.getSelectedItem());
				
				
				if(amount <= 0) {
					
					JOptionPane.showMessageDialog(null, "Wrong Amount!", "Warning",JOptionPane.ERROR_MESSAGE);

				}else if(accA.cardPsd.equals(String.copyValueOf(passwordField.getPassword()))) {
					
					accA.cardBalance += amount;
					accA.updateInfo(accA);
					
					Deposit deposA = new Deposit();
					deposA.deposAmount = amount;
					deposA.deposOwnerId = a;
					deposA.deposToCardId = accA.cardId;
					deposA.deposBalance = accA.cardBalance;
					deposA.setDepos(deposA);
					
					
					
					JOptionPane.showMessageDialog(null, "Transfered Successfully.");
					
					ClientAccountInfo newWindow = new ClientAccountInfo(a);
					ClientDepos.this.dispose();
					
				}else {
					JOptionPane.showMessageDialog(null, "Wrong Password!", "Warning",JOptionPane.ERROR_MESSAGE);

				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(220, 468, 123, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1.setBounds(422, 468, 123, 33);
		contentPane.add(btnNewButton_1);
	}
}
