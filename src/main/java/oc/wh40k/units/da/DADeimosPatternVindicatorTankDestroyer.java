package oc.wh40k.units.da;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DADeimosPatternVindicatorTankDestroyer extends Eintrag {


    public DADeimosPatternVindicatorTankDestroyer() {
        name = "Deimos Pattern Vindicator Tank Destroyer";
        grundkosten = 130;
        add(ico = new oc.Picture("oc/wh40k/images/SMVindicator.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Siege Shield", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
