package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORStormboyz extends Eintrag {

    AnzahlPanel stormboyz;
    RuestkammerStarter Boss;

    public ORStormboyz() {

        grundkosten = 0;

        add(stormboyz = new AnzahlPanel(ID, randAbstand, cnt, "Stormboyz", 5, 30, getPts("Stormboyz")));

        add(ico = new oc.Picture("oc/wh40k/images/Stormboyz.gif"));

        seperator();

        Boss = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "Boss Nob");
        ((ORWaffenUndGeschenke) Boss.getKammer()).setBoyBoss(true);
        ((ORWaffenUndGeschenke) Boss.getKammer()).setDefaultRanged("no weapon");
        ((ORWaffenUndGeschenke) Boss.getKammer()).setDefaultCloceCombat("no weapon");
        Boss.initKammer(false, false, false, false, false);
        Boss.setUeberschriftTrotzNullKostenAusgeben(true);
        Boss.setGrundkosten(getPts("Boss Nob"));
        add(Boss);
        Boss.setAbwaehlbar(false);

        complete();
    }


    //@OVERRIDE
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
