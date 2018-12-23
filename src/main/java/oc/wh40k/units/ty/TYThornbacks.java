package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYThornbacks extends Eintrag {

    private final RuestkammerStarter ob2;
    private final RuestkammerStarter ob3;

    public TYThornbacks() {
        name = "Thornbacks";
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/TYCarnifex.jpg"));

        RuestkammerStarter ob1 = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer("Thornback"), "Thornback");
        ob1.setGrundkosten(getPts("Thornbacks"));
        ob1.setAbwaehlbar(false);
        add(ob1);

        seperator();

        ob2 = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer("Thornback"), "Thornback");
        ob2.setGrundkosten(getPts("Thornbacks"));
        add(ob2);

        seperator();

        ob3 = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer("Thornback"), "Thornback");
        ob3.setGrundkosten(getPts("Thornbacks"));
        add(ob3);

        complete();
    }

    @Override
    public void refreshen() {
        power = 6;
        if (ob2.isSelected())
            power += 6;
        if (ob3.isSelected())
            power += 6;
    }
}