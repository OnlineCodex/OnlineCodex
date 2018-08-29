package oc.wh40k.units.ed;

import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class EDPlatoonCommandSquad extends RuestkammerVater {

	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o22;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelZaehler oe3;
	OptionsEinzelZaehler oe5;
	OptionsEinzelZaehler oe6;
	OptionsEinzelZaehler oe7;
	OptionsEinzelZaehler oe8;
    OptionsEinzelUpgrade mb;
	OptionsEinzelUpgrade commissar;
	OptionsEinzelUpgrade commander;
	RuestkammerStarter rkTransport;

	public EDPlatoonCommandSquad() {
		grundkosten = 40;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGCommandSquad.jpg"));
		

		seperator();

		add(commander = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Platoon Commander", 0));

        seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Auxiliary grenade launcher", "Lasgun with Auxiliary grenade launcher", 3));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator(5);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "melta-bombs", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tracking beacon", 10));

		seperator();

		add(commissar = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Commissar", 35));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Auxiliary grenade launcher", "Lasgun with Auxiliary grenade launcher", 3));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o22 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		cnt = randAbstand;

		add(oe2 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Platoon standard", "Guardsman with Platoon standard", 1, 15));
		add(oe3 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Vox-caster", "Guardsman with Vox-caster", 1, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Guardsman with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Guardsman with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Guardsman with Melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Guardsman with Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Lascutter", "Guardsman with Lascutter", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, 1));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "option", "Krak grenades", 5));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand + 280, cnt, "EDValkyrie", "Valkyrie");
		rkTransport.initKammer(true);
		add(rkTransport);

		sizeSetzen();
	}

  @Override
	public void refreshen() {
        commander.setSelected(true);

		o22.setAktiv(commissar.isSelected());
		o4.setMaxAnzahl(4-(oe2.isSelected()?1:0)-(oe3.isSelected()?1:0));
	}

}
