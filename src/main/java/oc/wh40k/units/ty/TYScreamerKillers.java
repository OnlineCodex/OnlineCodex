package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYScreamerKillers extends Eintrag {

    private final RuestkammerStarter ob1, ob2, ob3;

    public TYScreamerKillers() {
        name = "Screamer-Killers";
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/TYCarnifex.jpg"));

        ob1 = new RuestkammerStarter(ID, randAbstand, cnt, TYRuestkammer.class, "Screamer-Killer");
        ((TYRuestkammer) ob1.getKammer()).setType("Screamer-Killer");
        ob1.initKammer();
        add(ob1);
        ob1.setGrundkosten(getPts("Screamer-Killers"));
        ob1.setAbwaehlbar(false);

        seperator();

        ob2 = new RuestkammerStarter(ID, randAbstand, cnt, TYRuestkammer.class, "Screamer-Killer");
        ((TYRuestkammer) ob2.getKammer()).setType("Screamer-Killer");
        ob2.initKammer();
        ob2.setGrundkosten(getPts("Screamer-Killers"));
        add(ob2);

        seperator();

        ob3 = new RuestkammerStarter(ID, randAbstand, cnt, TYRuestkammer.class, "Screamer-Killer");
        ((TYRuestkammer) ob3.getKammer()).setType("Screamer-Killer");
        ob3.initKammer();
        ob3.setGrundkosten(getPts("Screamer-Killers"));
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
