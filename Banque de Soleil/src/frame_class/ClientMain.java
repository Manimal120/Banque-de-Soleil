package frame_class;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code_class.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	private String userName;
//	private ClientOb client;


	public ClientMain(String a) {
		setTitle("Welcome!");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);
		
		Client userA = new Client();
		userA = userA.getInfo(a);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblBienvenue = new JLabel("Bienvenue,");
		lblBienvenue.setFont(new Font("Ink Free", Font.BOLD, 35));
		lblBienvenue.setBounds(45, 46, 221, 88);
		contentPane.add(lblBienvenue);
		
		JLabel lblNewLabel = new JLabel();//get the user name
		lblNewLabel.setText(userA.clientFname + " " + userA.clientLname);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel.setBounds(256, 57, 391, 60);
		contentPane.add(lblNewLabel);
		
		JButton btnCheckAccounts = new JButton("Accounts Info");
		btnCheckAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				ClientAccountInfo newAccInfo = new ClientAccountInfo(a);
				ClientMain.this.dispose();
			}
		});
		btnCheckAccounts.setFont(new Font("Arial", Font.PLAIN, 25));
		btnCheckAccounts.setBounds(173, 255, 199, 39);
		contentPane.add(btnCheckAccounts);
		
		JButton btnNewButton = new JButton("Personal Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientInfoCheck newCheck = new ClientInfoCheck(a);
				ClientMain.this.dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNewButton.setBounds(418, 255, 199, 39);
		contentPane.add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index newWindow = new Index();
				ClientMain.this.dispose();
			}
		});
		btnLogOut.setFont(new Font("Arial", Font.PLAIN, 25));
		btnLogOut.setBounds(301, 376, 185, 39);
		contentPane.add(btnLogOut);
	}
}
