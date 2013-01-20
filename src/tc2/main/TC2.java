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

public class TC2 extends JFrame{

	  public static void main(String[] args){
	    TC2 test = new TC2("JListSample");

	    /* 終了処理を変更 */
	    test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    test.setBounds( 10, 10, 250, 130);
	    test.setVisible(true);
	  }

	  TC2(String title){
	    setTitle(title);

	    /* JListの初期データ */
	    String[] initData = {"Blue", "Green", "Red", "Whit", "Black"};
	    JList list = new JList(initData);

	    /* CellRendererを設定する */
	    MyCellRenderer renderer = new MyCellRenderer();
	    list.setCellRenderer(renderer);

	    
	    
	    JScrollPane sp = new JScrollPane();
	    sp.getViewport().setView(list);
	    sp.setPreferredSize(new Dimension(200, 80));

	    JPanel p = new JPanel();
	    p.add(sp);

	    getContentPane().add(p, BorderLayout.CENTER);
	  }

	  class MyCellRenderer implements ListCellRenderer {
	    JLabel label;

	    public MyCellRenderer() {
	      label = new JLabel();
	      label.setOpaque(true);
	    }

	    public Component getListCellRendererComponent(
	      JList list,
	      Object value,
	      int index,
	      boolean isSelected,
	      boolean cellHasFocus){

	      if (isSelected){
	        label.setText("●  " + value.toString() + "  ●");

	        label.setBackground(Color.red);
	        label.setForeground(Color.white);
	      }else{
	        label.setText(value.toString());

	        label.setBackground(Color.white);
	        label.setForeground(Color.black);
	      }

	      return label;
	    }
	  }
	}
