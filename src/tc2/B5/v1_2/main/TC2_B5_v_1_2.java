package tc2.B5.v1_2.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

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
	int x1 = 40;
	int y1 = 50;
	int btnWidth = 100;
	int btnHeight = 25;
	
	private JMenuItem getMiFile() {
		if (miExit == null) {
			miExit = new JMenuItem();
			miExit.setText("Exit");
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
			panelButtons.setLayout(new GroupLayout());
			panelButtons.add(getBtnGetTime(), new Constraints(new Leading(55, 10, 10), new Leading(53, 10, 10)));
			panelButtons.add(getBtnClear(), new Constraints(new Leading(57, 10, 10), new Leading(184, 10, 10)));
			panelButtons.add(getBtnExit(), new Constraints(new Leading(61, 10, 10), new Leading(251, 10, 10)));
			panelButtons.add(getBtnCalc(), new Constraints(new Leading(55, 102, 12, 12), new Leading(121, 10, 10)));
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

			
//			btnClear.setBounds(new Rectangle(new Point()))
			
		}
		return btnClear;
	}

	private JButton getBtnCalc() {
		if (btnCalculate == null) {
			btnCalculate = new JButton();
			btnCalculate.setText("Calculate");
			
			btnCalculate.setContentAreaFilled(true);
//			
//			btnGetTime.setDefaultCapable(false);
			
//			btnGetTime.setBounds(new Rectangle(new Point(55, 50), new Dimension(40, 25)));
//			btnCalculate.setBounds(x1, 95, btnWidth, btnHeight);
			btnCalculate.setFont(new Font("ＭＳ 明朝", Font.BOLD | Font.ITALIC, 20));

			btnCalculate.setBounds(x1, 95, 100, btnHeight);
			btnCalculate.setSize(100, 30);
			
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
