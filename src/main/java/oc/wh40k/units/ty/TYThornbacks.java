package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYThornbacks extends Eintrag {

    AnzahlPanel squad;
    RuestkammerStarter ob1, ob2, ob3;

    public TYThornbacks() {
        name = "Thornbacks";
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/TYCarnifex.jpg"));

        ob1 = new RuestkammerStarter(ID, randAbstand, cnt, "TYRuestkammer", "Thornback");
        ((TYRuestkammer) ob1.getKammer()).setType("Thornback");
        ob1.initKammer();
        add(ob1);
        ob1.setGrundkosten(getPts("Thornbacks"));
        ob1.setAbwaehlbar(false);

        seperator();

        ob2 = new RuestkammerStarter(ID, randAbstand, cnt, "TYRuestkammer", "Thornback");
        ((TYRuestkammer) ob2.getKammer()).setType("Thornback");
        ob2.initKammer();
        ob2.setGrundkosten(getPts("Thornbacks"));
        add(ob2);

        seperator();

        ob3 = new RuestkammerStarter(ID, randAbstand, cnt, "TYRuestkammer", "Thornback");
        ((TYRuestkammer) ob3.getKammer()).setType("Thornback");
        ob3.initKammer();
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
