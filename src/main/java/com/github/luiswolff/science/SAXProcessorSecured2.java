package com.github.luiswolff.science;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SAXProcessorSecured2 {

    public static void main(String[] args) throws JAXBException, FileNotFoundException, SAXException, ParserConfigurationException, TransformerException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
        spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(), new InputSource(new FileInputStream("xxe.xml")));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(xmlSource, new StreamResult(System.out));
    }

}