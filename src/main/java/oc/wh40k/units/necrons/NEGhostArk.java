package oc.wh40k.units.necrons;


import oc.Eintrag;

public class NEGhostArk extends Eintrag {


    public NEGhostArk() {
        name = "Ghost Ark";
        grundkosten = getPts("Ghost Ark") + getPts("Gauss flayer array") * 2;

        add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));

        seperator();


        complete();
    }

    @Override
    public void refreshen() {
        power = 8;
    }

}
