package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORDeffkoptas extends Eintrag {

    AnzahlPanel killakoptaz;
    OptionsZaehlerGruppe killakoptazFKx;
    OptionsZaehlerGruppe killakoptazFK;

    public ORDeffkoptas() {

        kategorie = 4;
        grundkosten = 0;

        add(killakoptaz = new AnzahlPanel(ID, randAbstand, cnt, "Deffkopta", "Deffkoptas", 1, 5, getPts("Deffkoptas") + getPts("Spinnin' blades")));
        add(ico = new oc.Picture("oc/wh40k/images/Killakoptaz.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kopta rokkits", getPts("Kopta rokkits")));
        add(killakoptazFKx = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Twin big shoota", getPts("Twin big shoota")));
        add(killakoptazFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));


        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        killakoptazFKx.setMaxAnzahl(killakoptaz.getModelle() - killakoptazFK.getAnzahl());
        killakoptazFKx.setAnzahl(0, killakoptaz.getModelle() - killakoptazFK.getAnzahl());
        killakoptazFK.setMaxAnzahl(killakoptaz.getModelle());
        if (killakoptaz.getModelle() > 3) {
            power = 8;
        } else if (killakoptaz.getModelle() > 1) {
            power = 5;
        } else {
            power = 2;
        }
    }
}
