package oc.wh40k.units.rh_ia13;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class RH_IA13ChampionKammer extends RuestkammerVater {

    OptionsUpgradeGruppe champ;
    OptionsUpgradeGruppe champW;

    public RH_IA13ChampionKammer() {
    }

    public void initButtons(boolean... defaults) {

        add(ico = new oc.Picture("oc/wh40k/images/RHEnforcer.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Champion", 0));
        ogE.addElement(new OptionsGruppeEintrag("Champion (Khorne)", "Champion (Covenant of Khorne)", 10));
        ogE.addElement(new OptionsGruppeEintrag("Champion (Nurgle)", "Champion (Covenant of Nurgle)", 10));
        ogE.addElement(new OptionsGruppeEintrag("Champion (Slaanesh)", "Champion (Covenant of Slaanesh)", 10));
        ogE.addElement(new OptionsGruppeEintrag("Champion (Tzeentch)", "Champion (Covenant of Tzeentch)", 10));
        add(champ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        champ.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Autogun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Close Combat Weapon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Autopistol", 0));
        ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
        ogE.addElement(new OptionsGruppeEintrag("Stubgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", 15));
        ogE.addElement(new OptionsGruppeEintrag("Powerfist", 25));
        add(champW = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 5));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!champ.isSelected()) {
            champ.setSelected(0, true);
        }

        if (!champW.isSelected()) {
            champW.setSelected(0, true);
            champW.setSelected(1, true);
        }
    }

}
