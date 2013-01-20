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

//public class TC2_B1_v1_1 extends JFrame{
//
//	  public static void main(String[] args){
//	    TC2_B1_v1_1 test = new TC2_B1_v1_1("JListSample");
//
//	    /* 終了処理を変更 */
//	    test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//	    test.setBounds( 10, 10, 250, 130);
//	    test.setVisible(true);
//	  }
//
//	  TC2_B1_v1_1(String title){
//	    setTitle(title);
//
//	    /* JListの初期データ */
//	    String[] initData = {"Blue", "Green", "Red", "Whit", "Black"};
//	    JList list = new JList(initData);
//
//	    /* CellRendererを設定する */
//	    MyCellRenderer renderer = new MyCellRenderer();
//	    list.setCellRenderer(renderer);
//
//	    JScrollPane sp = new JScrollPane();
//	    sp.getViewport().setView(list);
//	    sp.setPreferredSize(new Dimension(200, 80));
//
//	    JPanel p = new JPanel();
//	    p.add(sp);
//
//	    getContentPane().add(p, BorderLayout.CENTER);
//	  }
//
//	  class MyCellRenderer implements ListCellRenderer {
//	    JLabel label;
//
//	    public MyCellRenderer() {
//	      label = new JLabel();
//	      label.setOpaque(true);
//	    }
//
//	    public Component getListCellRendererComponent(
//	      JList list,
//	      Object value,
//	      int index,
//	      boolean isSelected,
//	      boolean cellHasFocus){
//
//	      if (isSelected){
//	        label.setText("●  " + value.toString() + "  ●");
//
//	        label.setBackground(Color.red);
//	        label.setForeground(Color.white);
//	      }else{
//	        label.setText(value.toString());
//
//	        label.setBackground(Color.white);
//	        label.setForeground(Color.black);
//	      }
//
//	      return label;
//	    }
//	  }
//	}

//import tc2.utils.Methods;

