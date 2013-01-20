package tc2.main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tc2.utils.Methods;
import tc2.utils.MyCellRenderer;

public class TC2 extends JFrame{

	private DefaultListModel<String> model;

	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				TC2 ex = new TC2("TC2");

				ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				ex.setBounds( 100, 10, 300, 130);
//					test.setVisible(true);

				ex.setVisible(true);
				
			}//public void run()
		});//SwingUtilities.invokeLater
		
//		TC2 test = new TC2("TC2");
//	
//		/* 終了処理を変更 */
//		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	
//		test.setBounds( 100, 10, 300, 130);
//		test.setVisible(true);
	}

	TC2(String title){
		
		initGUI(title);
		
	}//TC2(String title)

	private void initGUI(String title) {
		/*********************************
		 * 01
		 *********************************/
		// Frame
//		initGUI_1_frame(this, title);
		
		/* JListの初期データ */
		model = new DefaultListModel();
		
		for(int i = 0; i < 20; i++) {
			
			model.addElement("Item number: " + i);
			
		}
		
		JList<String> list = new JList<String>(model);
		
		list.setFont(new Font("Areal", Font.BOLD,14));

		/* CellRendererを設定する */
		MyCellRenderer renderer = new MyCellRenderer();
		list.setCellRenderer(renderer);

		
		
		JScrollPane sp = new JScrollPane();
		sp.getViewport().setView(list);
		sp.setPreferredSize(new Dimension(200, 200));

		JPanel p = new JPanel();
		p.add(sp);

		getContentPane().add(p, BorderLayout.CENTER);
		
	}//private void initGUI(String title)

	private void initGUI_1_frame(JFrame frame, String title) {
		// TODO 自動生成されたメソッド・スタブ
		frame.setTitle(title);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.setBounds( 100, 10, 300, 130);
		
//		setVisible(true);
		
	}//private void initGUI_1_frame(String title)

//	class MyCellRenderer implements ListCellRenderer {
//		JLabel label;
//
//		public MyCellRenderer() {
//			label = new JLabel();
//			label.setOpaque(true);
//		}
//
//		public Component getListCellRendererComponent(
//			JList list,
//			Object value,
//			int index,
//			boolean isSelected,
//			boolean cellHasFocus){
//
//			if (isSelected){
//					label.setText("●	" + value.toString() + "●");
//
//				label.setBackground(Color.red);
//				label.setForeground(Color.white);
//			}else{
//				label.setText(value.toString());
//
//				label.setBackground(Color.white);
//				label.setForeground(Color.black);
//			}
//
//			label.setFont(new Font("Areal", Font.BOLD,20));
//			
//			return label;
//		}
//	}
}
