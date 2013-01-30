package tc2.B5.v1_2.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;

public class BtnActionListener  implements ActionListener {

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton o = (JButton) e.getSource();
		
		String label = o.getText();
		
		String name = o.getName();
		
//		// Log
//		Log.d("${file}" + "["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber() + "]",
//				"${message}");

		//REF=> http://stackoverflow.com/questions/115008/how-can-we-print-line-numbers-to-the-log-in-java
		System.out.println("label=" + label
//						+ "(Line=" + Thread.currentThread().getStackTrace()[2].getLineNumber()
						+ "(Line=" + String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber())
						+ ")");
		
		//REF=> http://npnl.hatenablog.jp/entry/20070724/1185294796
		StackTraceElement[] ste = (new Throwable()).getStackTrace();
		System.out.println("ste[0].getLineNumber()=" + ste[0].getLineNumber());
		
		System.out.println("new Throwable() ==> " + (new Throwable()).getStackTrace()[0].getLineNumber());
		
		if (name.equals(CONS.BtnNames.BtnGetTime.name())) {
			
			actionPerformed_get_time(e);
			
		} else if (name.equals(CONS.BtnNames.BtnCalc.name())) {//if (name.equals(map.get("gt")))

			actionPerformed_cal();
			
		} else if (name.equals(CONS.BtnNames.BtnClear.name())) {//if (name.equals(map.get("gt")))
			
			actionPerformed_clear(e);
			
		}  else if (name.equals(CONS.BtnNames.BtnExit.name())) {//if (name.equals(map.get("gt")))
			
			actionPerformed_exit(e);
			
		}
		
	}//public void actionPerformed(ActionEvent arg0)

	private void actionPerformed_exit(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//debug =========================
		System.out.println("["
				+ (new Throwable()).getStackTrace()[0].getFileName() + ":"
				+ (new Throwable()).getStackTrace()[0].getLineNumber()
				+ "] "
				+ "Exiting...");
		
		////////////////////////////debug
		System.exit(0);
	}

	private void actionPerformed_cal() {
		
	}//private void actionPerformed_cal(ActionEvent e)

	private void actionPerformed_clear(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}//private void actionPerformed_clear(ActionEvent e)

	private void actionPerformed_get_time(ActionEvent e) {
		
        long timeNow = Methods.get_millsec_now();
        
        String labelTimeNow = Methods.get_time_Label(timeNow);
        
        System.out.println("time=" + labelTimeNow);
		
        

	}//private void actionPerformed_get_time()

}
