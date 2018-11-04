package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORMeganobz extends Eintrag {

    AnzahlPanel gargbosse;
    OptionsZaehlerGruppe gargbosseFK;

    public ORMeganobz() {

        grundkosten = 0;
        name = "Meganobz";

        add(gargbosse = new AnzahlPanel(ID, randAbstand, cnt, "Meganobz", 3, 10, getPts("Meganobz") + getPts("Stikkbombs")));

        add(ico = new oc.Picture("oc/wh40k/images/Gargbosse.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kustum Shoota + Klaw", getPts("Kustom Shoota") + getPts("Power Klaw")));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit + Klaw", getPts("Kombi-weapon with rokkit-launcha") + getPts("Power Klaw")));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha + Klaw", getPts("Kombi-weapon with skorcha") + getPts("Power Klaw")));
        ogE.addElement(new OptionsGruppeEintrag("Two killsaws", getPts("Two killsaws")));
        add(gargbosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, gargbosse.getModelle()));
        gargbosseFK.setAnzahl(0, gargbosse.getModelle());

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        gargbosseFK.setMaxAnzahl(gargbosse.getModelle());
        gargbosseFK.setLegal(gargbosseFK.getAnzahl() == gargbosse.getModelle());
        power = gargbosse.getModelle() * 2;
    }
}
