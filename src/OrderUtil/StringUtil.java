package OrderUtil;

import java.io.ByteArrayOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class StringUtil {

	public static boolean isEmpty(String str) {
		return ("".equals(str) || str == null) ? true : false;
	}
	
	public static boolean less8(String str) {
		return str.length() < 8 ? true : false;
	}
	
	public static boolean less6(String str) {
		return str.length() < 6 ? true : false;
	}
	
	public static String XmlBuilder(String username, String password) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			
			Element doc_username = doc.createElement("username");
			Text te_username = doc.createTextNode(username);
			doc_username.appendChild(te_username);
			
			Element doc_password = doc.createElement("password");
			Text te_password = doc.createTextNode(password);
			doc_password.appendChild(te_password);
			
			Element doc_login = doc.createElement("Login");
			doc_login.appendChild(doc_username);
			doc_login.appendChild(doc_password);
			
			
			TransformerFactory tff = TransformerFactory.newInstance();
			try {
				Transformer tf = tff.newTransformer();
				try {
					tf.transform(new DOMSource(doc_login), new StreamResult(bos));
					
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bos.toString();
	}
}
