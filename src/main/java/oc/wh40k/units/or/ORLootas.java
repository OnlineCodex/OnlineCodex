package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORLootas extends Eintrag {

    AnzahlPanel Pluenderaz;
    RuestkammerStarter Spanner1;
    RuestkammerStarter Spanner2;
    RuestkammerStarter Spanner3;

    public ORLootas() {

        //kategorie = 2;

        grundkosten = 0;
        add(Pluenderaz = new AnzahlPanel(ID, randAbstand, cnt, "Lootas", 5, 15, getPts("Lootas") + getPts("Deffgun") + getPts("Stikkbombs")));
        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/Pluenderaz.gif"));

        Spanner1 = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Spanner");
        ((ORWaffenUndGeschenke) Spanner1.getKammer()).setSpanner(true);
        ((ORWaffenUndGeschenke) Spanner1.getKammer()).setDefaultNK("no weapon");
        ((ORWaffenUndGeschenke) Spanner1.getKammer()).setDefaultFK("Kustom mega-blasta");
        Spanner1.initKammer(false, false, false, false, false, false);
        Spanner1.setGrundkosten(getPts("Spanner"));
        add(Spanner1);

        seperator();

        Spanner2 = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Spanner");
        ((ORWaffenUndGeschenke) Spanner2.getKammer()).setSpanner(true);
        ((ORWaffenUndGeschenke) Spanner2.getKammer()).setDefaultNK("no weapon");
        ((ORWaffenUndGeschenke) Spanner2.getKammer()).setDefaultFK("Kustom mega-blasta");
        Spanner2.initKammer(false, false, false, false, false, false);
        Spanner2.setGrundkosten(getPts("Spanner"));
        add(Spanner2);

        seperator();

        Spanner3 = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Spanner");
        ((ORWaffenUndGeschenke) Spanner3.getKammer()).setSpanner(true);
        ((ORWaffenUndGeschenke) Spanner3.getKammer()).setDefaultNK("no weapon");
        ((ORWaffenUndGeschenke) Spanner3.getKammer()).setDefaultFK("Kustom mega-blasta");
        Spanner3.initKammer(false, false, false, false, false, false);
        Spanner3.setGrundkosten(getPts("Spanner"));
        add(Spanner3);

        complete();

    }


    //@OVERRIDE
    public void refreshen() {
        if (Pluenderaz.getModelle() > 10) {
            power = 13;
        } else if (Pluenderaz.getModelle() > 5) {
            power = 8;
        } else {
            power = 4;
        }

        Spanner2.setAktiv(Pluenderaz.getModelle() >= 10);
        Spanner3.setAktiv(Pluenderaz.getModelle() == 15);
    }
}
