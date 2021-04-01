package com.github.luiswolff.science;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SAXProcessorSecured {

    public static void main(String[] args) throws JAXBException, FileNotFoundException, SAXException, ParserConfigurationException, TransformerException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);

        SAXParser saxParser = spf.newSAXParser();
        saxParser.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "false");
        Source xmlSource = new SAXSource(saxParser.getXMLReader(), new InputSource(new FileInputStream("xxe.xml")));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(xmlSource, new StreamResult(System.out));
    }

}