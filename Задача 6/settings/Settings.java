package settings;

import data.DiaryData;
import generator.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.crypto.Data;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Settings {
    private final String FILEPATH = "C:\\Users\\rusel\\IdeaProjects\\Tests\\Settings.xml";
    private SettingsData data;

    private String getValue(NodeList fields, int index) {
        NodeList list = fields.item(index).getChildNodes();
        if (list.getLength() > 0) {
            return list.item(0).getNodeValue();
        } else {
            return "";
        }
    }

    public SettingsData readDataXML()  {
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

            nodeList = doc.getElementsByTagName("settings");
            Node node = nodeList.item(0);
            Element el = (Element) node;

            data = SettingsData.builder()
                    .username(getValue(el.getElementsByTagName("username"), 0))
                    .password(getValue(el.getElementsByTagName("password"), 0))
                    .site(getValue(el.getElementsByTagName("site"), 0))
                    .width(getValue(el.getElementsByTagName("width"), 0))
                    .height(getValue(el.getElementsByTagName("height"), 0))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
