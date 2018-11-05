package oc.wh40k.units.dh;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DHTodessichel extends Eintrag {

    public DHTodessichel() {
        name = "Todessichel";
        grundkosten = 175;

        add(ico = new oc.Picture("oc/wh40k/images/NETodessichel.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fliegerass", 50));


        complete();
    }

    @Override
    public void refreshen() {
    }

}
