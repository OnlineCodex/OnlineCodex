package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class AMHadesBreachingDrill extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelZaehler oe4;
	OptionsEinzelZaehler oe5;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o5;
	RuestkammerStarter rkTransport;

	boolean harkerSelected = false;
	boolean bastonneSelected = false;

	public AMHadesBreachingDrill() {
		name = "Hades Breaching Drill";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/IGVeteranSquad.jpg"));

		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Carapace armour", 1, 30));
		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Melta bombs", 1, 20));
		
		seperator();

		add(oe4 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vox caster", 1, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Veteran w/ flamer", "Veteran with flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Veteran w/ Granatwerfer", "Veteran with grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Veteran w/ Melter", "Veteran with meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Veteran w/ Plasmawerfer", "Veteran with plasma gun", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));


		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sergeant", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hades Breaching Drill",0));
		
		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
        if(!oe1.isSelected()) oe1.setSelected(true); 

		
	}
}
