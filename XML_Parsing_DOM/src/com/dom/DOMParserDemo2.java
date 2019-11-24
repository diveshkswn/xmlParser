package com.dom;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.Bean.course;

public class DOMParserDemo2 {

	public static void main(String arsg[]) throws Exception {
		
		
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc=builder.parse("xml/random.xml");
		
		List<course> courseList=new ArrayList<course>();
		
		//root
		NodeList nodeli=doc.getDocumentElement().getChildNodes();
		//
		Node somebody=nodeli.item(1);
		
		NodeList slist=somebody.getChildNodes();
		Node coursenode=slist.item(1);
		NodeList clist=coursenode.getChildNodes();
		System.out.println(clist.getLength());
		course c=new course();
		for(int i=0; i<clist.getLength(); i++) {
			Node cnode=clist.item(i);
			
			//we use instanceof Element for only getting Element and not unnecessary attributes.
			if(cnode instanceof Element) {
			
				if(cnode.getNodeName().equals("voyage")) {
					c.setVoyage(cnode.getTextContent());
				//	System.out.println(cnode.getTextContent());
				}
				else if(cnode.getNodeName().equals("sharp")) {
					c.setSharp(cnode.getTextContent());
				}
				else if(cnode.getNodeName().equals("off")) {
					c.setOff(cnode.getTextContent());
				}
				
				else if(cnode.getNodeName().equals("likely")) {
					c.setLikely(cnode.getTextContent());
				}
				
				
				
				
				
				
			}
			
			
		}
		courseList.add(c);
		//System.out.println(courseList);
		for(int i=0; i<courseList.size(); i++) {
			System.out.println(courseList.get(i));
			
		}
		
	}
}
