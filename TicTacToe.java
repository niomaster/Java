import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicTacToe implements ActionListener 
{
private	JFrame window=new JFrame("Tic Tac Toe");
private	JButton[] buttons=new JButton[9];
private	String label="";
private	int	counter=0;
private JMenuBar menuBar=new JMenuBar();
private JMenu menu=new JMenu("File");
private JMenu menu2=new JMenu("Info");
private String x="X",o="O";
private int Wins[][]={
{0,1,2},{0,3,6},{0,4,8},{1,4,7},{2,5,8}
,{3,4,5},{6,7,8}};

public TicTacToe(){

	menuBar.add(menu);
	menuBar.add(menu2);
	
	JMenuItem open=new JMenuItem("New Game");
	open.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			JOptionPane.showConfirmDialog(null,"Are you sure?");
			for(int i=0;i<9;i++){
				System.gc();
				buttons[i].setText("");
			}
		}
	});
	
	JMenuItem exit=new JMenuItem("Exit");
	exit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			JOptionPane.showConfirmDialog(null,"Are you sure?");
			System.exit(0);
			System.gc();
			}
		});
		
	JMenuItem info=new JMenuItem("Info");
	info.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			JOptionPane.showMessageDialog(null,"Welcome to my version of tic tac toe,"+
			"\n one of the funnest games of all time!");
			}});		
	menu.add(open);
	for(int i=0;i<2;i++){
		menu.addSeparator();}
	
	menu.add(exit);
	menu2.add(info);
	
	window.setJMenuBar(menuBar);
	window.resize(500,500);
	window.setLayout(new GridLayout(3,3));
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setBackground(Color.black);
	window.setLocationRelativeTo(null);
	
	
	for(int	i=0;i<9;i++){
		buttons[i]=new JButton(" ");
		window.add(buttons[i]);
		buttons[i].addActionListener(this);
		}
	window.setVisible(true);
}

private String get(int i)
{
	return buttons[i].getText();
}

public void checkWin()
{
	for(int i = 0; i < Wins.length; i++)
	{
		String text = get(Wins[i][0]);
		if(text.isEmpty())
			continue;
		boolean win = true;
		
		for(int j = 1; j < Wins[i].length; j++)
		{
			if(!text.equals(get(Wins[i][j])))
			{
				win = false;
				break;
			}
		}
		
		if(win)
		{
			//The player in text has won	
		}
	}
	
	//Noone has won.
}
public void	actionPerformed(ActionEvent	click)
{
	Object press=click.getSource();
	for(int	i=0;i<9;i++){
		if(buttons[i]==press){	
			while(buttons[i].getText().trim().isEmpty()){		
				buttons[i].setText(x);
				int newRand=new Random().nextInt(9);
				if(buttons[newRand].getText().trim().isEmpty()){
					buttons[newRand].setText(o);
					buttons[newRand].enable(false);
					checkWin();
				}
			    else{
				    int newRand1=new Random().nextInt(9);
					if(buttons[newRand1].getText().trim().isEmpty()){
						buttons[newRand1].setText(o);
						buttons[newRand1].enable(false);
						//checkWin();
					}
					else{
						int newRand2=new Random().nextInt(9);
						if(buttons[newRand2].getText().trim().isEmpty()){
							buttons[newRand2].setText(o);
							buttons[newRand2].enable(false);
							//checkWin();
						}
					}
				}
			}
		}
	}
}
public static void main(String[] args) 
{
	   TicTacToe New=new TicTacToe();
	}
}