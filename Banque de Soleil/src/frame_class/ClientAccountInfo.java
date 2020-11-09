package frame_class;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import code_class.Account;

import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientAccountInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_3;
	private JButton btnTransferExternal;
	private JButton btnNewButton_2;
	private JButton btnTransferHistory;
	private JButton btnExpoot;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ClientAccountInfo(String a) {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		
		Account acc1 = new Account();
		ArrayList<Account> acc = acc1.getAcc(a);
		
		String[] columnNames = {"Card ID", "Balance"};
		String[][] tableValues = new String[acc.size()][2];
		
		for(int i = 0;i<acc.size();i++) {
				tableValues[i][0] = acc.get(i).cardId;
				tableValues[i][1] = "" + acc.get(i).cardBalance;
		}
		contentPane.setLayout(null);
		
		
		table = new JTable(tableValues, columnNames);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(new Color(255, 255, 255));
		table.setBounds(139, 100, 527, 328);
		table.setFont(new Font("Arial", Font.PLAIN, 20));
		table.setRowHeight(21);
		getContentPane().add(table);
		
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBounds(139, 81, 527, 20);
		tableHeader.setFont(new Font("Arial", Font.PLAIN, 20));
		getContentPane().add(tableHeader);
		
		JButton btnNewButton = new JButton("Add New Card");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			ClientAddAccount newWin1 = new ClientAddAccount(a);
			ClientAccountInfo.this.dispose();
			
			
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(306, 496, 200, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientMain newMain = new ClientMain(a);
				ClientAccountInfo.this.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1.setBounds(528, 496, 200, 43);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_3 = new JButton("Transfer Internal");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientTransferInternal newTransIn = new ClientTransferInternal(a);
				ClientAccountInfo.this.dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_3.setBounds(84, 438, 200, 43);
		contentPane.add(btnNewButton_3);
		
		btnTransferExternal = new JButton("Transfer External");
		btnTransferExternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientTransferExternal newTransEx = new ClientTransferExternal(a);
				ClientAccountInfo.this.dispose();
			}
		});
		btnTransferExternal.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTransferExternal.setBounds(306, 438, 200, 43);
		contentPane.add(btnTransferExternal);
		
		btnNewButton_2 = new JButton("Deposit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			ClientDepos newWin4 = new ClientDepos(a);
			ClientAccountInfo.this.dispose();
			
			
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_2.setBounds(84, 496, 200, 43);
		contentPane.add(btnNewButton_2);
		
		btnTransferHistory = new JButton("Transfer History");
		btnTransferHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ClientTransHis newWin3 = new ClientTransHis(a);
			ClientAccountInfo.this.dispose();
			}
		});
		btnTransferHistory.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTransferHistory.setBounds(528, 438, 200, 43);
		contentPane.add(btnTransferHistory);
		
		btnExpoot = new JButton("Export");
		btnExpoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Account A = new Account();
				A = A.getOneAcc(a);
				A.printCsv(a);
				JOptionPane.showMessageDialog(null, "Operated Successfully.");
				
			}
		});
		btnExpoot.setFont(new Font("Arial", Font.PLAIN, 20));
		btnExpoot.setBounds(676, 196, 93, 26);
		contentPane.add(btnExpoot);
		
		
	}

}
