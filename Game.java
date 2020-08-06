import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Game extends Frame implements ActionListener
{
	Button b1,b2,b3,b4;
	TextField t1,t2,t3,t4,t5,t6;
	Label l1,l2,l3,l4;
	Panel p1;
	Font f1;
	java.util.List<String> li =Arrays.asList("Stone","Paper","Scissors");
	Game()
	{
		setVisible(true);
		setSize(500,500);
		t1 = new TextField(20);
		t2 = new TextField(20);
		t3 = new TextField(20);
		t4 = new TextField(20);
		t5 = new TextField(20);
		t6 = new TextField(20);
		p1 = new Panel();
		b1 = new Button("Stone");
		b2 = new Button("Paper");
		b3 = new Button("Scissors");
		b4 = new Button("Re-start");
		l1 = new Label("User");
		l2 = new Label("Computer");
		l3 = new Label("Score");
		l4 = new Label("vs");
		
		f1 = new Font("TORCH",Font.BOLD,20);
		p1.setLayout(null);
		p1.setBackground(new Color(0,128,128));
		p1.add(b1);p1.add(b2);p1.add(b3);
		l4.setFont(f1);
		t6.setFont(f1);
		t2.setFont(f1);
		t3.setFont(f1);
		t4.setFont(f1);
		t5.setFont(f1);
		p1.add(l1);p1.add(l2);p1.add(l3);p1.add(l4);p1.add(b4);
		p1.add(t2);p1.add(t3);p1.add(t4);p1.add(t5);p1.add(t6);
		t1.setText("                 Stone-Paper-Scissors Game");
		t1.setFont(f1);
		l1.setBounds(175,70,50,20);l2.setBounds(305,70,70,20);l4.setBounds(250,150,30,20);
		l3.setBounds(80,100,60,20);t2.setBounds(170,100,50,30);t3.setBounds(310,100,50,30);
        b1.setBounds(60,140,60,30);t4.setBounds(140,150,100,30);t5.setBounds(290,150,100,30);
        b2.setBounds(60,180,60,30);
        b3.setBounds(60,220,60,30);b4.setBounds(330,220,60,30);
        t6.setBounds(60,260,330,30);
        t2.setText("0");t3.setText("0");
		add(t1,BorderLayout.NORTH);
		add(p1,BorderLayout.CENTER);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b4)
		{
			t2.setText("0");t3.setText("0");
		}
		else	
		{
		String user ="";
		if(ae.getSource() == b1)
			user = li.get(0);
		else if(ae.getSource() == b2)
			user = li.get(1);
		else
			user = li.get(2);
		fun(user);
	   }
	}
	void fun(String user)
	{
		int [][]a = {{-1,0,1},
					 {1,-1,0},
					 {0,1,-1}	
					};
		String com = gen();
		int n = a[li.indexOf(user)][li.indexOf(com)];
		String ans = "TIE";
		if(n == 1)
		{
			ans = "User Wins";
			int score = Integer.parseInt(t2.getText());
			t2.setText(String.valueOf(score+1));
		}

		else if(n==0)
		{
			ans = "Computer Wins";
			int score = Integer.parseInt(t3.getText());
			t3.setText(String.valueOf(score+1));
		}
		t6.setText(ans);
		t4.setText(user);t5.setText(com);
		try{
			Thread.sleep(2000);
		}catch(Exception e){}
		t4.setText("");t5.setText("");
		t6.setText("");
	}
	String gen()
	{
		Random r = new Random();
		return li.get(r.nextInt(3));
	}

	public static void main(String[] args) {
		new Game();
	}

}