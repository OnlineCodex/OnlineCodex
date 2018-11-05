package oc.wh40k.units.dw;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DWLandRaider extends Eintrag {

    boolean chronusSelected = false;

    public DWLandRaider() {
        name = "Land Raider";
        grundkosten = 250;

        add(ico = new oc.Picture("oc/wh40k/images/SMLandRaider.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));

        complete();
    }

    @Override
    public void refreshen() {

    }

    @Override
    public void deleteYourself() {

        super.deleteYourself();
    }

}
