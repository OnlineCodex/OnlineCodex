package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsZaehlerGruppe;

public class ORMegatrakkScrapjet extends Eintrag {

    AnzahlPanel buggies;
    OptionsZaehlerGruppe BuggiesFK;
    OptionsZaehlerGruppe BuggiesFKx;

    public ORMegatrakkScrapjet() {

        kategorie = 4;
        grundkosten = 0;

        buggies = new AnzahlPanel(ID, randAbstand, cnt, "Megatrakk Scrapjet", "Megatrakk Scrapjets", 1, 3, getPts("Megatrakk Scrapjets") + getPts("Twin big shoota") * 2);
        add(buggies);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        power = buggies.getModelle() * 5;
    }
}
