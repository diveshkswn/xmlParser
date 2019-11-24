package com.dom;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.Bean.Employee;



public class DOMParserDemo {

	public static void main(String[]  args) throws Exception{
	
		//Get the DOM Builer Factory
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		//Get DOM builer
		DocumentBuilder builder =  factory.newDocumentBuilder();
	
		
		
		//Load and Parse the XML document
		
			Document doc=  builder.parse("xml/employee.xml");
			
		
		List<Employee>empList=new ArrayList<Employee>();
		
		//Iterating through the nodes and extracting the data.
		
		NodeList nodeli=doc.getDocumentElement().getChildNodes();
		
		for(int i=0; i<nodeli.getLength(); i++) {
			Node node=nodeli.item(i);
			if(node instanceof Element) {
				Employee emp=new Employee();
				emp.setId(node.getAttributes().getNamedItem("id").getNodeValue());
				//We are using .getchildNotes() on every Node to get the sub elements of xml <Employee. Like <firstName>, <lastName> and <location>.
				NodeList childNodes=node.getChildNodes();
				for(int j=0; j<childNodes.getLength(); j++) {
					Node cnode=childNodes.item(j);
					
					//Identifying the child tag of employee encountered.
					
					if(cnode instanceof Element) {
						if(cnode.getNodeName().equals("firstName")) {
							emp.setFirstName(cnode.getTextContent());
						}
						else if(cnode.getNodeName().equals("lastName")) {
							emp.setLastName(cnode.getTextContent());
						}
						else if(cnode.getNodeName().equals("location")) {
							emp.setLocation(cnode.getTextContent());
						}
						
					}
					
				}
				empList.add(emp);
			
			}
		
			
		}
		
		
		for(int i=0; i<empList.size(); i++) {
			System.out.println(empList.get(i));
		}
	
}
}