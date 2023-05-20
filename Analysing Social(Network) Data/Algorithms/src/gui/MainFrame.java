package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class MainFrame extends JFrame{
	
	JLabel greetings;
	JPanel northPanel;
	JPanel centerPanel;
	
	
	public MainFrame() {
		super.setTitle("Analysing Network Data");
		greetings = new JLabel("Analysing Data Network Using Graphs");
		northPanel = new JPanel();
		centerPanel = new JPanel();
		
	}
	
	
	public void makeFrame() {
		this.setLayout();
		this.addPanels();
		this.setLabels();
		this.setScreenSize();
		this.setIconImage();
		
		this.setFrameColor();
		this.setOperations();
	}

	
	private void addPanels() {
		this.add(northPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
	}
	
	private void setLabels() {
		JLabel guide = new JLabel("Please read instrcutions before going next: ");
		JLabel instruction1 = new JLabel("1. Program will analyse some real world data given in .txt file in form vertex edge ");
		JLabel instruction2 = new JLabel("2. Program will solve Single Source Reachability Problem");
		JLabel instruction3 = new JLabel("3. By default, program will tell you about graph overall struture");
		
		this.northPanel.add(greetings);
		this.centerPanel.add(guide);
		this.centerPanel.add(instruction1);
		this.centerPanel.add(instruction2);
		this.centerPanel.add(instruction3);	
	}
	
	private void setScreenSize() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		this.setSize(screenWidth/ 2, screenHeight / 2);
		this.setLocationByPlatform(true);
	}
	
	private void setIconImage() {
		Image image = new ImageIcon("icon.png").getImage();
		//Image welcome = new ImageIcon("welcome.jpg").getImage();
		this.setIconImage(image);
	}
	
	private void setLayout() {
		this.setLayout(new BorderLayout());
	}
	
	private void setFrameColor() {
		this.getContentPane().setBackground(Color.lightGray);
	}
	
	private void setOperations() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addContinueButton() {
		JButton button1 = new JButton("continue");
	}
	
	
}
