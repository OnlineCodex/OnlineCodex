package oc;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Formation implements BuildaSTK {



    public Vector<FormationEntry> entries = new Vector<FormationEntry>();

    public BuildaVater buildaVater;

    public JPanel controlPanel;

    public JLabel infoLabel = new JLabel();

    private final ActionListener formChangeListener = new ActionListener() {



        @Override

        public void actionPerformed(ActionEvent event) {

            final String entry = (String) ((JComboBox) event.getSource()).getSelectedItem();

            for (int i = 0; i < buildaVater.myChooserGruppen.size(); i++) {

                final int maxJ = buildaVater.myChooserGruppen.get(i).alleEinträge.length;

                for (int j = 0; j < maxJ; j++) {

                    if (((String) buildaVater.myChooserGruppen.get(i).alleEinträge[j]).equals(entry)) {

                        buildaVater.myChooserGruppen.get(i).mC.lastElement().selectEntryNotLocked(entry);

                    }

                }

            }



//			refresh();

        }

    };



    public Formation(BuildaVater buildaVater) {

        this.buildaVater = buildaVater;

    }



    public void refreshControlPanel() {

        if (controlPanel == null) {

            controlPanel = new JPanel(null, false);

        } else {

            controlPanel.removeAll();

        }



        buildaVater.getPanel().add(controlPanel);

        controlPanel.setBackground(Color.white);

        controlPanel.setBounds(10, 30, 255, (entries.size() + 1) * 25 + 5);



        buildaVater.getPanel().add(infoLabel);

        infoLabel.setBackground(Color.white);

        infoLabel.setBounds(10, (entries.size() + 1) * 25 + 40, 255, 200);



        final JLabel head = new JLabel("Formations-Check");

        head.setBounds(5, 5, 245, 20);



        controlPanel.add(head);





        for (int i = 0; i < entries.size(); i++) {

            entries.get(i).box.addActionListener(formChangeListener);

            controlPanel.add(entries.get(i).box);

            entries.get(i).box.setBounds(5, (i + 1) * 25 + 5, 195, 20);

            controlPanel.add(entries.get(i).minmaxLabel);

            entries.get(i).minmaxLabel.setBounds(205, (i + 1) * 25 + 5, 20, 20);

            entries.get(i).minmaxLabel.setBorder(BuildaHQ.createBorder(new Color(0, 0, 0)));



            entries.get(i).refreshCounts(buildaVater);



            controlPanel.add(entries.get(i).selLabel);

            entries.get(i).selLabel.setBounds(230, (i + 1) * 25 + 5, 20, 20);

            entries.get(i).selLabel.setBorder(BuildaHQ.createBorder(new Color(0, 0, 0)));

        }



        controlPanel.setBorder(BuildaHQ.createBorder(new Color(0, 150, 0)));

        infoLabel.setBorder(BuildaHQ.createBorder(new Color(0, 150, 0)));

        if (infoLabel.getText().equals("")) {

            infoLabel.setVisible(false);

        }



//		buildaVater.kontingentBox.setEnabled(false);

//		buildaVater.formationBox.setEnabled(false);

        RefreshListener.fireRefresh();

    }



    public void refresh() {

        for (int i = 0; i < entries.size(); i++) {

            entries.get(i).refreshCounts(buildaVater);

        }

    }



}

