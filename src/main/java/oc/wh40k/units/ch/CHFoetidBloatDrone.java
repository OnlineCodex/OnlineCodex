package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHFoetidBloatDrone extends Eintrag {

	private final OptionsUpgradeGruppe spitter, probe;

    public CHFoetidBloatDrone() {

        name = "Foetid Bloat-drone";
        grundkosten = getPts("Foetid Bloat-drone");
        power = 10;

        ogE.addElement(new OptionsGruppeEintrag("Two plaguespitters", getPts("Plaguespitter") + getPts("Plaguespitter")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy blight-launcher", getPts("Heavy blight-launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Fleshmower", getPts("Fleshmower")));
        add(spitter = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        ogE.addElement(new OptionsGruppeEintrag("Plague probe", getPts("Plague probe")));
        add(probe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();

    }

    @Override
    public void refreshen() {
        if (!spitter.isSelected()) spitter.setSelected(0, true);
        probe.setSelected(0, true);
    }
}
