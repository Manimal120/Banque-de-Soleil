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

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientTransferInternal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMoney;
	private JTextField textFieldTransPsd;

	/**
	 * Create the frame.
	 */
	public ClientTransferInternal(String a) {
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
		
		
		JLabel lblTransferToYour = new JLabel("Transfer to Your Other Account");
		lblTransferToYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransferToYour.setFont(new Font("Arial", Font.PLAIN, 25));
		lblTransferToYour.setBounds(222, 94, 365, 65);
		contentPane.add(lblTransferToYour);
		
		JComboBox<String> comboBoxFrom = new JComboBox<String>();
		comboBoxFrom.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxFrom.setBounds(174, 236, 139, 25);
		for(int i = 0;i<acc.size();i++) {
			comboBoxFrom.addItem(acc.get(i).cardId);
		}
		
		contentPane.add(comboBoxFrom);
		
		JLabel lblTo = new JLabel("TO");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTo.setBounds(364, 236, 54, 25);
		contentPane.add(lblTo);
		
		JComboBox<String> comboBoxTo = new JComboBox<String>();
		comboBoxTo.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxTo.setBounds(461, 236, 139, 25);
		for(int k = 0;k<acc.size();k++) {
			comboBoxTo.addItem(acc.get(k).cardId);
		}
		contentPane.add(comboBoxTo);
		
		textFieldMoney = new JTextField(null);
		textFieldMoney.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldMoney.setBounds(461, 304, 139, 29);
		contentPane.add(textFieldMoney);
		textFieldMoney.setColumns(10);
		
		JLabel lblPleaseInputThe = new JLabel("Please Input the Amount:");
		lblPleaseInputThe.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPleaseInputThe.setBounds(174, 304, 244, 29);
		contentPane.add(lblPleaseInputThe);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(((String)comboBoxFrom.getSelectedItem()).equals((String)comboBoxTo.getSelectedItem())) {
				
					JOptionPane.showMessageDialog(null, "Please select right cards.", "Warning",JOptionPane.ERROR_MESSAGE);
				
				}else if(textFieldMoney.getText().equals("0") || textFieldMoney.getText().equals("")){
				
					JOptionPane.showMessageDialog(null, "Please input the right amount.", "Warning",JOptionPane.ERROR_MESSAGE);
				
				}else {
				
					Account accA = new Account();
					Account accB = new Account();
					accA = accA.getOneAcc((String)comboBoxFrom.getSelectedItem());
					accB = accB.getOneAcc((String)comboBoxTo.getSelectedItem());
					
					double amount = Double.valueOf(textFieldMoney.getText());
					
					if(accA.cardBalance<amount) {
						
						JOptionPane.showMessageDialog(null, "Insufficient Funds.", "Warning",JOptionPane.ERROR_MESSAGE);
					
					}else if(accA.cardPsd.equals(textFieldTransPsd.getText())){
						
						accA.cardBalance -= amount;
						accB.cardBalance += amount;
						accA.updateInfo(accA);
						accB.updateInfo(accB);
						
						Transfer infoA =new Transfer();
						infoA.transCardId = accA.cardId;
						infoA.transToCardId = accB.cardId;
						infoA.transCardBalance = accA.cardBalance;
						infoA.transToCardBalance = accB.cardBalance;
						infoA.transAmount = amount;
						infoA.setTrans(infoA);
						
						JOptionPane.showMessageDialog(null, "Transfered Successfully.");
						
						ClientAccountInfo newWindow = new ClientAccountInfo(a);
						ClientTransferInternal.this.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Wrong Password!", "Warning",JOptionPane.ERROR_MESSAGE);
					}}}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(222, 438, 125, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientAccountInfo newAccInfo = new ClientAccountInfo(a);
				ClientTransferInternal.this.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1.setBounds(422, 438, 125, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel lblPleaseInputThe_1 = new JLabel("Transaction Password:");
		lblPleaseInputThe_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPleaseInputThe_1.setBounds(174, 354, 346, 33);
		contentPane.add(lblPleaseInputThe_1);
		
		textFieldTransPsd = new JTextField();
		textFieldTransPsd.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldTransPsd.setBounds(461, 358, 139, 29);
		contentPane.add(textFieldTransPsd);
		textFieldTransPsd.setColumns(10);
	
		
	
	}
}
