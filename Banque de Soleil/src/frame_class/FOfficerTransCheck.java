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
import code_class.Account;
import code_class.Transfer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FOfficerTransCheck extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollpane;
	private JButton btnBack;


	/**
	 * Create the frame.
	 */
	public FOfficerTransCheck(String a) {
		setVisible(true);
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);

		
		///////////////////////////////////////////////
		Account card = new Account();
		Transfer trans = new Transfer();
				
		ArrayList<Account> cards = new ArrayList<Account>();
		ArrayList<Transfer> transAll = new ArrayList<Transfer>();
		
		
		
		cards = card.getAcc(a);
		
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		for(int i = 0;i<cards.size();i++) {
			
			String b = cards.get(i).cardId;
			transAll = trans.getTrans(b);
			
			for(int k = 0; k<transAll.size(); k++) {
				
				String[] oneRow = new String[6];
				
				oneRow[0] = transAll.get(k).transId;
				oneRow[1] = transAll.get(k).transCardId;
				oneRow[2] = transAll.get(k).transDate.toString();
				oneRow[3] = transAll.get(k).transToCardId;
				oneRow[4] = String.valueOf(transAll.get(k).transAmount);
				oneRow[5] = String.valueOf(transAll.get(k).transCardBalance);
				
				data.add(oneRow);
				
			}	
		}
		
		String[][] tableValues = (String [][])data.toArray(new String[0][0]);
		String[] columnNames = {"Transfer ID", "Transfer From", "Time", "TransferTo", "Amount", "Balance"};

		////////////////////////////////////////////////////////////////////////////////

		table = new JTable(tableValues, columnNames);
		table.setEnabled(false);
		

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
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			FOfficerMain newWIn = new FOfficerMain();
			FOfficerTransCheck.this.dispose();
			}
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBack.setBounds(353, 439, 129, 35);
		contentPane.add(btnBack);
	}

}
