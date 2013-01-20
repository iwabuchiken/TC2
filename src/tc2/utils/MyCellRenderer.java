package tc2.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MyCellRenderer implements ListCellRenderer {

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
				label.setText("●	" + value.toString() + "●");

			label.setBackground(Color.red);
			label.setForeground(Color.white);
		}else{
			label.setText(value.toString());

			label.setBackground(Color.white);
			label.setForeground(Color.black);
		}

		label.setFont(new Font("Areal", Font.BOLD,20));
		
		return label;
	}
}//public class MyCellRenderer implements ListCellRenderer
