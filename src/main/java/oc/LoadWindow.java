package oc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

public class LoadWindow extends JPanel {

    private static final long serialVersionUID = 4239397313985019958L;
    JButton openButton, saveButton;
    JFileChooser fc;
    private String loadText = "";
    private String loadTextAllies = "";
    private Element loadElement;

    public LoadWindow(String currentDir) {
        super(new BorderLayout());

        if (BuildaHQ.getSprache() == Sprache.English) {
            Locale.setDefault(Locale.US);
            setDefaultLocale(Locale.US);
        }

        fc = new JFileChooser(currentDir);
        fc.setDialogTitle(BuildaHQ.getSprache() == Sprache.German ? "Öffnen" : "Open");
        fc.setApproveButtonText(BuildaHQ.getSprache() == Sprache.German ? "Öffnen" : "Open");

        fc.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(BuildaPanel.getFileSuffix()) || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return BuildaHQ.translate(BuildaPanel.getFileSuffix() + " Dateien");
            }
        });
    }

    public String getLoadText() {
        return loadText;
    }

    public void setLoadText(String loadText) {
        this.loadText = loadText;
    }

    public String getLoadTextAllies() {
        return loadTextAllies;
    }

    public void setLoadTextAllies(String loadText) {
        this.loadTextAllies = loadText;
    }

    public Element getLoadElement() {
        return loadElement;
    }

//    public 

    public String getCurrentDir() {
        return fc.getCurrentDirectory().getAbsolutePath();
    }

    public void load(int game) {
        int returnVal = fc.showOpenDialog(LoadWindow.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            loadFile(file, game);
        }
    }

    // neuGerri
    public void loadFile(File file, int game) {
//        if (!file.getName().endsWith(BuildaPanel.getFileSuffix()) false ) {
//            JOptionPane.showMessageDialog(null, BuildaHQ.translate("Nur \"." + BuildaPanel.getFileSuffix() + "\" Dateien können geladen werden."));
//        } else {
        FileReader leser;
        String text = "";
        try {

            leser = new FileReader(file);
            loadText = "";

            for (; ; ) {
                int gelesenInt = leser.read();
                if (gelesenInt == -1) {
                    break;
                }
                char gelesenChar = (char) gelesenInt;
                text = text + gelesenChar;
            }

            leser.close();

            BuildaHQ.loadWindow = true;
            StringTokenizer tokenizer = new StringTokenizer(text, ";");

            if (game == BuildaPanel.WHFB) {
                String punkte = tokenizer.nextToken();
                BuildaPanel.budget.setText(punkte);
            }

            loadText = tokenizer.nextToken();
            loadText = loadText.substring(0, loadText.indexOf(SaveTextWindow.TOKEN)); // Trennzeichen
            //LOGGER.info(loadText);

            if (game == BuildaPanel.WHFB) {
                BuildaHQ.Items = new Vector<String>();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, BuildaHQ.translate("Datei konnte nicht gelesen werden."));
            OnlineCodex.getInstance().dokumentLeeren();
        }
//        }

//        loadXMLFile(new File(file.getAbsolutePath()));

        BuildaHQ.setLastLoaded(file.getName());
    }

    public void loadXMLFile(File file) {
        Document doc = BuildaHQ.loadXMLFile(file, true);

        loadElement = doc.getDocumentElement();
    }

}
