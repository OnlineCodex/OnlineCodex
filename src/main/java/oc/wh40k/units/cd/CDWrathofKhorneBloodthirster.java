package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDWrathofKhorneBloodthirster extends Eintrag {


    public CDWrathofKhorneBloodthirster() {

        name = "Wrath Of Khorne Bloodthirster";
        grundkosten = getPts("Wrath Of Khorne Bloodthirster");
        power = 17;
        complete();

    }

    @Override
    public void refreshen() {
    }
}
