package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class AEBeastmaster extends Eintrag {

    OptionsEinzelUpgrade oe1;
    OptionsZaehlerGruppe o1, o2;

    public AEBeastmaster() {
        name = "Beastmaster";
        grundkosten = getPts("Beastmaster") + getPts("Splinter pods");
        power = 3;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (Drukhari)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }
}
