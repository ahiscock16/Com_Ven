import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class Frame extends JFrame
{
	public Frame()
	{
		JButton addevent_btn = new JButton("Add");
		this.add(addevent_btn, "Center");
	}
	
	public static void main(String args[])
	{
		Frame frame = new Frame();
		frame.pack();
		frame.setVisible(true);
	}
}
