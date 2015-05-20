import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JToggleButton;
import java.awt.Panel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;


public class mainFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField txtBookingName;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 mainFrame frame = new  mainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//test
	/**
	 * Create the frame.
	 */
	public mainFrame() {
		setName("Main program");
		setResizable(false);
		setTitle("Comedy Venue Management System");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(78, 188, 172, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_6 = new JButton("No");
		btnNewButton_6.setBounds(20, 60, 59, 23);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Yes");
		btnNewButton_7.setBounds(89, 60, 66, 23);
		panel.add(btnNewButton_7);
		
		JTextArea txtrAreYouSure = new JTextArea();
		txtrAreYouSure.setBackground(SystemColor.menu);
		txtrAreYouSure.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrAreYouSure.setEditable(false);
		txtrAreYouSure.setText(" Are you sure you want to \r\n  delete the entire event?");
		txtrAreYouSure.setBounds(10, 11, 145, 38);
		panel.add(txtrAreYouSure);
		
		table = new JTable();
		table.setBounds(10, 42, 393, 476);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Edit Selection");
		btnNewButton.setBounds(413, 306, 123, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Event");
		btnNewButton_1.setBounds(413, 340, 123, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Selection");
		btnNewButton_2.setBounds(413, 397, 123, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add Feedback");
		btnNewButton_3.setBounds(413, 461, 123, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View Feedback");
		btnNewButton_4.setBounds(413, 495, 123, 23);
		contentPane.add(btnNewButton_4);
		
		table_1 = new JTable();
		table_1.setBounds(413, 42, 293, 217);
		contentPane.add(table_1);
		
		txtBookingName = new JTextField();
		txtBookingName.setText("Booking Name");
		txtBookingName.setBounds(413, 270, 120, 20);
		contentPane.add(txtBookingName);
		txtBookingName.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(549, 270, 43, 20);
		contentPane.add(choice);
		
		JButton btnNewButton_5 = new JButton("Book");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(617, 270, 89, 23);
		contentPane.add(btnNewButton_5);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JToggleButton toggleButton = new JToggleButton("");
		toggleButton.setBounds(112, 11, 60, 23);
		contentPane.add(toggleButton);
		
		JButton btnCalender = new JButton("Calender");
		btnCalender.setBounds(328, 8, 75, 23);
		contentPane.add(btnCalender);
	}
}
