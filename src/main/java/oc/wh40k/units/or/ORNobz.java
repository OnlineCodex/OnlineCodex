package oc.wh40k.units.or;

import oc.*;

public class ORNobz extends Eintrag {

    AnzahlPanel Bosse;
    OptionsZaehlerGruppe BosseCC;
    OptionsZaehlerGruppe BosseFK;
    OptionsEinzelZaehler Munigrotz;
    OptionsEinzelZaehler Cyborg;

    public ORNobz() {
        kategorie = 2;
        grundkosten = 0;

        Bosse = new AnzahlPanel(ID, randAbstand, cnt, "Nobz", 5, 10, getPts("Nobz") + getPts("Stikkbombs"));
        add(Bosse);

        add(ico = new oc.Picture("oc/wh40k/images/Bosse.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Choppa", getPts("Choppa")));
        ogE.addElement(new OptionsGruppeEintrag("Killsaw", getPts("Killsaw")));
        ogE.addElement(new OptionsGruppeEintrag("Power stabba", getPts("Power stabba")));
        ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
        ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
        ogE.addElement(new OptionsGruppeEintrag("Slugga", getPts("Slugga")));
        add(BosseCC = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        BosseCC.setAnzahl(0, Bosse.getModelle());
        BosseCC.setAnzahl(5, Bosse.getModelle());

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit", "Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha")));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
        add(BosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator(5);

        add(Munigrotz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Ammo Runt", Bosse.getModelle(), getPts("Ammo Runt")));

        seperator(5);

        add(Cyborg = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Cybork body", Bosse.getModelle() / 5, getPts("Cybork body")));

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        BosseCC.setMaxAnzahl(Bosse.getModelle() * 2);
        BosseFK.setMaxAnzahl(Bosse.getModelle());

        boolean legal = (BosseCC.getAnzahl() + BosseFK.getAnzahl() * 2) == Bosse.getModelle() * 2;
        BosseCC.setLegal(legal);
        BosseFK.setLegal(legal);

        Munigrotz.setMaxAnzahl(Bosse.getModelle());

        Cyborg.setMaxAnzahl(Bosse.getModelle() / 5);

        if (Bosse.getModelle() > 5) {
            power = 14;
        } else {
            power = 7;
        }
    }

}
