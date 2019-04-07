package oc;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class ComingSoon extends Eintrag {

    public ComingSoon() {
        name = "ComingSoon";
        grundkosten = 0;

        add(new Picture("oc/images/ComingSoon.gif"));

        this.setEintragsCNT(0);
        final JLabel l = new JLabel("C o m i n g   s o o n  . . .");
        l.setFont(new Font("arial", Font.BOLD, 16));
        l.setBounds(60, 75, 200, 18);
        l.setForeground(Color.BLACK);
        this.panel.add(l);

        seperator(25);

        this.add(new OptionsEinzelUpgrade(ID, -888, cnt, "", "bla", 11));

        setKostenLabelVisible(false);

        complete();

    }

    @Override
    public void refreshen() {
    }

}