import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class CustomerDatabase implements ActionListener
{
    private static CustomerRecord records[] = new CustomerRecord [1000];
    private static int numRecords = 0;
    private JButton add, delete, sort, display, close;
    private int returnNum;

    public CustomerDatabase ()
    {
	add = new JButton ("add");
	delete = new JButton ("delete");
	sort = new JButton ("sort");
	display = new JButton ("display");
	close = new JButton ("exit");
	add.addActionListener (this);
	delete.addActionListener (this);
	sort.addActionListener (this);
	display.addActionListener (this);
	close.addActionListener (this);
	JLabel label = new JLabel ();
	JLabel image= new JLabel();
	JLabel color= new JLabel();
	JLabel colorTwo= new JLabel();
	Font f = new Font ("Courier", Font.BOLD, 22);
	label.setFont (f);
	//can also add image to label instead of text needs to be in same folder
	label.setText ("Scenic Travel Agency");
	label.setOpaque(true);
	label.setBackground(Color.red);
	colorTwo.setOpaque(true);
	colorTwo.setBackground (Color.yellow);
	color.setOpaque (true);
	color.setBackground (Color.blue);
	image.setIcon (new ImageIcon ("imageCPT.jpg"));
	JPanel panel = new JPanel ();
	panel.add (add);
	panel.add (delete);
	panel.add (sort);
	panel.add (display);
	panel.add (label);
	panel.add (close);
	panel.add (image);
	panel.add(color);
	panel.add(colorTwo);
	JFrame frame = new JFrame ();
	frame.setContentPane (panel);
	frame.setTitle ("User Interface");
	frame.setSize (800, 800);
	// frame.setBounds (200,100,400,200); overrides set size
	frame.setVisible (true);
	label.setBounds (200, 100, 270, 50);
	image.setBounds (0,300,800,500);
	color.setBounds (0,0,800,150);
	colorTwo.setBounds (0,150,800,300);
	add.setBounds (50, 200, 150, 90);
	delete.setBounds (210, 200, 150, 90);
	sort.setBounds (370, 200, 150, 90);
	display.setBounds (530, 200, 150, 90);
	close.setBounds (700, 10, 70, 50);
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }


    public void actionPerformed (ActionEvent e)
    {
	if (e.getSource () == add)
	{
	    String customerInfo, lName;
	    lName = JOptionPane.showInputDialog ("enter last name");
	    customerInfo = lName + "/";
	    customerInfo += JOptionPane.showInputDialog ("enter first name") + "/";
	    customerInfo += JOptionPane.showInputDialog ("enter address") + "/";
	    customerInfo += JOptionPane.showInputDialog ("enter age") + "/";
	    customerInfo += JOptionPane.showInputDialog ("enter phone number") + "/";
	    customerInfo += JOptionPane.showInputDialog ("enter income") + "/";
	    add (customerInfo, lName);
	}
	else if (e.getSource () == delete)
	{
	    String nameLast = JOptionPane.showInputDialog ("enter last name");
	    delete (nameLast);
	}


	else if (e.getSource () == sort)
	{
	    String[] type = {"income", "age"};
	    int select = JOptionPane.showOptionDialog (null, "Sort order based on what?", "Click a button", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, type, type [0]);
	    sort (select);
	}


	else if (e.getSource () == display)
	{
	    display ();
	}


	else if (e.getSource () == close)
	{
	    store ();
	    System.exit (0);
	}
    }


    public static void retrieve ()
    {
	BufferedReader br;
	try
	{
	    br = new BufferedReader (new FileReader ("CPTNAMES1.txt"));
	    String info = br.readLine ();
	    while (info != null)
	    {
		records [numRecords] = new CustomerRecord (info);
		numRecords++;
		info = br.readLine ();

	    }
	    br.close ();
	}


	catch (IOException ioe)
	{
	}
	//when start the program
    }


    public static void sort (int num)
    {
	CustomerRecord copy[] = new CustomerRecord [1000];
	JTextArea myArea = new JTextArea ();
	String sorted = "";
	System.arraycopy (records, 0, copy, 0, records.length); // (original, where to start, copied, where to start, length)
	if (num == 0)
	{
	    CustomerRecord tempV;
	    int index;
	    for (int d = 1 ; d < records.length ; d++)
	    {
		if (records [d] != null)
		{
		    tempV = records [d];
		    index = d - 1;
		    while (index >= 0 && Integer.parseInt (records [index].getIncome ()) > Integer.parseInt (tempV.getIncome ()))
		    {
			records [index + 1] = records [index];
			index--;
		    }
		    records [index + 1] = tempV;
		}
		else
		{
		    break;
		}
	    }
	}


	else if (num == 1)
	{
	    CustomerRecord temp;
	    int ind;
	    for (int k = 1 ; k < records.length ; k++)
	    {
		if (records [k] != null)
		{
		    temp = records [k];
		    ind = k - 1;
		    while (ind >= 0 && Integer.parseInt (records [ind].getAge ()) > Integer.parseInt (temp.getAge ()))
		    {
			records [ind + 1] = records [ind];
			ind--;
		    }
		    records [ind + 1] = temp;
		}
		else
		{
		    break;
		}
	    }
	}


	for (int a = 0 ; a < numRecords ; a++)
	{
	    sorted += (records [a].getFirstName () + " " + records [a].getLastName () + " " + records [a].getAddress () + " " + " " + records [a].getAge () + " " + records [a].getTelephone () + " " + records [a].getIncome () + "\n");
	} //just print use getters using object and then after use println
	myArea.setText (sorted);
	JOptionPane.showMessageDialog (null, myArea);
	    System.arraycopy (copy, 0, records, 0, copy.length); // (original, where to start, copied, where to start, length)
    }


    public static void display ()
    {
	JTextArea area = new JTextArea ();
	String list = "";
	for (int a = 0 ; a < numRecords ; a++)
	{
	    list += (records [a].getFirstName () + " " + records [a].getLastName () + " " + records [a].getAddress () + " " + " " + records [a].getAge () + " " + records [a].getTelephone () + " " + records [a].getIncome () + "\n");
	} //just print use getters using object and then after use println
	area.setText (list);
	JOptionPane.showMessageDialog (null, area);
    }


    public static void add (String info, String name)
    {
	int temp, index, compare;
	System.out.println (numRecords + "A1");
	for (int c = numRecords - 1 ; c >= 0 ; c--)
	{
	    compare = name.compareToIgnoreCase (records [c].getLastName ());
	    if (compare < 0)
	    {
		//name is higher
		records [c + 1] = records [c];
	    }
	    else
	    {
		records [c + 1] = new CustomerRecord (info);
		break;
	    }
	}
	numRecords = numRecords + 1;
	store();
    }


    public static void delete (String last)
    {
	for (int d = 0 ; d < numRecords ; d++)
	{
	    if (last.equalsIgnoreCase (records [d].getLastName ()))
	    {
		if (records [d] != null)
		{
		    records [d] = records [d + 1];
		}
		numRecords = numRecords - 1;
		break;
	    }

	    else if (d == (numRecords - 1))
	    {
		JOptionPane.showMessageDialog (null, "Name not found");
	    }
	}


    }


    public static void store ()
    {
	PrintWriter pw;
	try
	{
	    pw = new PrintWriter (new FileWriter ("CPTNAMES1.txt"));
	    for (int b = 0 ; b < numRecords ; b++)
	    {
		pw.println (records [b].getLastName () + "/" + records [b].getFirstName () + "/" + records [b].getAddress () + "/" + records [b].getAge () + "/" + records [b].getTelephone () + "/" + records [b].getIncome ());
	    }
	    pw.close ();
	}


	catch (IOException ioe)
	{
	}
    }
}
