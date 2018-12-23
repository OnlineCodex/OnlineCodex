package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORLootas extends Eintrag {

    private final AnzahlPanel Pluenderaz;
    private final RuestkammerStarter Spanner1;
    private final RuestkammerStarter Spanner2;
    private final RuestkammerStarter Spanner3;

    public ORLootas() {
        grundkosten = 0;

        add(Pluenderaz = new AnzahlPanel(ID, randAbstand, cnt, "Lootas", 5, 15, getPts("Lootas") + getPts("Deffgun") + getPts("Stikkbombs")));
        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/Pluenderaz.gif"));

        ORWaffenUndGeschenke kammer0 = new ORWaffenUndGeschenke("no weapon", "Kustom mega-blasta", false, false, false, false, false, false, false, false);
        kammer0.setSpanner(true);
        Spanner1 = new RuestkammerStarter(ID, randAbstand, cnt, kammer0, "Spanner");
        Spanner1.setGrundkosten(getPts("Spanner"));
        add(Spanner1);

        seperator();

        ORWaffenUndGeschenke kammer1 = new ORWaffenUndGeschenke("no weapon", "Kustom mega-blasta", false, false, false, false, false, false, false, false);
        kammer1.setSpanner(true);
        Spanner2 = new RuestkammerStarter(ID, randAbstand, cnt, kammer1, "Spanner");
        Spanner2.setGrundkosten(getPts("Spanner"));
        add(Spanner2);

        seperator();

        ORWaffenUndGeschenke kammer2 = new ORWaffenUndGeschenke("no weapon", "Kustom mega-blasta", false, false, false, false, false, false, false, false);
        kammer2.setSpanner(true);
        Spanner3 = new RuestkammerStarter(ID, randAbstand, cnt, kammer2, "Spanner");
        Spanner3.setGrundkosten(getPts("Spanner"));
        add(Spanner3);

        complete();
    }

    @Override
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
