package frame_class;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code_class.Client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientInfoCheck extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPhone;
	private JTextField textEmail;
	
	/**
	 * Create the frame.
	 */
	public ClientInfoCheck(String a) {
		setTitle("Personal Info");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Client userA = new Client();
		userA = userA.getInfo(a);
		Client userB = userA;
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(230, 147, 103, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Arial", Font.PLAIN, 25));
		lblSex.setBounds(230, 207, 72, 18);
		contentPane.add(lblSex);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPhone.setBounds(230, 325, 92, 18);
		contentPane.add(lblPhone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 25));
		lblEmail.setBounds(230, 375, 103, 18);
		contentPane.add(lblEmail);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Arial", Font.PLAIN, 25));
		lblDateOfBirth.setBounds(230, 265, 153, 18);
		contentPane.add(lblDateOfBirth);
		
		textPhone = new JTextField();
		textPhone.setText(userA.clientPhone);
		textPhone.setFont(new Font("Arial", Font.PLAIN, 20));
		textPhone.setBounds(388, 325, 194, 29);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setText(userA.clientEmail);
		textEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		textEmail.setBounds(388, 376, 194, 29);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblDob = new JLabel("DOB");

		lblDob.setText(userA.clientDate.toString());
		lblDob.setFont(new Font("Arial", Font.PLAIN, 25));
		lblDob.setBounds(388, 265, 194, 29);
		contentPane.add(lblDob);
		
		JLabel lblSex_1 = new JLabel("SEX");
		lblSex_1.setText(userA.clientSex);
		lblSex_1.setFont(new Font("Arial", Font.PLAIN, 25));
		lblSex_1.setBounds(388, 207, 194, 29);
		contentPane.add(lblSex_1);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setText(userA.clientFname + " " + userA.clientLname);
		lblName.setFont(new Font("Arial", Font.PLAIN, 25));
		lblName.setBounds(388, 147, 279, 29);
		contentPane.add(lblName);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userB.clientPhone = textPhone.getText();
				userB.clientEmail = textEmail.getText();
				userB.updateInfo(userB);
				JOptionPane.showMessageDialog(null, "Modified successfully.");
			}
		});
		btnModify.setFont(new Font("Arial", Font.PLAIN, 25));
		btnModify.setBounds(220, 454, 113, 37);
		contentPane.add(btnModify);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientMain userB = new ClientMain(a);
				ClientInfoCheck.this.dispose();
			}
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 25));
		btnBack.setBounds(469, 454, 113, 37);
		contentPane.add(btnBack);
		
		JLabel lblPersonalInfomation = new JLabel("Personal Infomation");
		lblPersonalInfomation.setFont(new Font("Arial", Font.PLAIN, 30));
		lblPersonalInfomation.setBounds(269, 45, 272, 53);
		contentPane.add(lblPersonalInfomation);
	}
}
