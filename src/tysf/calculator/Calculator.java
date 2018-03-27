package tysf.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jsj.tysf.*;

public class Calculator extends JFrame{
	public String[] ops=new String[3];
	public JTextField field;
	private String[] sbt={
		"7","8","9","+",	
		"6","5","4","-",
		"3","2","1","*",
		"0",".","=","/"
	};
	private BorderLayout borderLayout;
	private JButton[] button=new JButton[sbt.length];
	public Calculator() {
		super("我的计算器");
		MyPanel myPanel=new MyPanel();
		field =new JTextField();
		JButton ce=new JButton("CE");
		this.setSize(300, 500);
		this.setLocationRelativeTo(null);
		borderLayout=new BorderLayout();
		this.setLayout(borderLayout);
		this.add(new NorthPanel(field, ce, ops),BorderLayout.NORTH);
		this.add(myPanel,BorderLayout.CENTER);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Calculator calculator=new Calculator();
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class MyPanel extends JPanel{
		public MyPanel(){
			this.setVisible(true);
			this.setLayout(new GridLayout(4, 4));
			for(int i=0;i<sbt.length;i++){
				button[i]=new JButton(sbt[i]);
				this.add(button[i]);
				button[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(e.getActionCommand().equals("+")||e.getActionCommand().equals("-")||e.getActionCommand().equals("*")||e.getActionCommand().equals("/")){
							ops[1]=e.getActionCommand();
							field.setText(null);
						}else if(e.getActionCommand().equals(".")){
							if(field.getText()!=null){
							String tx=field.getText();
							field.setText(tx+e.getActionCommand());
							}
						}else if(e.getActionCommand().equals("=")){
							double a=Double.parseDouble(ops[0]);
							double b=Double.parseDouble(ops[2]);
							Factory f=new Factory();
							Operator o = f.createOprate(ops);
							double result=o.operator(a,b);
//							String[] ab=String.valueOf(result).split(".");
							field.setText(String.valueOf(result));
							/*if(!"0".equals(ab[1])){
							field.setText(ab[0]+"."+ab[1]);
							}else{
								field.setText(String.valueOf(result));
							}*/
						}else{
							if(field.getText()!=null){
						for(int i=0;i<10;i++){
							if(String.valueOf(i).equals(e.getActionCommand())){
								String tx=field.getText();
								String num=tx+e.getActionCommand();
								field.setText(tx+e.getActionCommand());//获取按钮的text
								if(ops[0]==null){
									ops[0]=num;
								}else if(ops[0]!=null&&field.getText().contains(".")&&ops[2]==null){
									String num1=tx+e.getActionCommand();
									ops[0]=num1;
//									System.out.println("ops[0]:"+ops[0]);
								}else if(ops[2]==null){
									ops[2]=num;
								}else if(ops[2]!=null&&field.getText().contains(".")){
									String num2=tx+e.getActionCommand();
									ops[2]=num2;
//									System.out.println("ops[2]:"+ops[2]);
								}
							}
						}
						
					}
				}
					}
			  });
			}
		}
	}
}
