package oc.wh40k.units.hhca;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class HHCALegionCaestusAssaultRam extends Eintrag {

    OptionsUpgradeGruppe o1;

    public HHCALegionCaestusAssaultRam() {
        name = "Legion Caestus Assault Ram";
        grundkosten = 305;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Auxiliary drive", 10));
        ogE.addElement(new OptionsGruppeEintrag("Frag assault launchers", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

        complete();
    }

    @Override
    public void refreshen() {

    }

}
