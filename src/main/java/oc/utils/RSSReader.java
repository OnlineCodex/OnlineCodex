package oc.utils;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Read the news feed from the OnlineCodex forum
 * 
 * @author Stefan Oswald
 */
public class RSSReader {

    private static RSSReader instance = null;

    private RSSReader() {
    }

    public static RSSReader getInstance() {
        if (instance == null) {
            instance = new RSSReader();
        }
        return instance;
    }

    public ArrayList<RSSItem> readFeed() {
        ArrayList<RSSItem> items = new ArrayList<RSSItem>();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            URL url = new URL("http://www.onlinecodex.de/forum/syndication.php?fid=6&limit=10");

            Document doc = builder.parse(url.openStream());
            NodeList nodes = doc.getElementsByTagName("item");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);

                String title = getElementValue(element, "title");
                if(title.matches("^(Update)(.)*") == false) continue;

                String description = getElementValue(element, "description");
                String dateString = getElementValue(element, "pubDate");
                
                DateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ZZZZZ", Locale.ENGLISH);
                Date date = df.parse(dateString);
                RSSItem item = new RSSItem(title, description, date);
                items.add(item);
            }
        }
        catch (Exception ex) {
            return null;
        }
        return items;
    }

    private String getCharacterDataFromElement(Element e) {
        try {
            Node child = e.getFirstChild();
            if (child instanceof CharacterData) {
                CharacterData cd = (CharacterData) child;
                return cd.getData();
            }
        } catch (Exception ex) {
        }
        return "";
    }

    protected float getFloat(String value) {
        if (value != null && !value.equals("")) {
            return Float.parseFloat(value);
        }
        return 0;
    }

    protected String getElementValue(Element parent, String label) {
        return getCharacterDataFromElement((Element) parent.getElementsByTagName(label).item(0));
    }

}
