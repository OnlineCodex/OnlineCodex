package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMSpartanAssaultTank extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;

	public SMSpartanAssaultTank() {
		name = "Spartan Assault Tank";
		grundkosten = 295;

		add(ico = new oc.Picture("oc/wh40k/images/SMSpartanAssaultTank.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL Heavy Bolter", "twin-linked heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("TL Heavy Flamer", "Twin-linked heavy flamer", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Two quad lascannons", 0));
		ogE.addElement(new OptionsGruppeEintrag("Two laser destroyers", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Frag assault launcher", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured ceramite", 20));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
	}

}
