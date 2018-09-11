package oc.utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 * Update notiofication window
 *
 * @author Stefan Oswald
 */
public class UpdateNotifier {

    private static UpdateNotifier uniqueInstance = null;

    public static UpdateNotifier getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new UpdateNotifier();
        }
        return uniqueInstance;
    }

    private UpdateNotifier() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JEditorPane jEditorPane = new JEditorPane();
                jEditorPane.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(jEditorPane);

                // Create HTML renderer pane
                HTMLEditorKit kit = new HTMLEditorKit();
                jEditorPane.setEditorKit(kit);

                // CSS styles for HTML output
                StyleSheet styleSheet = kit.getStyleSheet();
                styleSheet.addRule("body {color:#000; font-family:arial, verdana, helvetica; margin: 4px;}");
                styleSheet.addRule("h1 {font-size: 18pt; color: #cc0000; font-weight: bold; margin: 10px 0;}");
                styleSheet.addRule("h2 {font-size: 15pt; color: #4a555a; font-weight: bold; margin: 10px 0;}");
                styleSheet.addRule("p {font-size: 12pt; margin: 10px 0 20px 20px;}");

                // Load RSS feed from OnlineCodex news forum
                RSSReader reader = RSSReader.getInstance();
                ArrayList<RSSItem> feedData = reader.readFeed();

                StringBuilder sb = new StringBuilder();
                for(RSSItem item : feedData) {
                    sb.append(item.toString());
                }

                // create some simple html as a string
                String htmlString = String.format("<html>\n"
                    + "<body>\n"
                    + "<h1>Eine neue Version ist verfügbar!</h1>\n"
                    + "%s\n"
                    + "</body>\n",
                    sb.toString()
                );

                // Write HTML data into pane
                Document doc = kit.createDefaultDocument();
                jEditorPane.setDocument(doc);
                jEditorPane.setText(htmlString);
                jEditorPane.setCaretPosition(0);

                // Open popup window with update history
                JFrame frame = new JFrame("OnlineCodex Update-Service");
                frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setSize(new Dimension(800, 600));
                //frame.pack();

                // Show frame
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
