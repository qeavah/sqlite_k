package sqlite_k;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JLayeredPane;
import javax.swing.JFormattedTextField;
import java.awt.Rectangle;
import java.awt.Dimension;


public class main_frame {


	private JFrame frame;
	private JTextField fieldLogin;
	private JPasswordField fieldPassword;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_frame window = new main_frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main_frame() {
		initialize();


		
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setSize(new Dimension(2000, 1000));
		frame.setBounds(new Rectangle(0, 0, 2000, 1300));
		frame.setBounds(100, 100, 803, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDbStatus = new JLabel("DB Status:");
		lblDbStatus.setBounds(19, 6, 70, 16);
		frame.getContentPane().add(lblDbStatus);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.PINK);
		label.setBounds(85, 6, 70, 16);
		frame.getContentPane().add(label);
		
		fieldLogin = new JTextField();
		fieldLogin.setBounds(85, 34, 130, 26);
		frame.getContentPane().add(fieldLogin);
		fieldLogin.setColumns(10);
		
		fieldPassword = new JPasswordField();
		fieldPassword.setBounds(86, 72, 130, 26);
		frame.getContentPane().add(fieldPassword);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(29, 39, 61, 16);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(19, 77, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Enter the System");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fieldLogin.getText().equals("admin")) {
					table_1.setVisible(true);
					
				} else {
					table_1.setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(19, 109, 196, 29);
		frame.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBackground(Color.ORANGE);
		table.setBounds(248, 459, 370, -424);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();

		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBounds(248, 40, 370, 95);
		frame.getContentPane().add(table_1);
		
		JButton btnReadDatabase = new JButton("Read Database");
		btnReadDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_1.isVisible()) {
				SqliteDB db = new SqliteDB();
				db.getObjectData();
				}
				
			}
			});
		
		btnReadDatabase.setBounds(19, 150, 196, 29);
		frame.getContentPane().add(btnReadDatabase);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(248, 15, 370, 20);
		frame.getContentPane().add(progressBar);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmFirst = new JMenuItem("First");
		mnFile.add(mntmFirst);
		
		JMenuItem mntmSecond = new JMenuItem("Second");
		mnFile.add(mntmSecond);
		
		JRadioButtonMenuItem rdbtnmntmRadio = new JRadioButtonMenuItem("Radio");
		menuBar.add(rdbtnmntmRadio);
		
		JMenuItem mntmItem_1 = new JMenuItem("Item2");
		mntmItem_1.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmItem_1);
		
		JMenuItem mntmItem = new JMenuItem("Item1");
		menuBar.add(mntmItem);
		
		JCheckBoxMenuItem chckbxmntmCheck = new JCheckBoxMenuItem("Check");
		menuBar.add(chckbxmntmCheck);
		table_1.setVisible(false);

		
		
		
		SqliteDB db = new SqliteDB();
		boolean status=db.statusDB();
		if (status) {
			label.setText("OK!");
		}
	}
}

