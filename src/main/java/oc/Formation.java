package oc;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.Objects;
import java.util.Vector;

import static com.google.common.collect.Iterables.getLast;

public class Formation implements BuildaSTK {

    private Vector<FormationEntry> entries = new Vector<>();
    public BuildaVater buildaVater;
    private JPanel controlPanel;
    private JLabel infoLabel = new JLabel();

    private ActionListener formChangeListener = (ActionEvent event) ->{
        String entry = (String) ((JComboBox) event.getSource()).getSelectedItem();
        for (int i = 0; i < buildaVater.myChooserGruppen.size(); i++) {
            ChooserGruppe chooserGruppe = buildaVater.myChooserGruppen.get(i);

            chooserGruppe.alleEinträge.stream()
                    .filter(entry::equals)
                    .forEach(e -> getLast(chooserGruppe.mC).selectEntryNotLocked(entry));
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
        JLabel head = new JLabel("Formations-Check");
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

        RefreshListener.fireRefresh();
    }

    public void refresh() {
        for (int i = 0; i < entries.size(); i++) {
            entries.get(i).refreshCounts(buildaVater);
        }
    }
}