package generator;

import data.DiaryData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Generator {
    public static void main(String[] args) {
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];
        if (type.equals("diary"))
            generateDiaries(count, filename, format);
        else
            System.err.println("Не верный тип " + type);
    }

    private static void generateDiaries(int count, String filename, String format) {
        List<DiaryData> diaries = new ArrayList<DiaryData>();
        for (int i = 0; i < count; i++) {
            diaries.add(new DiaryData(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        }

        if (format.equals("xml")) {

            try {
                DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
                Document document = documentBuilder.newDocument();
                Element di = document.createElement("Diaries");
                document.appendChild(di);
                for (int i = 0; i < count; i++) {
                    Element root = document.createElement("DiaryData");
                    di.appendChild(root);
                    Element tag = document.createElement("tag");
                    tag.appendChild(document.createTextNode(diaries.get(i).getTag()));
                    Element text = document.createElement("text");
                    text.appendChild(document.createTextNode(diaries.get(i).getText()));
                    root.appendChild(tag);
                    root.appendChild(text);
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StreamResult streamResult = new StreamResult(new File(filename));
                transformer.transform(domSource, streamResult);
            } catch (ParserConfigurationException | TransformerException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
}