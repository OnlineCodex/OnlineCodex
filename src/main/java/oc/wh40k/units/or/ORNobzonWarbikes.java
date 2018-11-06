package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORNobzonWarbikes extends Eintrag {

    AnzahlPanel Bosse;
    OptionsZaehlerGruppe BosseCC;

    public ORNobzonWarbikes() {
        kategorie = 2;
        grundkosten = 0;

        Bosse = new AnzahlPanel(ID, randAbstand, cnt, "Nobz", 3, 9, getPts("Nobz on Warbikes") + getPts("Stikkbombs"));
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

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        BosseCC.setMaxAnzahl(Bosse.getModelle() * 2);

        if (Bosse.getModelle() > 6) {
            power = 19;
        } else if (Bosse.getModelle() > 3) {
            power = 14;
        } else {
            power = 7;
        }

    }

}
