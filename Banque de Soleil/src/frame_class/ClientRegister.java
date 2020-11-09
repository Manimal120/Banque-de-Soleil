package frame_class;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code_class.Client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class ClientRegister extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fNameText;
	private JTextField lNameText;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textPsd;
	private JTextField textAuthor;
	private JTextField textDate;


	/**
	 * Create the frame.
	 */
	public ClientRegister() {
		setTitle("Client Register");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(165, 132, 137, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(165, 179, 137, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(165, 290, 126, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(165, 332, 126, 29);
		contentPane.add(lblNewLabel_3);
		
		JComboBox<String> comboSex = new JComboBox<String>();
		comboSex.addItem("Male");
		comboSex.addItem("Female");
		
		comboSex.setFont(new Font("Arial", Font.PLAIN, 25));
		comboSex.setBounds(409, 217, 208, 27);
		contentPane.add(comboSex);
		
		fNameText = new JTextField();
		fNameText.setFont(new Font("Arial", Font.PLAIN, 25));
		fNameText.setBounds(409, 137, 208, 29);
		contentPane.add(fNameText);
		fNameText.setColumns(10);
		
		lNameText = new JTextField();
		lNameText.setFont(new Font("Arial", Font.PLAIN, 25));
		lNameText.setBounds(409, 179, 208, 29);
		contentPane.add(lNameText);
		lNameText.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("Arial", Font.PLAIN, 25));
		textPhone.setBounds(409, 290, 208, 29);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Arial", Font.PLAIN, 25));
		textEmail.setBounds(409, 332, 208, 29);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPleaseInputYour = new JLabel("Please input your information:");
		lblPleaseInputYour.setFont(new Font("Arial", Font.PLAIN, 30));
		lblPleaseInputYour.setBounds(216, 65, 417, 29);
		contentPane.add(lblPleaseInputYour);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client userA = new Client();
				
				
				if(userA.loginCheck(textAuthor.getText(), textPsd.getText())) {
					
					userA = userA.getInfo(textAuthor.getText());
					
					if(userA.clientSex.equals("0")) {
					
					userA.clientId = textAuthor.getText();
					userA.clientPsd = textPsd.getText();
					userA.clientFname = fNameText.getText();
					userA.clientLname = lNameText.getText();
					userA.clientEmail = textEmail.getText();
					userA.clientPhone = textPhone.getText();
					userA.clientSex = (String)comboSex.getSelectedItem();
					userA.clientDate = Date.valueOf(textDate.getText()); 
					userA.setInfo(userA);
					JOptionPane.showMessageDialog(null, "Registered successfully!");  
					ClientLogin newWindow1 = new ClientLogin();
					ClientRegister.this.dispose();
					
					}else{
					
						JOptionPane.showMessageDialog(null, "Your registration information is wrong, please contact the bank staff.", "Error",JOptionPane.ERROR_MESSAGE);  
						ClientLogin newWindow = new ClientLogin();
						ClientRegister.this.dispose();
					
					}
				}else {
					JOptionPane.showMessageDialog(null, "Your registration information is wrong, please contact the bank staff.", "Error",JOptionPane.ERROR_MESSAGE);  
					ClientLogin newWindow4 = new ClientLogin();
					ClientRegister.this.dispose();
				}
			}});
		btnConfirm.setFont(new Font("Arial", Font.PLAIN, 25));
		btnConfirm.setBounds(200, 475, 154, 38);
		contentPane.add(btnConfirm);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientLogin newWindow = new ClientLogin();
				ClientRegister.this.dispose();
			}
		});
		btnCancle.setFont(new Font("Arial", Font.PLAIN, 25));
		btnCancle.setBounds(436, 475, 157, 38);
		contentPane.add(btnCancle);
		
		JLabel lblLoginPassword = new JLabel("Login Password:");
		lblLoginPassword.setFont(new Font("Arial", Font.PLAIN, 25));
		lblLoginPassword.setBounds(165, 416, 208, 29);
		contentPane.add(lblLoginPassword);
		
		textPsd = new JTextField();
		textPsd.setFont(new Font("Arial", Font.PLAIN, 25));
		textPsd.setBounds(409, 416, 208, 29);
		contentPane.add(textPsd);
		textPsd.setColumns(10);
		
		JLabel lblAuthorityCode = new JLabel("Authorization Code:");
		lblAuthorityCode.setFont(new Font("Arial", Font.PLAIN, 25));
		lblAuthorityCode.setBounds(165, 374, 236, 29);
		contentPane.add(lblAuthorityCode);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Arial", Font.PLAIN, 25));
		lblSex.setBounds(165, 221, 72, 29);
		contentPane.add(lblSex);
		
		textAuthor = new JTextField();
		textAuthor.setFont(new Font("Arial", Font.PLAIN, 25));
		textAuthor.setBounds(409, 374, 208, 29);
		contentPane.add(textAuthor);
		textAuthor.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Date of Birth:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(165, 252, 162, 29);
		contentPane.add(lblNewLabel_4);
		
		textDate = new JTextField();
		textDate.setToolTipText("");
		textDate.setFont(new Font("Arial", Font.PLAIN, 25));
		textDate.setBounds(409, 250, 208, 32);
		contentPane.add(textDate);
		textDate.setColumns(10);
		textDate.setText("yyyy-mm-dd");
		textDate.setForeground(Color.GRAY);
		textDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String temp1 = textDate.getText();
				if(temp1.equals("yyyy-mm-dd")) {
					textDate.setText("");
					textDate.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				String temp2 = textDate.getText();
				if(temp2.equals("")) {
					textDate.setForeground(Color.GRAY);
					textDate.setText("yyyy-mm-dd");
				}
			}
		});
	}
}
