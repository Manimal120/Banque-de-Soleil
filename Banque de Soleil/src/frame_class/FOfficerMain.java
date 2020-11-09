package frame_class;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import code_class.Client;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FOfficerMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollpane;
	private JButton btnTransferInfoCheck;
	private JButton btnNewButton;
	private JLabel lblNewLabel;



	/**
	 * Create the frame.
	 */
	public FOfficerMain() {
		
		setVisible(true);
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);
		
		Client user = new Client();
		ArrayList<Client> users = new ArrayList<Client>(); 
		
		users = user.getAll();
		
		String[] columnNames = {"Client ID", "First Name", "Last Name", "Gender", "DOB", "Phone", "Email"};
		
		String[][] tableValues = new String[users.size()][7];;
		
		for(int i = 0;i<users.size();i++) {
			tableValues[i][0] = users.get(i).clientId;
			tableValues[i][1] = users.get(i).clientFname;
			tableValues[i][2] = users.get(i).clientLname;
			tableValues[i][3] = users.get(i).clientSex;
			tableValues[i][4] = users.get(i).clientDate.toString();
			tableValues[i][5] = users.get(i).clientPhone;
			tableValues[i][6] = users.get(i).clientEmail;
		}
		
		table = new JTable(tableValues, columnNames);
		table.setEnabled(false);
				
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(new Color(255, 255, 255));
		table.setBounds(49, 100, 700, 170);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setRowHeight(21);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(49, 125, 700, 259);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		

		
		btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index newWIn = new Index();
				FOfficerMain.this.dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(655, 519, 125, 33);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Choose an Client:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(221, 397, 217, 39);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBox.setBounds(438, 402, 106, 33);
		for(int i = 0;i<users.size();i++) {
			comboBox.addItem(users.get(i).clientId);
		}
		contentPane.add(comboBox);
		
		
		JLabel lblClientsInfomation = new JLabel("Clients Infomation");
		lblClientsInfomation.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientsInfomation.setFont(new Font("Arial", Font.PLAIN, 28));
		lblClientsInfomation.setBounds(212, 53, 377, 39);
		contentPane.add(lblClientsInfomation);
	
		btnTransferInfoCheck = new JButton("Transfer History Check");
		btnTransferInfoCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clientID = (String)comboBox.getSelectedItem();
				FOfficerTransCheck newCheck = new FOfficerTransCheck(clientID);
				FOfficerMain.this.dispose();
			}
		});
		btnTransferInfoCheck.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTransferInfoCheck.setBounds(247, 464, 274, 33);
		contentPane.add(btnTransferInfoCheck);
		
	}
}
