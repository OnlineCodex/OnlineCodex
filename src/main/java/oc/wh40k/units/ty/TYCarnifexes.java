package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYCarnifexes extends Eintrag {

    private final RuestkammerStarter ob2;
    private final RuestkammerStarter ob3;

    public TYCarnifexes() {
        name = "Carnifex-Rotte";
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/TYCarnifex.jpg"));

        RuestkammerStarter ob1 = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer("Carnifex"), "Carnifex");
        ob1.setGrundkosten(getPts("Carnifex"));
        ob1.setAbwaehlbar(false);
        add(ob1);

        seperator();

        ob2 = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer("Carnifex"), "Carnifex");
        ob2.setGrundkosten(getPts("Carnifex"));
        add(ob2);

        seperator();

        ob3 = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer("Carnifex"), "Carnifex");
        ob3.setGrundkosten(getPts("Carnifex"));
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
