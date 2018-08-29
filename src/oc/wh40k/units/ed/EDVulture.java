package oc.wh40k.units.ed;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class EDVulture extends RuestkammerVater {
	
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsEinzelUpgrade oe1;

	public EDVulture() {
		grundkosten = 105;
	}
	@Override
	public void initButtons(boolean... defaults) {
		

		ogE.addElement(new OptionsGruppeEintrag("T/L Multi-laser", "Twin-linked Multi-laser", 0));
		ogE.addElement(new OptionsGruppeEintrag("T/L Autocannon", "Twin-linked Autocannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("T/L Lascannon", "Twin-linked Lascannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("T/L Missile launcher", "Twin-linked Missile launcher", 10));
		ogE.addElement(new OptionsGruppeEintrag("T/L Rocket pods", "Twin-linked Multiple rocket pods", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike missiles", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Hellfury missiles", 20));
		ogE.addElement(new OptionsGruppeEintrag("6 Tactical bombs", 40));
		ogE.addElement(new OptionsGruppeEintrag("6 Hunter-killer missiles", 40));
		ogE.addElement(new OptionsGruppeEintrag("2 Rocket pods", "2 Multiple rocket pods", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "T/L Punisher cannon", "Twin-linked Punisher Gatling cannon", 50));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Flare/chaff launcher", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured cockpit", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Infra-red targeting", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Illum flares", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Distinctive paint", "Distinctive paint scheme/decals", 10));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        o1.setAktiv(!oe1.isSelected());
        o2.setAktiv(!oe1.isSelected());

        o1.alwaysSelected();
        o2.alwaysSelected();
	}

}
