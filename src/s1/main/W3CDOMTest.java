package s1.main;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class W3CDOMTest {

	 
		public static void main (String[] args) {
			try {
				// ドキュメントビルダーファクトリを生成
				DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
				
				// ドキュメントビルダーを生成
				DocumentBuilder builder = dbfactory.newDocumentBuilder();
				
				// パースを実行してDocumentオブジェクトを取得
				Document doc = builder.parse(new File("dos2unix.mm"));
				
				// ルート要素を取得（タグ名：message）
				Element root = doc.getDocumentElement();
				
				System.out.println("root => Obtained");
				
				System.out.print("root=" + root.getClass().getName());
					//=> root=com.sun.org.apache.xerces.internal.dom.DeferredElementImpl
				
				// 最初の子ノード（テキストノード）の値を表示
				System.out.print(root.getFirstChild().getNodeValue());
				
				System.out.println("Node name=" + root.getFirstChild().getNodeName());
					//=> Node name=#text
				
//				System.out.println("First child. Length=" + root.getFirstChild().getAttributes().getLength());	//=> java.lang.NullPointerException
				System.out.println("root.getFirstChild().hasChildNodes()="
										+ root.getFirstChild().hasChildNodes());
					//=> root.getFirstChild().hasChildNodes()=false
						
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
