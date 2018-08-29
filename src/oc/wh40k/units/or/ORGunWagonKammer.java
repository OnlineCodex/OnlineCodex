package oc.wh40k.units.or;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ORGunWagonKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public ORGunWagonKammer() {
		grundkosten = 60;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/GunWagon.gif"));
		

		ogE.addElement(new OptionsGruppeEintrag("Kannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Zzap gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lobba", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "'Ard case", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armour plates", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boarding plank", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot riggers", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red paint job", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Reinforced ram", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb chukka", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin' ball", 10));

       	

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
        
	}

}
