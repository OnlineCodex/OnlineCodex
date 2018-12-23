package oc;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class FormationEntry {

    JComboBox box;
    private String[] entries;
    private int min;
    private int max;
    private int sel;
    JLabel minmaxLabel;
    JLabel selLabel;

    public FormationEntry(String[] entries, int min, int max) {
        this.entries = entries;
        box = new JComboBox(entries);
        this.min = min;
        this.max = max;
        if (min == max) {
            minmaxLabel = new JLabel("" + min);
        } else if (max == Integer.MAX_VALUE) {
            minmaxLabel = new JLabel("" + min + "+");
        } else {
            minmaxLabel = new JLabel(min + "-" + max);
        }
        selLabel = new JLabel("0");
    }

    public void refreshCounts(BuildaVater buildaVater) {
        sel = 0;
        for (int i = 0; i < buildaVater.myChooserGruppen.size(); i++) {
            ChooserGruppe chooserGruppe = buildaVater.myChooserGruppen.get(i);
            int maxJ = chooserGruppe.getmC().size();
            for (int j = 0; j < maxJ; j++) {
                for (int k = 0; k < entries.length; k++) {
                    String entry = entries[k];
                    if (Objects.equals(chooserGruppe.getmC().get(j).selectedEntry(), entry)) {
                        sel++;
                    }
                }
            }
        }
        selLabel.setText("" + sel);

        if (sel < min || sel > max) {
            selLabel.setForeground(Color.red);
            if (sel > max && buildaVater.fcountBool) {
                selLabel.setForeground(Color.black);
            }
        } else {
            selLabel.setForeground(Color.black);
        }

        if (buildaVater.fcountBool && buildaVater.fcount != sel) {
            buildaVater.fcount = sel;
            RefreshListener.fireRefresh();
        }
    }
}