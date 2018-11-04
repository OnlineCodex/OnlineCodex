package oc.wh40k.units.da;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DALandRaiderRedeemer extends Eintrag {

    OptionsEinzelUpgrade ia2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade oe3;

    public DALandRaiderRedeemer() {
        name = "Land Raider Redeemer";
        grundkosten = 240;

        add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderRedeemer.gif"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));

        complete();
    }

    @Override
    public void refreshen() {
    }
}