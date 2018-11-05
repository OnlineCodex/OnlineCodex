package oc.wh40k.units.or;

import oc.*;

public class ORKommandos extends Eintrag {

    AnzahlPanel kommandoz;
    OptionsZaehlerGruppe kommandozFK;
    RuestkammerStarter boss;

    public ORKommandos() {
        kategorie = 2;
        grundkosten = 0;

        kommandoz = new AnzahlPanel(ID, randAbstand, cnt, "Kommandos", 5, 15, getPts("Kommandos"));
        add(kommandoz);

        add(ico = new oc.Picture("oc/wh40k/images/Kommandoz.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Burna", getPts("Burna")));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
        add(kommandozFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        boss = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Boss Nob");
        ((ORWaffenUndGeschenke) boss.getKammer()).setDefaultNK("Power klaw");
        ((ORWaffenUndGeschenke) boss.getKammer()).setDefaultFK("Slugga");
        boss.initKammer(false, false, false, false, false);
        boss.setGrundkosten(getPts("Boss Nob"));
        boss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(boss);
        boss.setAbwaehlbar(false);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        boss.setAbwaehlbar(true);
        if (kommandoz.getModelle() > 10) {
            power = 6;
        } else if (kommandoz.getModelle() > 5) {
            power = 4;
        } else {
            power = 2;
        }
    }

}
