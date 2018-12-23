package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMLemanRussDemolishers extends Eintrag {

    private final RuestkammerStarter t1;
    private final RuestkammerStarter t2;
    private final RuestkammerStarter t3;

    public IMLemanRussDemolishers() {
        name = "Leman Russ Battle Tanks";
        grundkosten = 0;
        this.überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/IGLemanRussSquadron.jpg"));

        seperator();

        t1 = new RuestkammerStarter(ID, randAbstand, cnt, new IMLemanRussDemolisher(), "", 1);
        t1.setButtonText("Tank 1");
        add(t1);

        seperator();

        t2 = new RuestkammerStarter(ID, randAbstand, cnt, new IMLemanRussDemolisher(), "", 1);
        t2.setButtonText("Tank 2");
        add(t2);

        seperator();

        t3 = new RuestkammerStarter(ID, randAbstand, cnt, new IMLemanRussDemolisher(), "", 1);
        t3.setButtonText("Tank 3");
        add(t3);

        complete();
    }

    @Override
    public void refreshen() {
        power = 11 * ((t1.isSelected() ? 1 : 0) + (t2.isSelected() ? 1 : 0) + (t3.isSelected() ? 1 : 0));
    }
}