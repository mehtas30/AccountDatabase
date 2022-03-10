import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Executable implements ActionListener
{
    private JButton add, delete, sort, display,close;
    private int returnNum;
    public Executable ()
    {
	add = new JButton ("add");
	delete = new JButton ("delete");
	sort = new JButton ("sort");
	display = new JButton ("display");
	close= new JButton ("exit");
	add.addActionListener (this);
	JLabel label = new JLabel ();
	//Font f = new Font ("Ariel", Font.BOLD, 24);
	// label.setFont (f);
	//can also add image to label instead of text needs to be in same folder
	label.setText ("Scenic Travel Agency");
	//label.setOpaque (true);
	//label.setBackground (Color.blue);
	JPanel panel = new JPanel ();
	panel.add (add);
	panel.add (delete);
	panel.add (sort);
	panel.add (display);
	panel.add (label);
	JFrame frame = new JFrame ();
	frame.setContentPane (panel);
	frame.setTitle ("User Interface");
	frame.setSize (800, 800);
	// frame.setBounds (200,100,400,200); overrides set size
	frame.setVisible (true);
	label.setBounds (300, 100, 300, 100);
	add.setBounds (50, 200, 150, 100);
	delete.setBounds (210, 200, 150, 100);
	sort.setBounds (370, 200, 150, 100);
	display.setBounds (530, 200, 150, 100);
	close.setBounds (690,200,150,100);
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }


    public int choice ()
    {
	return returnNum;
    }


    public void actionPerformed (ActionEvent e)
    {
	if (e.getSource () == add)
	{
	    returnNum = 1;
	}
	else if (e.getSource () == delete)
	{
	    returnNum = 2;
	}
	else if (e.getSource () == sort)
	{
	    returnNum = 3;
	}
	else if (e.getSource () == display)
	{
	    returnNum = 4;
	}
	else
	{
	returnNum=0;
	}
    }



}

