package oc.wh40k.units.ed;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class EDInfantrySquad extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	RuestkammerStarter rkTransport;

	public EDInfantrySquad() {
		grundkosten = 60;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGInfantrySquad.jpg"));
		

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 5));

		seperator();

		add(oe3=new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vox-caster", 5));
		add(oe4=new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Breacher charge", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Guardsman with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Guardsman with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Guardsman with Melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Guardsman with Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Lascutter", "Guardsman with Lascutter", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,9));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Upgrade to Sergeant", 0));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Auxiliary grenade launcher", "Lasgun with Auxiliary grenade launcher", 3));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator(5);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta-bombs", 5));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Commissar", 35));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Auxiliary grenade launcher", "Lasgun with Auxiliary grenade launcher", 3));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "EDValkyrie", "Valkyrie");
		rkTransport.initKammer(true);
		add(rkTransport);

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		oe1.setSelected(true);
		o4.setAktiv(oe2.isSelected());
		o1.setMaxAnzahl(9-(oe3.isSelected()?1:0)-(oe4.isSelected()?1:0));
	}

}
