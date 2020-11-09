package frame_class;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code_class.Account;
import code_class.Transfer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientTransferExternal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTransTo;
	private JPasswordField passwordField;
	private JTextField textFieldAmount;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ClientTransferExternal(String a) {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Account acc1 = new Account();
		ArrayList<Account> acc = acc1.getAcc(a);
		
		JLabel lblTransferToAn = new JLabel("Transfer to an External Account");
		lblTransferToAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransferToAn.setFont(new Font("Arial", Font.PLAIN, 25));
		lblTransferToAn.setBounds(200, 106, 434, 51);
		contentPane.add(lblTransferToAn);
		
		JLabel lblSelectYourAccount = new JLabel("Select your account:");
		lblSelectYourAccount.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSelectYourAccount.setBounds(185, 229, 187, 32);
		contentPane.add(lblSelectYourAccount);
		
		JComboBox<String> comboBoxYourAcc = new JComboBox<String>();
		comboBoxYourAcc.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxYourAcc.setBounds(476, 232, 144, 26);
		for(int k = 0;k<acc.size();k++) {
			comboBoxYourAcc.addItem(acc.get(k).cardId);
		}
		contentPane.add(comboBoxYourAcc);
		
		JLabel lblTransferTo = new JLabel("Transfer to(card id):");
		lblTransferTo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTransferTo.setBounds(185, 271, 187, 32);
		contentPane.add(lblTransferTo);
		
		textFieldTransTo = new JTextField();
		textFieldTransTo.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldTransTo.setBounds(476, 268, 144, 32);
		contentPane.add(textFieldTransTo);
		textFieldTransTo.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordField.setBounds(476, 350, 144, 32);
		contentPane.add(passwordField);
		
		JLabel lblTransactionPassword = new JLabel("Transaction password:");
		lblTransactionPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTransactionPassword.setBounds(185, 350, 209, 32);
		contentPane.add(lblTransactionPassword);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account acc1 = new Account();
				acc1 = acc1.getOneAcc(textFieldTransTo.getText());
				
				
				if(((String)comboBoxYourAcc.getSelectedItem()).equals(textFieldTransTo.getText())) {
					JOptionPane.showMessageDialog(null, "Please select right cards.", "Warning",JOptionPane.ERROR_MESSAGE);
				}else
				if(acc1.cardId.equals("NO")) {
					JOptionPane.showMessageDialog(null, "No such account.", "Warning",JOptionPane.ERROR_MESSAGE);
				}else if(textFieldAmount.getText().equals("0") || textFieldAmount.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please input the right amount.", "Warning",JOptionPane.ERROR_MESSAGE);
				}else {
					Account accA = new Account();
					accA = accA.getOneAcc((String)comboBoxYourAcc.getSelectedItem());
					
					double amount = Double.valueOf(textFieldAmount.getText());
					
					if(accA.cardBalance<amount) {
						
						JOptionPane.showMessageDialog(null, "Insufficient Funds.", "Warning",JOptionPane.ERROR_MESSAGE);

					}else if(accA.cardPsd.equals(String.copyValueOf(passwordField.getPassword()))) {
						
						accA.cardBalance -= amount;
						acc1.cardBalance += amount;
						accA.updateInfo(accA);
						acc1.updateInfo(acc1);
						
						Transfer infoA =new Transfer();
						infoA.transCardId = accA.cardId;
						infoA.transToCardId = acc1.cardId;
						infoA.transCardBalance = accA.cardBalance;
						infoA.transToCardBalance = acc1.cardBalance;
						infoA.transAmount = amount;
						infoA.setTrans(infoA);
						
						JOptionPane.showMessageDialog(null, "Transfered Successfully.");
						
						ClientAccountInfo newWindow = new ClientAccountInfo(a);
						ClientTransferExternal.this.dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "Wrong Password!", "Warning",JOptionPane.ERROR_MESSAGE);

					}
				}
			
			}
		});
		btnConfirm.setFont(new Font("Arial", Font.PLAIN, 20));
		btnConfirm.setBounds(225, 455, 127, 32);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientAccountInfo newAccInfo = new ClientAccountInfo(a);
				ClientTransferExternal.this.dispose();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancel.setBounds(468, 456, 127, 30);
		contentPane.add(btnCancel);
		
		textFieldAmount = new JTextField(null);
		textFieldAmount.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldAmount.setBounds(476, 310, 144, 32);
		contentPane.add(textFieldAmount);
		textFieldAmount.setColumns(10);
		
		JLabel lblTransferAmount = new JLabel("Transfer Amount:");
		lblTransferAmount.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTransferAmount.setBounds(185, 313, 166, 26);
		contentPane.add(lblTransferAmount);
		
		
		
		
	}
}