//public class TC2 {
//	  public static void main(String args[]){
//	    //このしたからアプリが始まります。
//	    new WindowTest();//これで制御をWindowTestクラスに移す
//	  }
//	}
//
//
//	//
//	//WindowTest クラスは, Windowの表示を行います。
//	//
//	//  ListとCheckBoｘのデモ
//	//
//	class WindowTest extends Frame 
//	  implements WindowListener,ActionListener,ItemListener{
//
//	  /**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//	//表示用のコンポーネント
//	  Label  label;//Label型変数　labelを宣言
//	  Button buttonｓ[]=new Button[16];//Button型の配列　buttonsを宣言
//	  List   list;//リスト
//	  Checkbox check;//チェックボックス
//
//	  //Button用のラベル
//	  String buttonLabels[]=
//	    {"7","8","9","[+]",
//	     "4","5","6","[-]",
//	     "1","2","3","[×]",
//	     "0",".","Ent","[÷]"
//	    };
//
//	  //押されたボタンなどを記録する変数
//	  String regA;//前の入力結果
//	  String regB;//現在の入力結果
//
//	  //radianに変換する係数
//	  double toRad;
//
//	  //コンストラクタ
//	  WindowTest(){
//	    int i;
//
//	    //regA,regBをクリア
//	    regA="";
//	    regB="";
//	    //Layoutnに必要なGridBagLayout型変数gridBagを宣言
//	    GridBagLayout gridbag = new GridBagLayout();//GridBagayout型変数　gridbagの宣言と初期化
//	        GridBagConstraints c = new GridBagConstraints();//GridBagConstraints型変数cの宣言と初期化
//	      
//
//	    //Windowを作る
//	    addWindowListener(this);//リスナーの設定
//	    setSize(240, 240);//サイズを指定す
//	    setLayout( gridbag);//BorBagLayout設定
//
//
//	    //WIndowにLabelを追加する。
//	    label=new Label(regB);//表示用部品に初期値をセット
//
//	    c.fill = GridBagConstraints.BOTH;//サイズを立て横とも、自動でそろえるように設定
//	    c.gridx=0;//表示横位置
//	    c.gridy=0;//表示の縦位置
//	    c.gridwidth=4;//表示の幅
//	    c.gridheight=1;//表示の高さ
//	    gridbag.setConstraints(label, c);//label表示条件を設定
//	    add(label);//表示用の部品をWindow「上」に追加
//
//	    //Buttonの生成と追加
//	    c.gridwidth=1;//表示の幅は１升
//	    c.gridheight=1;//表示の高さも１升
//	    for(i=0;i<16;i++){
//	      buttonｓ[i]=new Button(buttonLabels[i]);//Buttonの生成
//	      buttonｓ[i].addActionListener(this);//ActionListenerをセット
//	      c.gridx=i % 4;//表示の横位置の設定
//	      c.gridy=(i/4)+1;//表示の縦位置の設置
//	      gridbag.setConstraints(buttonｓ[i], c);//Buttonの表示条件の設定
//	      add(buttonｓ[i]);//表示用の部品をWindow「上」に追加
//	    }
//
//	    //最初の角度の単位はRad
//	    toRad=1.0;
//
//	    //ListBoxの設定
//	    list=new List();//リストボックスの初期値設定
//	    list.add("√");//0番のアイテムは√
//	    list.add("sin");//1番のアイテムはsin
//	    list.add("cos");//２番のアイテムはcos
//	    list.add("tan");//3番のアイテムはtan
//
//	    list.addItemListener(this);//itemListenerをセット
//
//	    //表示位置の設定
//	    c.gridx=0;//横は一番←
//	    c.gridy=6;//縦は６マス目
//	    c.gridwidth=3;//幅３升
//	    gridbag.setConstraints(list,c);//位置をセット
//
//	    add(list);//Winodwに追加
//
//	    //Choiceの設定
//	    check=new Checkbox("Degree");//チェックボックスの設定
//	    check.setState(false);//初期値にチェックなしを設定
//
//	    check.addItemListener(this);//itemListenerをセット
//
//	    //表示位置のセット
//	    c.gridx=3;
//	    c.gridwidth=1;
//	    gridbag.setConstraints(check,c);
//
//	    add(check);//Windowに追加
//
//	    setVisible(true);//可視化する
//	  }
//
//	  //-------------------------------------------------
//	  // 以下のメソッドは、Windowに変化があったときに自動で実行されます。
//	  //( WindowListenerが要求したメソッド）
//	  //-------------------------------------------------
//
//	  //アクティブになった特の処理
//	  public void windowActivated(java.awt.event.WindowEvent e) {
//	    System.out.println("Activated");
//	  }
//
//	  //閉じられた時の処理
//	  public void windowClosed(java.awt.event.WindowEvent e) {
//	    System.out.println("Closed");
//	  }
//
//	  //閉じられている時の処理
//	  public void windowClosing(java.awt.event.WindowEvent e) {
//	    System.out.println("Closing");
//	    System.exit(0);//アプリの終了
//	  }
//
//	  //アクティブでなくなったときの処理
//	  public void windowDeactivated(java.awt.event.WindowEvent e) {
//	    System.out.println("Deactivaed");
//	  }
//
//	  //アイコンから戻ったときの処理
//	  public void windowDeiconified(java.awt.event.WindowEvent e) {
//	    System.out.println("Deicnified");
//	  }
//
//	  //アイコン化された時の処理
//	  public void windowIconified(java.awt.event.WindowEvent e) {
//	    System.out.println("Icnified");
//	  }
//
//	  // 開かれた時の処理
//	  public void windowOpened(java.awt.event.WindowEvent e) {
//	    System.out.println("Opend");
//	  }
//
//	  //-------------------------------------------
//	  //  ボタンが押されたとき呼び出されるメソッド
//	  //--------------------------------------------
//	  public void actionPerformed(ActionEvent e) {
//	    Button bt=(Button)e.getSource();//押されたボタンを取得
//	    String lbl=bt.getLabel();//ボタンのラベルを取得
//	    double a,b,c;//途中計算に使うdouble型変数
//	    if (lbl.length()==1){
//	      //ラベルが１文字なら
//	      regB=regB+lbl;//regAに加える
//	    }else if(lbl.equals("Ent")){
//	      //ラベルがEntなら
//	      regA=regB;//regBをregAにセット
//	      regB="";//regBをクリア
//	    }else{
//	      //ラベルが四則演算なら、演算を実施
//	      //Errが出る可能性があるので、例外処理を追加
//	      try{
//	        c=0;//計算結果を０にする（初期化しないとエラーが出る）
//	        a=Double.parseDouble(regA);//regAを数値に変換
//	        b=Double.parseDouble(regB);//regBを数値に変換
//
//	        if (lbl.equals("[+]")) c=a+b;//[+]ボタンが押されたら加算を実施
//	        if (lbl.equals("[-]")) c=a-b;//[－]ボタンが押されたら引き算を実施
//	        if (lbl.equals("[×]")) c=a*b;//[×]ボタンが押されたら掛け算を実施
//	        if (lbl.equals("[÷]")) c=a/b;//[÷]ボタンが押されたら掛け算を実施
//
//	        regB=String.valueOf(c);//計算結果をStringに変換
//
//	      }catch(Exception err){
//	        regB="Err";//ErrがでたらErrを表示
//	      }
//	    }
//
//	    label.setText(regB);//表示の更新
//	  }
//
//	  //-------------------------------------------
//	  //  ListやChoiceの変更されたと場合の呼びだされるメソッド
//	  //-------------------------------------------
//	  public void itemStateChanged(ItemEvent e) {
//
//	    Object scr=e.getSource();//イベントが発生したコンポーネントを取得する。
//
//	    if (scr==list){
//	      //以下はListが操作された場合の処理
//	      int itemNo=list.getSelectedIndex();//選択されたアイテムのNoを手に入れる
//	      double b,c;//計算用の数値変数
//	      try{
//	        b=Double.parseDouble(regB);//regBを数値に変換
//	        c=0;//結果に０を入れておく
//	        if (itemNo==0) c=Math.sqrt(b);//0番選択なら√を計算 
//	        if (itemNo==1) c=Math.sin(toRad*b);//1番選択ならsinを計算
//	        if (itemNo==2) c=Math.cos(toRad*b);//２番選択ならcosを計算
//	        if (itemNo==3) c=Math.tan(toRad*b);//3番選択ならtanを計算
//	        regB=String.valueOf(c);//計算結果を文字列に戻す
//	      }catch(Exception err){
//	        regB="Err";//Errが発生したらErrを設定
//	      }
//	      label.setText(regB);//結果の再表示
//
//	    }
//
//	    if (scr==check){
//	      //checkが操作された時の処理
//	      if(check.getState()){
//	        //チェックがあれば、toRadの値をπ/180に設定
//	        toRad=Math.PI/180;//Math.PIは円周率を示す
//	      }else{
//	        //チェックがないと、１に設定
//	        toRad=1;
//	      }
//
//	    }
//	  }
//
//	}


