package frame_class;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Index extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public Index() {
		setVisible(true);
		setTitle("Banque du Soleil");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 800, 600);
				
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Login");
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Client");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientLogin userA = new ClientLogin();
				Index.this.dispose();
			}
		});
		mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmFrontAdviser = new JMenuItem("Front Adviser");
		mntmFrontAdviser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				FOfficerLogin newWindow = new FOfficerLogin();
				Index.this.dispose();
			
			}
		});
		mntmFrontAdviser.setFont(new Font("Arial", Font.PLAIN, 18));
		mnNewMenu.add(mntmFrontAdviser);
		
		JMenuItem mntmManager = new JMenuItem("Manager");
		mntmManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ManagerLogin newWin = new ManagerLogin();
				Index.this.dispose();
			
			}
		});
		mntmManager.setFont(new Font("Arial", Font.PLAIN, 18));
		mnNewMenu.add(mntmManager);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		mnNewMenu_1.setFont(new Font("Arial", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCheckForUpdate = new JMenuItem("Check for update");
		mntmCheckForUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(null, "Your software version is up to date.");
			}
		});
		mntmCheckForUpdate.setFont(new Font("Arial", Font.PLAIN, 18));
		mnNewMenu_1.add(mntmCheckForUpdate);
		
		JMenuItem mntmInformation = new JMenuItem("Information");
		mntmInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Made by Zhendong_Qiang.");
				
			}
		});
		mntmInformation.setFont(new Font("Arial", Font.PLAIN, 18));
		mnNewMenu_1.add(mntmInformation);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("../Banque de Soleil/Banque du Soleil.jpg"));
		lblNewLabel.setBounds(0, 0, 784, 540);
		contentPane.add(lblNewLabel);
	}
}
