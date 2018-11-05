package oc.wh40k.units.rh_ia13;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class RH_IA13RenegadeEnforcerKammer extends RuestkammerVater {

    OptionsUpgradeGruppe fk;
    OptionsUpgradeGruppe nk;

    public RH_IA13RenegadeEnforcerKammer() {
        name = "Enforcer";
        grundkosten = 25;
    }

    public void initButtons(boolean... defaults) {

        add(ico = new oc.Picture("oc/wh40k/images/RHEnforcer.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
        ogE.addElement(new OptionsGruppeEintrag("Autopistol", 0));
        ogE.addElement(new OptionsGruppeEintrag("Stub gun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Autogun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 5));
        ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", 15));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", 25));
        add(fk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Close combat weapon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Autogun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 5));
        ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", 15));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", 25));
        add(nk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Melta bombs", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Carapace Armour", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Combat drugs injector", 10));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!nk.isSelected()) {
            nk.setSelected(0, true);
        }

        if (!fk.isSelected()) {
            fk.setSelected(0, true);
        }
    }

}
