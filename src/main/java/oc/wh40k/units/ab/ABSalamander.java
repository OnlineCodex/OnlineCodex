package oc.wh40k.units.ab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ABSalamander extends RuestkammerVater {

    OptionsUpgradeGruppe bolt;
    OptionsUpgradeGruppe stub;

    public ABSalamander() {
        grundkosten = 55;
    }

    @Override
    public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 10));
        ogE.addElement(new OptionsGruppeEintrag("AA Heavy stubber", "Anti-aircraft mount heavy stubber", 15));
        add(stub = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("AA Storm bolter", "Anti-aircraft mount storm bolter", 15));
        add(bolt = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Mine plough", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured track guards", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Improved comms", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Anti-grenade mesh", 15));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        stub.setAktiv(1, !bolt.isSelected(1));
        bolt.setAktiv(1, !stub.isSelected(1));
    }

}
