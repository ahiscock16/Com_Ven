import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.MouseAdapter;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Frame extends JFrame implements ActionListener
{
	JButton addevent_btn;
	Date date;
	JTextField eventName, comedianName, eventDate;
	public Frame()
	{
		addevent_btn = new JButton("Add");
		addevent_btn.addActionListener(this);
		this.add(addevent_btn, "Center");
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
			// All date variables need to be cast to string!!!
			// Use a datepicker?
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
	
	public static void main(String args[])
	{
		Frame frame = new Frame();
		frame.pack();
		frame.setVisible(true);
	}
}
