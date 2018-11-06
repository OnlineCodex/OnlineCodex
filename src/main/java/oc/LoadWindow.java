package oc;

import org.w3c.dom.Element;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class LoadWindow extends JPanel {

    private static final long serialVersionUID = 4239397313985019958L;
    private static final Predicate<String> FILE_NAME_REGEX = Pattern.compile("^.*\\.oc[a-z]*$").asPredicate();
    public static final FileFilter OC_FILEFILER = new FileFilter() {

        @Override
        public boolean accept(File f) {
            return f.isDirectory() || FILE_NAME_REGEX.test(f.getName().toLowerCase());
        }

        @Override
        public String getDescription() {
            return BuildaHQ.translate("oc* Dateien");
        }
    };

    private JFileChooser fc;
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

        fc.setFileFilter(OC_FILEFILER);
    }

    public String getLoadText() {
        return loadText;
    }

    public Element getLoadElement() {
        return loadElement;
    }

    public String getCurrentDir() {
        return fc.getCurrentDirectory().getAbsolutePath();
    }

    public void load() {
        int returnVal = fc.showOpenDialog(LoadWindow.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            loadFile(file);
        }
    }

    public void loadFile(File file) {
        try (FileReader leser = new FileReader(file)) {
            String text = "";
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

            loadText = tokenizer.nextToken();
            loadText = loadText.substring(0, loadText.indexOf(SaveTextWindow.TOKEN));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, BuildaHQ.translate("Datei konnte nicht gelesen werden."));
            OnlineCodex.getInstance().dokumentLeeren();
        }
        BuildaHQ.setLastLoaded(file.getName());
    }
}
