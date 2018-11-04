package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class AMManticoreLauncherTankAirDefence extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade oe3;
    OptionsEinzelUpgrade oe4;
    OptionsEinzelUpgrade oe5;
    OptionsEinzelUpgrade oe6;

    public AMManticoreLauncherTankAirDefence() {
        name = "Manticore Launcher Tank (Air Defence)";
        grundkosten = 145;

        add(ico = new oc.Picture("oc/wh40k/images/IGManticoreRocketLauncher.jpg"));

        seperator(12);

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", 10));
        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
        add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozer blade", 10));
        add(oe5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 15));
        add(oe6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 30));

        complete();
    }

    // @OVERRIDE
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
    }

}
