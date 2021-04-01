package com.github.luiswolff.science;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxProcessorSecured {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        XMLStreamReader reader = xif.createXMLStreamReader(new FileInputStream("xxe.xml"));
        while (reader.hasNext()) {
            switch (reader.next()) {
            case XMLStreamConstants.START_ELEMENT:
                if ("author".equals(reader.getLocalName())) {
                    System.out.println(reader.getElementText());
                }
            }
        }

    }

}
