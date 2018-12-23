package oc.wh40k.units.im;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMRavenwingHuntmaster extends RuestkammerVater {

    public IMRavenwingHuntmaster() {
        ogE.addElement(new OptionsGruppeEintrag("Corvus hammer", getPts("Corvus hammer")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", getPts("Power lance (SM)")));
        OptionsUpgradeGruppe o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1);
        o1.setSelected(0, true);
        add(o1);

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", getPts("Melta bombs")));

        sizeSetzen();
    }
}