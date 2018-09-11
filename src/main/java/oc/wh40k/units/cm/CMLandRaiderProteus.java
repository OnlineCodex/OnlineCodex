package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CMLandRaiderProteus extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

	public CMLandRaiderProteus() {
		name = "Land Raider Proteus";
		grundkosten = 215;
		
		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderHelios.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL Heavy bolter", "Twin-linked heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("TL Heavy flamer", "Twin-linked heavy flamer", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL bolter","Twin-linked bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Havoc launcher", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured Ceramite", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5));

		complete();
	}

	@Override
	public void refreshen() {

	}

}
