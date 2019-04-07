package oc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class SaveTextWindow extends JDialog implements BuildaSTK {

    public static final String TOKEN = "###"; // Trennzeichen fuer Armeelistze in Maschinenformat und lesbares Format
    private static final long serialVersionUID = 1L;
    private String saveText = "";
    private final String saveTextAllies = "";
    private String armyList; // enthaelt die Armeeliste in Menschenlesbarer form.
    private final JFileChooser fc;

    public SaveTextWindow(JFrame owner, String currentDir) {
        super(owner, BuildaHQ.translate("Speichern"), true);

        if (BuildaHQ.getSprache() == Sprache.English) {
            Locale.setDefault(Locale.US);
        }

        fc = new JFileChooser(currentDir);

        fc.setDialogTitle(BuildaHQ.getSprache() == Sprache.German ? "Speichern" : "Save");
        fc.setApproveButtonText(BuildaHQ.getSprache() == Sprache.German ? "Speichern" : "Save");

        fc.setFileFilter(LoadWindow.OC_FILEFILER);

        fc.setSelectedFile(BuildaHQ.getLastLoaded() == null ? new File(".oc") : new File(BuildaHQ.getLastLoaded()));

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        fc.addPropertyChangeListener(e -> {
            if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(e.getPropertyName())) {
                OnlineCodex.getInstance().getPrefs().put(PREFERENCES_SAVE_DIRECTORY, getCurrentDir());
            }
        });
    }

    public String getCurrentDir() {
        return fc.getCurrentDirectory().getAbsolutePath();
    }

    public String getSaveText() {
        return saveText;
    }

    public void setSaveText(String saveText) {
        this.saveText = saveText;
    }

    public String getSaveTextAllies() {
        return saveTextAllies;
    }

    public void setArmyList(String armyList) {
        this.armyList = armyList;
    }

    public void save() {
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (Writer writer = new FileWriter(ensureFileExtension(fc.getSelectedFile(), "oc"))) {
                writer.append(BuildaPanel.budget.getText())
                        .append(";")
                        .append(getSaveTextAllies())
                        .append(";")
                        .append(getSaveText())
                        .append(TOKEN)
                        .append(armyList);
            } catch (final IOException e) {
                JOptionPane.showMessageDialog(null, BuildaHQ.translate("Datei konnte nicht gespeichert werden."));
            }
        }
    }

    private File ensureFileExtension(File file, String extension) {
        final String fileName = file.getName();
        if (!fileName.endsWith("." + extension)) {
            return new File(file.getParentFile(), fileName + "." + extension);
        } else {
            return file;
        }
    }
}