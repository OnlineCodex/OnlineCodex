package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class CHFleshHounds extends Eintrag {

    AnzahlPanel hounds;
    OptionsZaehlerGruppe gorehounds;

    public CHFleshHounds() {

        name = "Flesh Hounds";
        grundkosten = 0;
        power = 5;

        add(hounds = new AnzahlPanel(ID, randAbstand, cnt, "Flesh Hounds", 5, 20, getPts("Flesh Hounds")));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Gore Hounds", getPts("Gore Hounds") - getPts("Flesh Hounds")));
        add(gorehounds = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        
        seperator();
        
        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = 4 +
                ((hounds.getModelle() > 5) ? 4 : 0) +
                ((hounds.getModelle() > 10) ? 4 : 0) +
                ((hounds.getModelle() > 15) ? 4 : 0);
        
        gorehounds.setMaxAnzahl(hounds.getModelle()/5);
    }
}
