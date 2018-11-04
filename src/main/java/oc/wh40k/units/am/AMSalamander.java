package oc.wh40k.units.am;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AMSalamander extends RuestkammerVater {

    OptionsUpgradeGruppe bolt;
    OptionsUpgradeGruppe stub;

    public AMSalamander() {
        grundkosten = 55;
    }

    @Override
    public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 10));
        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 10));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozer blade", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 10));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    }

}
