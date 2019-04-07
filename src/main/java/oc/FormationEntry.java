package oc;



import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;



public class FormationEntry {



    JComboBox box;

    String[] entries;

    int min;

    int max;

    int sel;

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

            final int maxJ = buildaVater.myChooserGruppen.get(i).getmC().size();

            for (int j = 0; j < maxJ; j++) {

                for (int k = 0; k < entries.length; k++) {

                    final String entry = entries[k];

                    if (buildaVater.myChooserGruppen.get(i).getmC().get(j).selectedEntry().equals(entry)) {

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



        if (buildaVater.fcountBool) {

            if (buildaVater.fcount != sel) {

                buildaVater.fcount = sel;

                RefreshListener.fireRefresh();

            }

        }

    }



}

