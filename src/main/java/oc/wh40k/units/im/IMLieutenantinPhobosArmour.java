package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMLieutenantinPhobosArmour extends Eintrag {

	private final OptionsUpgradeGruppe o1;

    public IMLieutenantinPhobosArmour() {

    	grundkosten = getPts("Lieutenant in Phobos Armour") + getPts("Grav-chute");

        //Special Weapons
        ogE.addElement(new OptionsGruppeEintrag("MC occulus bolt carbine", "Master-crafted occulus bolt carbine", getPts("Master-crafted occulus bolt carbine")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    	o1.alwaysSelected();
        power = 5;
    }

}
