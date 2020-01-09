package com.sjx.test.manager;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sun.tools.javac.code.Type.ErasedClassType;

public class Test {

	public static void main(String[] args) {
		File xmlFile = new File("C:\\test\\test.txt");
		SAXReader reader = new SAXReader();
		try {
			String xml = "<RESPONSE>\r\n" + 
					"<RESULT>\r\n" + 
					"<CODE>MA==</CODE>\r\n" + 
					"<MSG></MSG>\r\n" + 
					"<COUNT>MjY=</COUNT>\r\n" + 
					"<PCNT>MTAwMA==</PCNT>\r\n" + 
					"<PAGE>MQ==</PAGE>\r\n" + 
					"</RESULT>\r\n" + 
					"<DATA PAGE=\"MQ==\" CNT=\"MjY=\">\r\n" + 
					"<SXBZXR>\r\n" + 
					"<ID>MDRlODczYzQtNmYwZS00OWRhLTkxYjEtMjI3NWI1ZTQ0ZmUy</ID>\r\n" + 
					"<AHDM>MDA3MzAwMDAwMTQwMzMy</AHDM>\r\n" + 
					"<AH>KDIwMTcp5rSlMDExOeaJpzMyOTflj7c=</AH>\r\n" + 
					"<LASJ>MjAxNy8wNi8yMQ==</LASJ>\r\n" + 
					"</SXBZXR>\r\n" + 
					"<SXBZXR>\r\n" + 
					"<ID>MDI2Zjg2MWUtMzg2My00MjE0LTliNjktNjNjODQ2NmUxYWQx</ID>\r\n" + 
					"<AHDM>MDA2OTAwMDAwMTQyNjU2</AHDM>\r\n" + 
					"<AH>KDIwMTcp5rSlMDExMuaJpzM5ODTlj7c=</AH>\r\n" + 
					"<LASJ>MjAxNy8xMC8yMw==</LASJ>\r\n" + 
					"</SXBZXR>\r\n" + 
					"</DATA></RESPONSE>";
			String soapXml = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
					"<soap:Header/>\r\n" + 
					"<soap:Body>\r\n" + 
					"<ns1:getSxbzxrListResponse xmlns:ns1=\"http://service.webService.xycj.tdh/\">\r\n" + 
					"<return>\r\n" + 
					"testtest"+
					"</return>\r\n" + 
					"</ns1:getSxbzxrListResponse></soap:Body></soap:Envelope>";
			
			Document document = DocumentHelper.parseText(soapXml);//reader.read(xmlFile);
			Element root = document.getRootElement();
			Element body = root.element("Body");
			Element getSxbzxrListResponse = body.element("getSxbzxrListResponse");
			System.out.println(getSxbzxrListResponse.elementText("return"));
			
			/*Element data = root.element("DATA");
			List<Element> list = data.elements("SXBZXR");
			
			int i = 1;
			for(Element element:list)
			{
				System.out.println("第"+i+"个节点的属性");
				System.out.println("ID="+element.elementText("ID"));
				System.out.println("AHDM="+element.elementText("AHDM"));
				System.out.println("AH="+element.elementText("AH"));
				System.out.println("LASJ="+element.elementText("LASJ"));
				i++;
			}*/
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
