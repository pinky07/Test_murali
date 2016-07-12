package Drone;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Windows extends Canvas{
public Windows(int width,int height,String title,Remote remote ,String sc){
	JFrame jframe = new JFrame(title);
	jframe.setPreferredSize(new Dimension(width,height));
	jframe.setMinimumSize(new Dimension(width,height));
	jframe.setMaximumSize(new Dimension(width,height));
	jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
	jframe.setResizable(false);
	jframe.add(remote);
	jframe.setVisible(true);
	remote.start();
}
}
