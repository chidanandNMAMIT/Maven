package fileReadWrite;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlReader {
	public static void main(String[] args) {
		
		  DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		  try {
		   DocumentBuilder builder=factory.newDocumentBuilder();
		   Document doc=builder.parse("F:\\chidanand\\java naveenautomation labs\\javaOops\\src\\java_io\\people.xml");
		  } catch (ParserConfigurationException e) {
		   
		   e.printStackTrace();
		  } catch (SAXException e) {
		  
		   e.printStackTrace();
		  } catch (IOException e) {
		   
		   e.printStackTrace();
		  }
		  
		 }

}
