import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class AppGame extends Applet implements ActionListener
{
	Button [][]b;
	Button b1;
	String [][]a = {{"","",""},
	                {"","",""},
	                {"","",""}}; 
	String [] p = {"X","O"};
	Font f;
	TextField t1;
	static int x;
	public void init()
	{
		t1 = new TextField(20);
		b1 = new Button("Re-Start");
		b = new Button[3][3];
		f = new Font("TORCH",Font.BOLD,50);
		/*Create button*/
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				b[i][j] = new Button();

		/*Add the button*/
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				add(b[i][j]);
			add(t1);add(b1);
		setLayout(null);
		/*Add setBounds to button*/
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				b[i][j].setBounds(150+(j*60),100+(i*60),60,60);

		t1.setBounds(0,300,500,60);
		b1.setBounds(350,220,100,60);
			/*Add font to button*/
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				b[i][j].setFont(f);
		t1.setFont(f);
		b1.setFont(new Font("TORCH",Font.BOLD,20));

		/*Add ActionListener to button*/
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				b[i][j].addActionListener(this);
		b1.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
			restart();
		else
		{
		int flag = 1;
		showStatus(" ");
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
				if(ae.getSource() == b[i][j])
				{
					if(a[i][j].isEmpty())
					{
						a[i][j] = p[x%2];
						b[i][j].setLabel(a[i][j]);
						x++;
					}
					else
					showStatus("Already selected");	
					flag = 0;
					break;
				}
			if(flag==0)
				break;
		}
		String ans = fun();
		if(! ans.isEmpty())
		{
			if(ans.equals("Tie"))
				t1.setText(ans);
			else
				t1.setText("Winner is "+ans);
			try
			{
			Thread.sleep(3000);
			restart();
		   }catch(Exception e){}
		}
	  }
	}
	public String fun()
	{
		String ans= "";
		for(int i=0;i<3;i++)
			if((! a[i][0].isEmpty()) && a[i][0].equals(a[i][1]) && a[i][0].equals(a[i][2]))
			 return a[i][0];

		for(int j=0;j<3;j++)
			if((! a[0][j].isEmpty()) && a[0][j].equals(a[1][j]) && a[0][j].equals(a[2][j]))
				return a[0][j];

		if((! a[0][0].isEmpty()) && a[0][0].equals(a[1][1]) && a[0][0].equals(a[2][2]))
			    return a[0][0];

		if((! a[0][2].isEmpty()) && a[0][2].equals(a[1][1]) && a[0][2].equals(a[2][0]))
			    return a[0][2];

			int count = 0;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(! a[i][j].isEmpty())
					count++;
		if(count == 9)
			ans = "Tie";

		return ans;
	}
	public void restart()
	{
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				b[i][j].setLabel(" ");
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				a[i][j] = "";
		x = 0;
		t1.setText(" ");

	}
}
//<applet code = "AppGame.java" height = 500 width = 500></applet>