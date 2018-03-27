package tysf.calculator;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NorthPanel extends JPanel{
	private String[] ops;
	private JTextField field;
	private JButton button;
	public NorthPanel(JTextField field, JButton button,String[] ops) {
		super();
		this.field = field;
		this.button = button;
		this.ops = ops;
		this.setLayout(new GridLayout(2, 1));
		this.add(field);
		this.add(button);
		field.setHorizontalAlignment(JTextField.RIGHT);
		field.setFont(new Font("楷体",Font.BOLD+Font.ITALIC,48));
		button.addActionListener(new MyListener());
	}
	class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			field.setText(null);
			ops[0]=null;
			ops[1]=null;
			ops[2]=null;
		}
		
	}
}
