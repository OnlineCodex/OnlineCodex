package oc.wh40k.units.am;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class AMFaustdesImperatorsPanzer extends RuestkammerVater {

    OptionsEinzelUpgrade oe1;
    RuestkammerStarter t1;
    RuestkammerStarter t2;
    RuestkammerStarter t3;

    public AMFaustdesImperatorsPanzer() {
        name = "Leman-Russ-Schwadron";
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        add(ico = new oc.Picture("oc/wh40k/images/IGLemanRussSquadron.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Tarnnetze", 20));

        seperator();

        t1 = new RuestkammerStarter(ID, randAbstand, cnt, "AMLemanRuss", "", 1);
        t1.initKammer();
        t1.setButtonText("Kampfpanzer 1");
        add(t1);

        seperator();

        t2 = new RuestkammerStarter(ID, randAbstand, cnt, "AMLemanRuss", "", 1);
        t2.initKammer();
        t2.setButtonText("Kampfpanzer 2");
        add(t2);

        seperator();

        t3 = new RuestkammerStarter(ID, randAbstand, cnt, "AMLemanRuss", "", 1);
        t3.initKammer();
        t3.setButtonText("Kampfpanzer 3");
        add(t3);

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        int tanks = (t1.isSelected() ? 1 : 0) + (t2.isSelected() ? 1 : 0) + (t3.isSelected() ? 1 : 0);

        oe1.setPreis(tanks * 20);
        oe1.setAktiv(tanks > 0);

        t1.setAbwaehlbar(false);
        t2.setAbwaehlbar(false);
        t3.setAbwaehlbar(false);

    }

}
