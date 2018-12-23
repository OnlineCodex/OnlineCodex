package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYStonecrusherCarnifexBrood extends Eintrag {

    public TYStonecrusherCarnifexBrood() {
        name = "Stonecrusher Carnifex Brood";
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/TYCarnifex.jpg"));

        RuestkammerStarter ob1 = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer("Stonecrusher Carnifex"), "Stonecrusher Carnifex");
        ob1.setGrundkosten(getPts("Stonecrusher Carnifex"));
        ob1.setAbwaehlbar(false);
        add(ob1);

        seperator();

        RuestkammerStarter ob2 = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer("Stonecrusher Carnifex"), "Stonecrusher Carnifex");
        ob2.setGrundkosten(getPts("Stonecrusher Carnifex"));
        add(ob2);

        seperator();

        RuestkammerStarter ob3 = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer("Stonecrusher Carnifex"), "Stonecrusher Carnifex");
        ob3.setGrundkosten(getPts("Stonecrusher Carnifex"));
        add(ob3);

        complete();
    }
}
