package oc.wh40k.units.or;

import oc.*;

public class ORWarbikers extends Eintrag {

    AnzahlPanel waaghbikaz;
    OptionsEinzelUpgrade trophäenstange;
    RuestkammerStarter Boss;
    OptionsEinzelZaehler sluggas;
    OptionsEinzelZaehler choppas;
    OptionsEinzelZaehler stikks;

    public ORWarbikers() {

        kategorie = 4;
        grundkosten = 0;
        add(waaghbikaz = new AnzahlPanel(ID, randAbstand, cnt, "Warbikers", 3, 12, getPts("Warbikers")));
        add(ico = new oc.Picture("oc/wh40k/images/Waaghbike.gif"));

        seperator();

        add(sluggas = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Slugga", waaghbikaz.getModelle(), getPts("Slugga")));
        add(choppas = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Choppa", waaghbikaz.getModelle(), getPts("Choppa")));
        add(stikks = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Stikkbombs", waaghbikaz.getModelle(), getPts("Stikkbombs")));

        seperator();

        Boss = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "Boss Nob");
        ((ORWaffenUndGeschenke) Boss.getKammer()).setWarbikerBoss(true);
        ((ORWaffenUndGeschenke) Boss.getKammer()).setDefaultRanged("no weapon");
        ((ORWaffenUndGeschenke) Boss.getKammer()).setDefaultCloceCombat("no weapon");
        Boss.initKammer(false, false, false, false, false);
        Boss.setUeberschriftTrotzNullKostenAusgeben(true);
        Boss.setGrundkosten(getPts("Boss Nob"));
        add(Boss);
        Boss.setAbwaehlbar(false);

        complete();

    }

    @Override
    public void refreshen() {
        sluggas.setMaxAnzahl(waaghbikaz.getModelle() - (Boss.isSelected() ? 1 : 0));
        choppas.setMaxAnzahl(waaghbikaz.getModelle() - (Boss.isSelected() ? 1 : 0));
        stikks.setMaxAnzahl(waaghbikaz.getModelle());


        Boss.setAbwaehlbar(true);
        if (waaghbikaz.getModelle() > 9) {
            power = 14;
        } else if (waaghbikaz.getModelle() > 6) {
            power = 11;
        } else if (waaghbikaz.getModelle() > 3) {
            power = 7;
        } else {
            power = 4;
        }
    }
}
