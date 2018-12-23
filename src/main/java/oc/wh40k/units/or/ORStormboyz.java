package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORStormboyz extends Eintrag {

    private final AnzahlPanel stormboyz;
    private final RuestkammerStarter Boss;

    public ORStormboyz() {
        kategorie = 4;
        grundkosten = 0;

        add(stormboyz = new AnzahlPanel(ID, randAbstand, cnt, "Stormboyz", 5, 30, getPts("Stormboyz")));

        add(ico = new oc.Picture("oc/wh40k/images/Stormboyz.gif"));

        seperator();

        Boss = new RuestkammerStarter(ID, randAbstand, cnt, new ORWaffenUndGeschenke("no weapon", "no weapon", false, false, false, false, false, false, false, false), "Boss Nob");
        Boss.setUeberschriftTrotzNullKostenAusgeben(true);
        Boss.setGrundkosten(getPts("Boss Nob"));
        Boss.setAbwaehlbar(false);
        add(Boss);

        complete();
    }

    @Override
    public void refreshen() {
        Boss.setAbwaehlbar(true);
        if (stormboyz.getModelle() > 20) {
            power = 14;
        } else if (stormboyz.getModelle() > 10) {
            power = 9;
        } else if (stormboyz.getModelle() > 5) {
            power = 5;
        } else {
            power = 3;
        }
    }
}