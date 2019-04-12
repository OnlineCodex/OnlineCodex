package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHChaosBastions extends Eintrag {

	public CHChaosBastions() {

        category = 1;

        name = "Chaos Bastions";
        grundkosten = getPts("Chaos Bastions");

        ogE.addElement(new OptionsGruppeEintrag("Icarus lascannon", getPts("Icarus lascannon")));
        ogE.addElement(new OptionsGruppeEintrag("Quad-gun", getPts("Quad-gun")));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        power = 10;

        complete();
    }


    @Override
    public void refreshen() {

    }
}
