package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMLandRaiderProteus extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

	public SMLandRaiderProteus() {
		name = "Land Raider Proteus";
		grundkosten = 200;
		
		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderHelios.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL Heavy bolter", "Twin-linked heavy bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("TL Heavy flamer", "Twin-linked heavy flamer", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Explorator Augury Web", 50));

		complete();
	}

	@Override
	public void refreshen() {
	}

	@Override
	public void deleteYourself() {
	}

}
