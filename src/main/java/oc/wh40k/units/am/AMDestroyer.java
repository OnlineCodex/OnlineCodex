package oc.wh40k.units.am;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AMDestroyer extends RuestkammerVater {

    public AMDestroyer() {
        grundkosten = 160;
    }

    @Override
    public void initButtons(boolean... defaults) {


        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", "Pintle-mounted heavy stubber", 10));
        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", "Pintle-mounted storm bolter", 10));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    }

}
