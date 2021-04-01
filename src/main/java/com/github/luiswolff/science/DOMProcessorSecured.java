package com.github.luiswolff.science;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DOMProcessorSecured {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
        dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "false");
        
        Document doc = dbf.newDocumentBuilder().parse(new File("xxe.xml"));
        System.out.println(doc.getElementsByTagName("author").item(0).getTextContent());
    }

}
