//IA Adeptus Astartes + FAQ 1.2
package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMRelicFalchionSuperheavyTankDestroyer extends Eintrag {

    OptionsZaehlerGruppe o1, o2, o3;

    public IMRelicFalchionSuperheavyTankDestroyer() {
        name = "Relic Falchion Super-heavy Tank Destroyer";
        grundkosten = getPts("Relic Falchion Super-heavy Tank Destroyer") + getPts("Twin volcano cannon") + getPts("Crushing tracks");
        power = 40;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 quad lascannon", 2 * getPts("Quad lascannon")));
        ogE.addElement(new OptionsGruppeEintrag("2 laser destroyers", 2 * getPts("Laser destroyer")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Twin heavy flamer", 2 * getPts("Twin heavy flamer")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (IA)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 2 * getPts("Heavy flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 2 * getPts("Storm bolter (IA)")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }
}
