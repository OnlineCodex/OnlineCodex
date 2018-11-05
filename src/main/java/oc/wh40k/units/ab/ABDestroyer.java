package oc.wh40k.units.ab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ABDestroyer extends RuestkammerVater {

    OptionsUpgradeGruppe stub;
    OptionsUpgradeGruppe bolt;

    public ABDestroyer() {
        grundkosten = 160;
    }

    @Override
    public void initButtons(boolean... defaults) {


        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", "Pintle-mounted heavy stubber", 10));
        ogE.addElement(new OptionsGruppeEintrag("AA Heavy stubber", "Anti-aircraft mount heavy stubber", 15));
        add(stub = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", "Pintle-mounted storm bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("AA Storm bolter", "Anti-aircraft mount storm bolter", 15));
        add(bolt = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 20));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Mine plough", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured track guards", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Improved comms", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Anti-grenade mesh", 15));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        bolt.setAktiv(1, !stub.isSelected(1));
        stub.setAktiv(1, !bolt.isSelected(1));
    }

}
