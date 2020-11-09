package frame_class;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import code_class.Account;
import code_class.Deposit;
import code_class.Transfer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;



public class ManagerInfoCheck extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table1;
	private JScrollPane scrollpane;
	private JScrollPane scrollpane1;
	private JButton btnBack;


	/**
	 * Create the frame.
	 */
	public ManagerInfoCheck(String a) {
		setVisible(true);
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);

		
		///////////////////////////////////////////////
		Account card = new Account();
		Transfer trans = new Transfer();
		Deposit record = new Deposit();
				
		ArrayList<Account> cards = new ArrayList<Account>();
		ArrayList<Transfer> transAll = new ArrayList<Transfer>();
		ArrayList<Deposit> records = new ArrayList<Deposit>();
		
		records = record.getDepos(a);
		
		cards = card.getAcc(a);
		
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		//////////////////////////////////////
		String[] columnNames1 = {"Deposit Id", "Deposit Date", "Deposit To", "Amount", "Card Balance"};
		String[][] tableValues1 = new String[records.size()][5];;
		
		for(int i = 0;i<records.size();i++) {
			tableValues1[i][0] = records.get(i).deposId;
			tableValues1[i][1] = records.get(i).deposDate.toString();
			tableValues1[i][2] = records.get(i).deposToCardId;
			tableValues1[i][3] = String.valueOf(records.get(i).deposAmount);
			tableValues1[i][4] = String.valueOf(records.get(i).deposBalance);
		}
		
		table1 = new JTable(tableValues1, columnNames1);
		table1.setEnabled(false);
				
		table1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table1.setBackground(new Color(255, 255, 255));
		table1.setBounds(49, 100, 700, 170);
		table1.setFont(new Font("Arial", Font.PLAIN, 12));
		table1.setRowHeight(21);
		
		JScrollPane scrollPane1 = new JScrollPane(table1);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setBounds(47, 219, 700, 205);
		/////////////////////////////////////
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
		scrollPane.setBounds(47, 13, 700, 193);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		contentPane.add(scrollPane1);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ManagerMain newWIn = new ManagerMain();
			ManagerInfoCheck.this.dispose();
			}
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBack.setBounds(330, 470, 129, 35);
		contentPane.add(btnBack);
		
		JButton btnExport = new JButton("Export");
		btnExport.setFont(new Font("Arial", Font.PLAIN, 20));
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				
				try {
					printWord(tableValues, tableValues1, a);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Operated Successfully.");

				
			}
		});
		
		
		
		btnExport.setBounds(634, 438, 113, 27);
		contentPane.add(btnExport);
	}
	
	
	
	
	public void printWord(String[][] transfer, String[][] deposit, String clientID) throws Exception{
		//Blank Document
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HHmmss");
		
		
		String a = "C:\\Users\\83620\\Desktop\\Bank Output\\" + df.format(new Date()) + ".doc";
		
		
	      XWPFDocument document = new XWPFDocument();
	        
	      //Write the Document in file system
	      FileOutputStream out = new FileOutputStream(new File(a));
	      
	      
	      XWPFParagraph paragraph = document.createParagraph();
	      XWPFRun run = paragraph.createRun();
	      run.setText("Client" + " " + clientID);
	      
	      
	        
	      //create table
	      XWPFTable table = document.createTable();
	      
	      
			
	      //create first row
	      XWPFTableRow tableRowOne = table.getRow(0);
	      tableRowOne.getCell(0).setText("Transfer ID");
	      tableRowOne.addNewTableCell().setText("Transfer From");
	      tableRowOne.addNewTableCell().setText("Time");
	      tableRowOne.addNewTableCell().setText("TransferTo");
	      tableRowOne.addNewTableCell().setText("Amount"); 
	      tableRowOne.addNewTableCell().setText("Balance");
	      
	      for(int i=0;i<transfer.length;i++) {
	    	  XWPFTableRow tableRow = table.createRow();
		      tableRow.getCell(0).setText(transfer[i][0]);
		      tableRow.getCell(1).setText(transfer[i][1]);
		      tableRow.getCell(2).setText(transfer[i][2]);
		      tableRow.getCell(3).setText(transfer[i][3]);
		      tableRow.getCell(4).setText(transfer[i][4]); 
		      tableRow.getCell(5).setText(transfer[i][5]);
	      }
	      
	      XWPFParagraph paragraph2 = document.createParagraph();
	      XWPFRun run2 = paragraph2.createRun();
	      run2.setText("  ");
	      
	      XWPFTable table1 = document.createTable();
	      XWPFTableRow tableRowOne1 = table1.getRow(0);
	      tableRowOne1.getCell(0).setText("Deposit Id");
	      tableRowOne1.addNewTableCell().setText("Deposit Date");
	      tableRowOne1.addNewTableCell().setText("Deposit To");
	      tableRowOne1.addNewTableCell().setText("Amount");
	      tableRowOne1.addNewTableCell().setText("Card Balance"); 
	      
	      for(int i=0;i<deposit.length;i++) {
	    	  XWPFTableRow tableRow2 = table1.createRow();
		      tableRow2.getCell(0).setText(deposit[i][0]);
		      tableRow2.getCell(1).setText(deposit[i][1]);
		      tableRow2.getCell(2).setText(deposit[i][2]);
		      tableRow2.getCell(3).setText(deposit[i][3]);
		      tableRow2.getCell(4).setText(deposit[i][4]); 
	      }
	      
		
	      document.write(out);
	      out.close();
	}
	
}
