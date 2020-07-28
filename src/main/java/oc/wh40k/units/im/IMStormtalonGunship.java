package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMStormtalonGunship extends Eintrag {

	private final OptionsUpgradeGruppe o1;

    public IMStormtalonGunship() {
        name = "Stormtalon Gunship";
        grundkosten = getPts("Stormtalon Gunship") + getPts("Twin assault cannon");
        power = 9;


        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", getPts("Heavy Bolter (SM other)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Lascannons", getPts("Lascannon (SM other)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Skyhammer missile launcher", getPts("Skyhammer missile launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Typhoon missile launcher", getPts("Typhoon missile launcher")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


        complete();

    }

    @Override
	public void refreshen() {
        o1.alwaysSelected();
    }
}
