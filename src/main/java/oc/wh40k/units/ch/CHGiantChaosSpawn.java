package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHGiantChaosSpawn extends Eintrag {

	private final OptionsUpgradeGruppe mark;

    public CHGiantChaosSpawn() {

        name = "Giant Chaos Spawn";
        grundkosten = getPts("Giant Chaos Spawn");
        power = 5;

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        complete();
    }

    @Override
    public void refreshen() {
    }
}
