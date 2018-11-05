package oc.wh40k.units.ne;


import oc.Eintrag;

public class NENightScythe extends Eintrag {


    public NENightScythe() {
        name = "Night Scythe";
        grundkosten = getPts("Night Scythe") + getPts("Tesla destructor") * 2;

        add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));

        seperator();


        complete();
    }

    @Override
    public void refreshen() {
        power = 8;
    }
}
