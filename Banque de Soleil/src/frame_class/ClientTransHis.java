package frame_class;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import code_class.Account;
import code_class.Transfer;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ClientTransHis extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollpane;
	//private JPanel bigPane;

	/**
	 * Create the frame.
	 */
	public ClientTransHis(String a) {

		
		setVisible(true);
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);


		
		table = new JTable();
		table.setEnabled(false);
		
		
		String[][] tableValues = new String[1][6];;
		String[] columnNames = {"Transfer ID", "Transfer From", "Time", "TransferTo", "Amount", "Balance"};
		DefaultTableModel model = new DefaultTableModel(tableValues,columnNames);
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(new Color(255, 255, 255));
		table.setBounds(49, 100, 700, 170);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setRowHeight(21);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(49, 125, 700, 229);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(scrollPane);

		Account acc1 = new Account();
		ArrayList<Account> acc = acc1.getAcc(a);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBox.setBounds(337, 427, 147, 30);
		for(int i = 0;i<acc.size();i++) {
			comboBox.addItem(acc.get(i).cardId);
		}
		contentPane.add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Transfer tranA = new Transfer();
				ArrayList<Transfer> transAll = tranA.getTrans((String)comboBox.getSelectedItem());
				
				String[] columnNames = {"Transfer ID", "Transfer From", "Time", "TransferTo", "Amount", "Balance"};
				String[][] tableValues = new String[transAll.size()][6];
				
				for(int i = 0;i<transAll.size();i++) {
					tableValues[i][0] = transAll.get(i).transId;
					tableValues[i][1] = transAll.get(i).transCardId;
					tableValues[i][2] = transAll.get(i).transDate.toString();
					tableValues[i][3] = transAll.get(i).transToCardId;
					tableValues[i][4] = String.valueOf(transAll.get(i).transAmount);
					tableValues[i][5] = String.valueOf(transAll.get(i).transCardBalance);
				}
				
				DefaultTableModel model = new DefaultTableModel(tableValues, columnNames);
				table.setModel(model);
				
			}
		});
		btnSearch.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSearch.setBounds(515, 426, 108, 33);
		contentPane.add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientAccountInfo newWin = new ClientAccountInfo(a);
				ClientTransHis.this.dispose();
			}
		});
		btnBack.setBounds(48, 510, 108, 30);
		contentPane.add(btnBack);
		
		JLabel lblChooseOneCard = new JLabel("Choose One Card:");
		lblChooseOneCard.setFont(new Font("Arial", Font.PLAIN, 20));
		lblChooseOneCard.setBounds(154, 430, 175, 25);
		contentPane.add(lblChooseOneCard);

		
		
		
		
		
	}
}
