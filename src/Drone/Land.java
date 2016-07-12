package Drone;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Land extends JPanel implements ActionListener{

	public Land(){
		setBackground(Color.BLUE);
		JLabel namelabel = new JLabel("Input for Drone: ", JLabel.CENTER);
		final JTextField userText = new JTextField(10);
	}
	public void RunOnLand(String input){
		if(input.length()==0){
			System.out.println("no value enter");
		}
		else{
			String[] parts = input.split(" ");
			int element1 = Integer.parseInt(parts[0]);
		    int element2 = Integer.parseInt(parts[1]);
		    int element3 = Integer.parseInt(parts[2]);
		    int element4 = Integer.parseInt(parts[3]);

		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
