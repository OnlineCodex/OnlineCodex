package oc.wh40k.units.or;

import oc.*;

public class ORWarbikers extends Eintrag {

    private final AnzahlPanel waaghbikaz;
    private final RuestkammerStarter Boss;
    private final OptionsEinzelZaehler sluggas;
    private final OptionsEinzelZaehler choppas;
    private final OptionsEinzelZaehler stikks;

    public ORWarbikers() {
        grundkosten = 0;

        kategorie = 4;

        add(waaghbikaz = new AnzahlPanel(ID, randAbstand, cnt, "Warbikers", 3, 12, getPts("Warbikers")));
        add(ico = new oc.Picture("oc/wh40k/images/Waaghbike.gif"));

        seperator();

        add(sluggas = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Slugga", waaghbikaz.getModelle(), getPts("Slugga")));
        add(choppas = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Choppa", waaghbikaz.getModelle(), getPts("Choppa")));
        add(stikks = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Stikkbombs", waaghbikaz.getModelle(), getPts("Stikkbombs")));

        seperator();

        ORWaffenUndGeschenke kammer = new ORWaffenUndGeschenke("no weapon", "no weapon", false, false, false, false, false, false, false, false);
        kammer.setWarbikerBoss(true);
        Boss = new RuestkammerStarter(ID, randAbstand, cnt, kammer, "Boss Nob");
        Boss.setUeberschriftTrotzNullKostenAusgeben(true);
        Boss.setGrundkosten(getPts("Boss Nob"));
        Boss.setAbwaehlbar(false);
        add(Boss);

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
