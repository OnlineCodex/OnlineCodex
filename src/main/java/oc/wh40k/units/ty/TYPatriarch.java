package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TYPatriarch extends Eintrag {

    OptionsZaehlerGruppe o1;

    public TYPatriarch() {
        name = "Patriarch";
        grundkosten = getPts("Patriarch") + getPts("Monstrous rending claws (GSC)");
        power = 7;

        ogE.addElement(new OptionsGruppeEintrag("Familiars", getPts("Familiars")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
