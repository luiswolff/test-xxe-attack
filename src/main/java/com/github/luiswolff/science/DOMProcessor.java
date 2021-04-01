package com.github.luiswolff.science;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DOMProcessor {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("xxe.xml"));
        System.out.println(doc.getElementsByTagName("author").item(0).getTextContent());
    }

}
