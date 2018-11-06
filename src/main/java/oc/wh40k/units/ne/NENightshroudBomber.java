package oc.wh40k.units.ne;


import oc.Eintrag;

public class NENightshroudBomber extends Eintrag {

    public NENightshroudBomber() {
        name = "Nightshroud Bomber";
        grundkosten = 225;

        add(ico = new oc.Picture("oc/wh40k/images/NETodessichel.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
