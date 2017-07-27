package sqlite_k;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

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
		frame.setBounds(100, 100, 646, 507);
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
		
		JButton btnNewButton = new JButton("Enter the system");
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
		table_1.setBounds(248, 40, 380, 429);
		frame.getContentPane().add(table_1);
		table_1.setVisible(false);

		
		
		
		SqliteDB db = new SqliteDB();
		boolean status=db.statusDB();
		if (status) {
			label.setText("OK!");
		}
	}
}

