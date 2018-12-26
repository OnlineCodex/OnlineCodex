package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHChaosBastions extends Eintrag {

    OptionsUpgradeGruppe fkwaffen;

    public CHChaosBastions() {

        name = "Chaos Bastions";
        grundkosten = getPts("Chaos Bastions");

        ogE.addElement(new OptionsGruppeEintrag("Icarus lascannon", getPts("Icarus lascannon")));
        ogE.addElement(new OptionsGruppeEintrag("Quad-gun", getPts("Quad-gun")));
        add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        power = 10;

        complete();
    }


    @Override
    public void refreshen() {

    }
}
