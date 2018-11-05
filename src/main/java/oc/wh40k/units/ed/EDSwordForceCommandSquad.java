package oc.wh40k.units.ed;

import oc.Eintrag;

public class EDSwordForceCommandSquad extends Eintrag {

    public EDSwordForceCommandSquad() {
        name = "Sword Force Command Squad";
        grundkosten = 125;


        add(ico = new oc.Picture("oc/wh40k/images/SwordForceCommandSquad.jpg"));


        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