public class TC2_B1_v1_1 extends JFrame implements ActionListener {

	private JList<String> list;
    private DefaultListModel<String> model;
	private JList<String> list_diff;
    private DefaultListModel<String> model_diff;

    private JButton btn_time;
    private JButton btn_clear;
    private JButton btn_calculate;

    private static HashMap<String, String> map;
    
	public TC2_B1_v1_1() {
		
		initUI();
		
		
	}
	
	private void initUI() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		// Buttons
		panel = initUI_1_buttons(panel);
		
		// Menues
		JMenuBar menubar = initUI_2_menues(this);
		
		setJMenuBar(menubar);
		
		// List
		initUI_3_list(panel);
		
//		panel.add(list);
		
		//
		panel.setLayout(null);

		initUI_frame(this);
		
	}//private void initUI()

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initUI_3_list(JPanel panel) {
		// TODO Auto-generated method stub
		// List for time labels
		model = new DefaultListModel();
        list = new JList(model);
        list.setBounds(200, 30, 220, 150);
        
        // List for diff labels
		model_diff = new DefaultListModel();
        list_diff = new JList(model_diff);
        list_diff.setBounds(200, 200, 220, 100);
        
        list.setFont(new Font("Century", Font.BOLD, 18));
        list_diff.setFont(new Font("Century", Font.BOLD, 18));
        
        // Listener
        list_diff.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				String item = (String) list_diff.getSelectedValue();
				
				Toolkit kit = Toolkit.getDefaultToolkit();
				Clipboard clip = kit.getSystemClipboard();
				
				StringSelection ss = new StringSelection(item);
				
				clip.setContents(ss, ss);
				
//				model_diff.addElement(item);
				
			}});

        list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				String item = (String) list.getSelectedValue();
				
				Toolkit kit = Toolkit.getDefaultToolkit();
				Clipboard clip = kit.getSystemClipboard();
				
				StringSelection ss = new StringSelection(item);
				
				clip.setContents(ss, ss);
				
