package tc2.B5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

//import org.dyno.visual.swing.layouts.Constraints;
//import org.dyno.visual.swing.layouts.GroupLayout;
//import org.dyno.visual.swing.layouts.Leading;

public class TC2_B5_v_1_2 extends JFrame {

	/*********************************
	 * Menu
	 *********************************/
	private JMenuItem miExit;
	private JMenu menuFile;
	private JMenuBar menuBar;
	
	/*********************************
	 * Panels
	 *********************************/
	private JPanel panelButtons;
	private JScrollPane spTimes;
	
	/*********************************
	 * Button
	 *********************************/
	private JButton btnGetTime;
	private JButton btnCalculate;
	private JButton btnClear;
	private JButton btnExit;
	
	/*********************************
	 * List
	 *********************************/
	private JList<String> list;
    private DefaultListModel<String> model;

	/*********************************
	 * Positions: Buttons
	 *********************************/
	int x1 = 20;
	int y1 = 50;
	int btnWidth = 140;
	int btnHeight = 25;


	public static void main(String[] args) {
		
		TC2_B5_v_1_2 frame = new TC2_B5_v_1_2();
		
		JPanel mainPanel = new JPanel();
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		mainPanel.setBackground(Color.green);
		
		frame.initUI_1_menu(frame);
		
		frame.getContentPane().add(mainPanel);
		
		frame.setSize(new Dimension(600, 500));
		
		frame.setVisible(true);
	}//public static void main(String[] args)


	private void initUI_1_menu(JFrame frame) {
		
		menuBar = new JMenuBar();
		
//		menuBar.setBackground(Color.blue);
		
		/*********************************
		 * Menu: File
		 *********************************/
		menuFile = new JMenu();
		menuFile.setText("File");
		
		menuBar.add(menuFile);
		
		miExit = new JMenuItem();
		miExit.setText("Exit");
		
		menuFile.add(miExit);
		
		/*********************************
		 * Set menu bar to frame
		 *********************************/
		frame.setJMenuBar(menuBar);
		
	}

}
