package oc.wh40k.units.or;

import oc.*;

public class ORDeffDreads extends Eintrag {

    private final RuestkammerStarter d1;
    private final RuestkammerStarter d2;
    private final RuestkammerStarter d3;

    public ORDeffDreads() {
        name = "Deff Dreads";
        grundkosten = 0;
        grundkosten = 0;

        kategorie = 3;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/Gargbot.gif"));

        d1 = new RuestkammerStarter(ID, randAbstand, cnt, new ORDeffDreadKammer(), "Deff Dread ", 1);
        d1.setButtonText("Deff Dread 1");
        d1.setAbwaehlbar(false);
        add(d1);

        seperator();

        d2 = new RuestkammerStarter(ID, randAbstand, cnt, new ORDeffDreadKammer(), "Deff Dread ", 1);
        d2.setButtonText("Deff Dread 2");
        add(d2);

        seperator();

        d3 = new RuestkammerStarter(ID, randAbstand, cnt, new ORDeffDreadKammer(), "Deff Dread ", 1);
        d3.setButtonText("Deff Dread 3");
        add(d3);

        complete();
    }

    @Override
    public void refreshen() {
        int selected = (d1.isSelected() ? 1 : 0) + (d2.isSelected() ? 1 : 0) + (d3.isSelected() ? 1 : 0);
        if (selected == 1) power = 5;
        if (selected == 2) power = 10;
        if (selected == 3) power = 16;
    }
}