//				model_diff.addElement(item);
				
			}});

//        // Scroll pane
////        JScrollPane sp = new JScrollPane();
////        JScrollPane sp_diff = new JScrollPane();
//        JScrollPane sp = new JScrollPane(list);
//        JScrollPane sp_diff = new JScrollPane(list_diff);
//        
//        sp.setBackground(Color.blue);
//        sp.setVisible(true);
////        sp.getViewport().setView(list);
////        sp.setPreferredSize(new Dimension(220, 150));
////        
////        sp_diff.getViewport().setView(list_diff);
////        sp_diff.setPreferredSize(new Dimension(220, 100));
////
//        panel.add(sp);
//        panel.add(sp_diff);

        // Add to panel
        panel.add(list);
        panel.add(list_diff);
	}

	private JMenuBar initUI_2_menues(JFrame frame) {
		// TODO Auto-generated method stub
		JMenuBar menubar = new JMenuBar();
        ImageIcon icon = new ImageIcon(getClass().getResource("icon_menu_file_50x37.png"));
//		ImageIcon icon = new ImageIcon(getClass().getResource("image/icon_menu_file_50x37.png"));
//		ImageIcon icon = new ImageIcon(getClass().getResource("../image/icon_menu_file_50x37.png"));
//		ImageIcon icon = new ImageIcon(getClass().getResource("../../icon_menu_file_50x37.png"));
		
        // Menu
        JMenu file = new JMenu("File(F)");
        file.setMnemonic(KeyEvent.VK_F);
        
        // Menu item
        JMenuItem eMenuItem = new JMenuItem("Exit(C)", icon);
        eMenuItem.setMnemonic(KeyEvent.VK_C);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }

        });
        
        // Add item to menu
        file.add(eMenuItem);
        
        menubar.add(file);
        
        return menubar;
	}

	private void initUI_frame(JFrame frame) {
		// TODO Auto-generated method stub
		setTitle("E2");
		
		frame.setSize(600, 400);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private JPanel initUI_1_buttons(JPanel panel) {
		
		// Get time
		btn_time = new JButton(map.get("gt"));
		
		btn_time.setBounds(50, 60, 130, 50);
		
		btn_time.addActionListener(this);
		
		// Calculate the duration
		btn_calculate = new JButton(map.get("cal"));
		
		btn_calculate.setBounds(50, 120, 130, 50);
		
		btn_calculate.addActionListener(this);
		
		// Clear the labels
		
		btn_clear = new JButton(map.get("cl"));
		
		btn_clear.setBounds(50, 180, 130, 50);
		
		btn_clear.addActionListener(this);
		
		// Add to panel
		panel.add(btn_time);
		panel.add(btn_calculate);
		panel.add(btn_clear);
		
//		// Clear
//		btn_clear = new JButton("Clear");
//		btn_clear.setBounds(50, 120, 130, 50);
//		
//		this.add(btn_clear);
		
		return panel;
	}

	public static void main(String[] args) {

		init_map();
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				TC2_B1_v1_1 ex = new TC2_B1_v1_1();
				
				ex.setVisible(true);
				
			}//public void run()
		});//SwingUtilities.invokeLater
	}


	private static void init_map() {
		
		map = new HashMap<String, String>();
		
		map.put("gt", "Get time");
		map.put("cal", "Calculate");
		map.put("cl", "Clear");
		
	}//private static void init_map()
	

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton o = (JButton) e.getSource();
		
		String label = o.getText();
		
		if (label.equals(map.get("gt"))) {
			
			actionPerformed_get_time(e);
			
		} else if (label.equals(map.get("cal"))) {//if (label.equals(map.get("gt")))

			actionPerformed_cal();
			
		} else if (label.equals(map.get("cl"))) {//if (label.equals(map.get("gt")))
			
			actionPerformed_clear(e);
			
		}//if (label.equals(map.get("gt")))
		
	}//public void actionPerformed(ActionEvent arg0)

	private void actionPerformed_cal() {
		
		long duration = 0;
		
//		if (model.getSize() < 4) {
		if (model.getSize() < 2) {
			
			return;
			
		}//if (model.getSize() == condition)
		
		//
//		String[] start_time = model.get(1).split(" ")[1].split(":");
//		String[] start_time = model.get(1).split(" ")[2].split(":");
		String[] start_time = model.get(model.size() - 2).split(" ")[0].split(":");
		
		String[] end_time = model.get(model.size() - 1).split(" ")[0].split(":");
		
//		model.addElement(model.get(1).split(" ")[2]);
//		model.addElement(start_time[0]);
//		model.addElement(model.get(0));
		
		
		Calendar c_start = Calendar.getInstance();
		c_start.set(2013, 1, 10,
				Integer.parseInt(start_time[0]),
				Integer.parseInt(start_time[1]),
				Integer.parseInt(start_time[2])
		);
		
		long s_time = c_start.getTimeInMillis();

		// End time
		Calendar c_end = Calendar.getInstance();
		c_end.set(2013, 1, 10,
				Integer.parseInt(end_time[0]),
				Integer.parseInt(end_time[1]),
				Integer.parseInt(end_time[2])
		);
		
		long e_time = c_end.getTimeInMillis();

		long diff = e_time - s_time;
		
		String digit_time = Methods.convert_millsec_to_digit_label(diff);
		
//		model.addElement(String.valueOf(s_time));
//		model.addElement(String.valueOf(e_time));
		if (model_diff.getSize() >= 4) {
			
			model_diff.remove(0);
			
			model_diff.addElement(String.valueOf(digit_time));
			
		} else {//if (model_digit_time.getSize() > 4)
			
			model_diff.addElement(String.valueOf(digit_time));
			
		}//if (model_diff.getSize() > 4)
		
//		model_diff.addElement(String.valueOf(e_time));
		
	}//private void actionPerformed_cal(ActionEvent e)

	private void actionPerformed_clear(ActionEvent e) {
		// TODO Auto-generated method stub
		
		model.clear();
		
		model_diff.clear();
		
	}//private void actionPerformed_clear(ActionEvent e)

	private void actionPerformed_get_time(ActionEvent e) {
		// TODO Auto-generated method stub
		Locale locale = Locale.getDefault();
		
        Date date = new Date(e.getWhen());
        
        String s = DateFormat.getTimeInstance(DateFormat.LONG,
                locale).format(date);
        
        if (!model.isEmpty()) {
        	
        	int num = model.getSize();
        	
        	if (num >= 4) {
				
        		model.remove(0);
        		
			}//if (num == condition)
        	
        }
        
        long time_now = Methods.get_millsec_now();
        
        String s_time_now = Methods.get_time_Label(time_now);
        
        model.addElement(s_time_now);
        
	}//private void actionPerformed_get_time()

}
