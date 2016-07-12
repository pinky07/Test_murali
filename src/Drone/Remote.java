package Drone;

import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Remote extends Canvas implements Runnable {
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	static String section;
	private  JFrame mainFrame;
	private static JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public Remote() {

		// new Windows(WIDTH,HEIGHT,"lets play to drone",this,section );
		// JLabel namelabel= new JLabel("User ID: ", JLabel.RIGHT);
		handler = new Handler();
		handler.addObject(new Player(100, 100, ID.player));
		prepareGUI();

	}

	private void prepareGUI() {
		mainFrame = new JFrame("Java Swing Examples");
		mainFrame.setSize(400, 400);
		
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(350, 100);
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}

	public static void main(String[] args) {
		Remote swingControlDemo = new Remote();		
		Runnable r = () -> headerLabel.setText("Drone Input: JTextField");
		r.run(); // prints "Hello!"
		swingControlDemo.RunOnLand();
		swingControlDemo.showTextFieldDemo();
	}

	private void showTextFieldDemo() {
//		JLabel namelabel = new JLabel("Input for Drone: ", JLabel.CENTER);
//		final JTextField userText = new JTextField(10);

		JButton land = new JButton("Land");
		JButton air = new JButton("Air");

		land.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Land land1= new Land();
				land1.setVisible(true);
				
			    JDialog d = new JDialog(mainFrame, "Land", true);
			    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			    JLabel namelabel = new JLabel("Input for Drone: ", JLabel.CENTER);
				final JTextField userText = new JTextField(10);
			    panel.add(userText);
			    d.setLocationRelativeTo(mainFrame);
			    d.setVisible(true);
			    d.setSize(200, 100);
			    
				String data = userText.getText();
				if (data == null) {
					throw new NullPointerException("Please enter value to fly in land");
				} else {
					data = "you have entered " + userText.getText();

					statusLabel.setText(data);
				}
			}
		});
		
		air.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.add( new Air());
//				String data = userText.getText();
//				if (data == null) {
//					throw new NullPointerException("Please enter value to fly in Air");
//				} else {
//					data = "you have entered " + userText.getText();
//
//					statusLabel.setText(data);
//				}
			}
		});

		controlPanel.add(land);
		controlPanel.add(air);
		mainFrame.setVisible(true);
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		RunOnAir();
		RunOnLand();
		// lasty it will call stop();
		stop();

	}

	private void RunOnAir() {

	}

	private void RunOnLand() {
		JLabel namelabel = new JLabel("you can not move beacuse not take off yet: ", JLabel.CENTER);
	}
}
