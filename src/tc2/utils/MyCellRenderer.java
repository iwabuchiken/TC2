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
			
			
			System.out.println(
						"[" + Thread.currentThread().getStackTrace()[2].getLineNumber() + "] "
						+ "isSelected");
			
//			if (CONS.selectedItems.contains(Integer.valueOf(index))) {
//				
//				CONS.selectedItems.remove(index);
//				
//				label.setText(value.toString());
//
//				label.setBackground(Color.white);
//				label.setForeground(Color.black);
//
//				
//			} else {//if (CONS.selectedItems.contains(Integer.valueOf(index)))
//				
//				CONS.selectedItems.add(index);
//				
//				label.setText(value.toString());
//				
//				label.setBackground(Color.blue);
//				label.setForeground(Color.white);
//				
//			}//if (CONS.selectedItems.contains(Integer.valueOf(index)))
			
			
			
//			CONS.selectedItems.add(index);
//			
			System.out.println(
					"[" + Thread.currentThread().getStackTrace()[2].getLineNumber() + "] "
					+ "index=" + index);

			System.out.println(
//					"[" + Thread.currentThread().getStackTrace()[2].getLineNumber() + "] "
					"[" + String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber()) + "] "
					+ "value=" + (String)value);

			
			label.setText(value.toString());
			
			label.setBackground(Color.blue);
			label.setForeground(Color.white);
			
//				label.setText("●	" + value.toString() + "●");
//
//			label.setBackground(Color.red);
//			label.setForeground(Color.white);
		}else{
			
//			if (CONS.selectedItems.contains(Integer.valueOf(index))) {
//				
////				CONS.selectedItems.remove(index);
//				
//				label.setText(value.toString());
//
//				label.setBackground(Color.white);
//				label.setForeground(Color.black);
//
//				
//			} else {//if (CONS.selectedItems.contains(Integer.valueOf(index)))
//				
////				CONS.selectedItems.add(index);
//				
//				label.setText(value.toString());
//				
//				label.setBackground(Color.blue);
//				label.setForeground(Color.white);
//				
//			}//if (CONS.selectedItems.contains(Integer.valueOf(index)))

			System.out.println(
					"[" + Thread.currentThread().getStackTrace()[2].getLineNumber() + "] "
					+ "is not selected");

			System.out.println(
					"[" + Thread.currentThread().getStackTrace()[2].getLineNumber() + "] "
					+ "index=" + index);

			System.out.println(
					"[" + Thread.currentThread().getStackTrace()[2].getLineNumber() + "] "
					+ "value=" + (String)value);

			label.setText(value.toString());

			label.setBackground(Color.white);
			label.setForeground(Color.black);
		}

		label.setFont(new Font("Areal", Font.BOLD,20));
		
		return label;
	}
}//public class MyCellRenderer implements ListCellRenderer
