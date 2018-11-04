//IA Adeptus Astartes
package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMSiegeDreadnought extends Eintrag {

    OptionsZaehlerGruppe o1, o2;

    public IMSiegeDreadnought() {
        name = "Siege Dreadnought";
        grundkosten = getPts("Siege Dreadnought");
        power = 10;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Dreadnought inferno cannon", getPts("Dreadnought inferno cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        ogE.addElement(new OptionsGruppeEintrag("Twin autocannon", getPts("Twin autocannon")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Seismic hammer and meltagun", getPts("Seismic hammer") + getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Dreadnought inferno cannon", getPts("Dreadnought inferno cannon")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }
}
