package s1.main;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;
 
public class HelloWorldSax extends DefaultHandler {
	public static void main(String[] argv) {
		try {
				// SAXパーサーファクトリを生成
				SAXParserFactory spfactory = SAXParserFactory.newInstance();
		  
				// SAXパーサーを生成
				SAXParser parser = spfactory.newSAXParser();
		  
				// XMLファイルを指定されたデフォルトハンドラーで処理します
				String fileName = "dos2unix.mm";
		  
//      parser.parse(new File("helloworld.xml"), new HelloWorldSax());
				parser.parse(new File(fileName), new HelloWorldSax());
		  
				
				
		} catch (Exception e) {
			
				e.printStackTrace();
		  
		}
	}
	/**
	 * ドキュメント開始時
	 */
	public void startDocument() {
		System.out.println("ドキュメント開始");
	}
	/**
	 * 要素の開始タグ読み込み時
	 */
	public void startElement(String uri,
				                     String localName,
				                     String qName,
				                     Attributes attributes) {
 
		System.out.println("要素開始:" + qName);
	}
	/**
	 * テキストデータ読み込み時
	 */
	public void characters(char[] ch,
				                   int offset,
				                   int length) {
 
		System.out.println("テキストデータ：" + new String(ch, offset, length));
	}
	/**
	 * 要素の終了タグ読み込み時
	 */
	public void endElement(String uri,
				                   String localName,
				                   String qName) {
 
		System.out.println("要素終了:" + qName);
	}
	/**
	 * ドキュメント終了時
	 */
	public void endDocument() {
		System.out.println("ドキュメント終了");
	}
}
