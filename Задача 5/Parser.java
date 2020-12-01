package generator;

import data.DiaryData;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final String FILEPATH = "C:\\Users\\rusel\\Desktop\\test.xml";
    private List<DiaryData> diaries;

    private String getValue(NodeList fields, int index) {
        NodeList list = fields.item(index).getChildNodes();
        if (list.getLength() > 0) {
            return list.item(0).getNodeValue();
        } else {
            return "";
        }
    }

    public List<DiaryData> readDataXML()  {
        diaries = new ArrayList<DiaryData>();

        DocumentBuilderFactory dbf = null;
        DocumentBuilder db = null;
        Document doc = null;
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = null;

            FileInputStream fis = null;
                try {
                    fis = new FileInputStream(FILEPATH);
                    doc = db.parse(fis);
                } catch (SAXException | IOException e) {
                    e.printStackTrace();
                }
            doc.getDocumentElement().normalize();

            NodeList tags = null;
            NodeList texts = null;
            NodeList nodeList = null;

            nodeList = doc.getElementsByTagName("DiaryData");

            for (int s = 0; s < nodeList.getLength(); s++) {
                Node node = nodeList.item(s);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) node;
                    tags = el.getElementsByTagName("tag");
                    texts = el.getElementsByTagName("text");
                    DiaryData d = new DiaryData();
                    d.setTag(getValue(tags, 0));
                    d.setText(getValue(texts, 0));
                    diaries.add(d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diaries;
    }

    public static void main(String[] args) {
        Parser parser = new Parser();
        List<DiaryData> diaries = parser.readDataXML();

        int i = 0;
        System.out.println("Полученные данные:");
        for (DiaryData data: diaries) {
            System.out.println(++i + ":");
            System.out.println("Tag:" + data.getTag());
            System.out.println("Text:" + data.getText());
        }
    }
}
