package tc2.B5.v1_2.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//import org.dyno.visual.swing.layouts.Constraints;
//import org.dyno.visual.swing.layouts.GroupLayout;
//import org.dyno.visual.swing.layouts.Leading;

public class TC2_B5_v_1_2 extends JFrame {

	private JMenuItem miExit;
	private JMenu menuFile;
	private JMenuBar menuBar;
	private JPanel panelButtons;
	private JScrollPane spTimes;
	private JButton btnGetTime;
	private JButton btnCalculate;
	private JButton btnClear;
	private JButton btnExit;

	/*********************************
	 * Positions: Buttons
	 *********************************/
	int x1 = 20;
	int y1 = 50;
	int btnWidth = 140;
	int btnHeight = 25;
	
	private JMenuItem getMiFile() {
		if (miExit == null) {
			miExit = new JMenuItem();
			miExit.setText("Exit");
			
//			miExit.setName(CONS.BtnNames.BtnExit.name());
//			
//			miExit.addActionListener(new BtnActionListener());
		}
		return miExit;
	}

	private JMenu getMenuFile() {
		if (menuFile == null) {
			menuFile = new JMenu();
			menuFile.setText("File");
			menuFile.add(getMiFile());
		}
		return menuFile;
	}

	private JMenuBar getMainMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMenuFile());
		}
		return menuBar;
	}

	private JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			panelButtons.setBackground(new Color(53, 63, 233));
			panelButtons.setForeground(new Color(255, 253, 253));
			panelButtons.setPreferredSize(new Dimension(200, 100));
			panelButtons.setLayout(null);
			
			/*********************************
			 * Buttons
			 *********************************/
			panelButtons.add(getBtnGetTime());
			panelButtons.add(getBtnClear());
			panelButtons.add(getBtnExit());
			panelButtons.add(getBtnCalc());
		}
		return panelButtons;
	}

	private JScrollPane getSpTimes() {
		if (spTimes == null) {
			spTimes = new JScrollPane();
		}
		return spTimes;
	}

	private void initComponents() {
		add(getSpTimes(), BorderLayout.EAST);
		add(getPanelButtons(), BorderLayout.WEST);
		setJMenuBar(getMainMenuBar());
		setSize(612, 340);
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton();
			btnExit.setText("Exit");
			
			btnExit.setContentAreaFilled(true);
//			
//			btnGetTime.setDefaultCapable(false);
			
//			btnGetTime.setBounds(new Rectangle(new Point(55, 50), new Dimension(40, 25)));
			btnExit.setBounds(x1, 140 + 35 + 10, btnWidth, btnHeight);
			
			btnExit.setFont(new Font("ＭＳ 明朝", Font.BOLD | Font.ITALIC, 20));

			btnExit.setName(CONS.BtnNames.BtnExit.name());
			
			btnExit.addActionListener(new BtnActionListener());
		}
		return btnExit;
	}

	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton();
			btnClear.setText("Clear");
			
			btnClear.setContentAreaFilled(true);
//			
//			btnGetTime.setDefaultCapable(false);
			
//			btnGetTime.setBounds(new Rectangle(new Point(55, 50), new Dimension(40, 25)));
			btnClear.setBounds(x1, 95 + 35 + 10, btnWidth, btnHeight);
			
			btnClear.setFont(new Font("ＭＳ 明朝", Font.BOLD | Font.ITALIC, 20));

			btnClear.addActionListener(new BtnActionListener());
			
//			btnClear.setBounds(new Rectangle(new Point()))
			
		}
		return btnClear;
	}

	private JButton getBtnCalc() {
		if (btnCalculate == null) {
			btnCalculate = new JButton();
			btnCalculate.setFont(new Font("Dialog", Font.BOLD | java.awt.Font.ITALIC, 20));
			btnCalculate.setText("Calculate");
			
//			btnCalculate.setBounds(x1, 95, 150, 30);
			btnCalculate.setBounds(x1, 95, btnWidth, btnHeight);
			
			btnCalculate.addActionListener(new BtnActionListener());
		}
		return btnCalculate;
	}

	private JButton getBtnGetTime() {
		if (btnGetTime == null) {
			btnGetTime = new JButton();
			
			btnGetTime.setText("Get time");
			
//			btnGetTime.setOpaque(false);
//			
//			btnGetTime.setContentAreaFilled(false);
			btnGetTime.setContentAreaFilled(true);
//			
//			btnGetTime.setDefaultCapable(false);
			
//			btnGetTime.setBounds(new Rectangle(new Point(55, 50), new Dimension(40, 25)));
			btnGetTime.setBounds(x1, 50, btnWidth, btnHeight);
			
			btnGetTime.setFont(new Font("ＭＳ 明朝", Font.BOLD | Font.ITALIC, 20));
			
			btnGetTime.setName(CONS.BtnNames.BtnGetTime.name());
			
			btnGetTime.addActionListener(new BtnActionListener());
			
//			btnGetTime.setBackground(new Color(255, 253, 253));
//			btnGetTime.setForeground(new Color(0, 0, 0));

		}
		return btnGetTime;
	}

	private void addButtons() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public TC2_B5_v_1_2() {
		initComponents();
	}

	public static void main(String[] args) {
		
		TC2_B5_v_1_2 frame = new TC2_B5_v_1_2();
		
		frame.setSize(new Dimension(600, 500));
		
		frame.setVisible(true);
	}

}
