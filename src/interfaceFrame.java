import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Choice;

import javax.swing.JToggleButton;

import java.awt.Panel;

import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;


public class interfaceFrame extends JFrame implements ActionListener{

	/**
	 * Declarations.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField txtBookingName;
	private JTextField textField;
	JButton addevent_btn;
	Date date;
	JTextField eventName, comedianName, eventDate;
//

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 interfaceFrame frame = new  interfaceFrame();
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
	public interfaceFrame() {
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
		btnNewButton.setBounds(413, 301, 123, 37);
		contentPane.add(btnNewButton);
		
		addevent_btn = new JButton("Add Event");
		addevent_btn.setBounds(413, 340, 123, 37);
		addevent_btn.addActionListener(this);
		contentPane.add(addevent_btn);
		
		JButton btnNewButton_2 = new JButton("Delete Selection");
		btnNewButton_2.setBounds(413, 388, 123, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add Feedback");
		btnNewButton_3.setBounds(413, 436, 123, 37);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View Feedback");
		btnNewButton_4.setBounds(413, 481, 123, 37);
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
		btnNewButton_5.setBounds(617, 270, 89, 37);
		contentPane.add(btnNewButton_5);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 92, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JToggleButton toggleButton = new JToggleButton("");
		toggleButton.setBounds(112, 11, 43, 23);
		contentPane.add(toggleButton);
		
		JButton btnCalender = new JButton("Calender");
		btnCalender.setBounds(328, 8, 75, 23);
		contentPane.add(btnCalender);
	}
	
	public void actionPerformed(ActionEvent ev)
	{
		if (ev.getSource() == addevent_btn)
		{
			//System.out.println("Event added!");
			eventName = new JTextField();
			comedianName = new JTextField();
			eventDate = new JTextField();
			final JComponent[] inputs = new JComponent[] {
					new JLabel("Title"),
					eventName,
					new JLabel("Comedian"),
					comedianName,
					new JLabel("Date (DD-MM-YY)"),
					eventDate
			};

			JOptionPane.showMessageDialog(null, inputs, "Add Event", JOptionPane.OK_CANCEL_OPTION);
			// Test inputs
			System.out.println("You entered " +
					eventName.getText() + ", " +
					comedianName.getText() + ", " +
					eventDate.getText());}
			// Save inputs to database
			Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      String sql = "INSERT INTO EVENTS (NAME,COMEDIAN,DATE,SEATS) " +
		                 "VALUES ('"+ eventName.getText() + "', '" + comedianName.getText()
		                   + "', " + eventDate.getText() + " , 100 );"; 
		      stmt.executeUpdate(sql);


		      stmt.close();
		      c.commit();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Records created successfully");
		
	}
}
