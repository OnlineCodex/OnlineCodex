package oc.wh40k.units.am;

import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class AMPlatooncommandsquad extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o22;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o5;
	OptionsZaehlerGruppe o6;
	OptionsZaehlerGruppe o7;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelZaehler oe3;
	OptionsEinzelZaehler oe4;
	OptionsEinzelZaehler oe5;
	OptionsEinzelZaehler oe6;
	OptionsEinzelZaehler oe7;
	OptionsEinzelZaehler oe8;
	OptionsEinzelUpgrade mb;
	OptionsEinzelUpgrade commissar;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkTransport2;
	RuestkammerStarter rkTransport3;
	RuestkammerStarter rkAquila;
	OptionsZaehlerGruppe flak;

	boolean chenkovSelected = false;
	boolean alrahemSelected = false;
	boolean mustNotTakeTrans = false;

	public AMPlatooncommandsquad() {
		grundkosten = 30;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGCommandSquad.jpg"));


		ogE.addElement(new OptionsGruppeEintrag("Zugkommandeur", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Laserpistole", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 1));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 1));
		add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		o7.setAnzahl(0, 1);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		o2.setAnzahl(0, 1);

		seperator();

		add(mb = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melterbomben", 5));

		seperator();
		
		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "AMChimaere", "Chimäre");
		rkTransport.initKammer(true);
		add(rkTransport);

		rkTransport2 = new RuestkammerStarter(ID, randAbstand, cnt, "AMChimaereIA1", "[IA1 2nd Ed] Chimäre");
		rkTransport2.initKammer(true);
		add(rkTransport2);

		rkTransport3 = new RuestkammerStarter(ID, randAbstand, cnt, "AMTaurox", "Taurox");
		rkTransport3.initKammer(true);
		add(rkTransport3);

		rkAquila= new RuestkammerStarter(ID, randAbstand, cnt, "AMAquilaLanderKammer", "[IA Aeronautica] Aquila");
		rkAquila.initKammer(true);
		add(rkAquila);

		cnt = randAbstand;

		add(oe1 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Sanitätsausrüstung", "Soldat mit Sanitätsausrüstung", 1, 15));
		add(oe2 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Zugstandarte", "Soldat mit Zugstandarte", 1, 10));
		add(oe3 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Funkgerät", "Soldat mit Funkgerät", 1, 5));
		add(oe4 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Schwerer Flamer", "Soldat mit Schwerem Flammenwerfer", 1, 10));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mörser Team", "Waffenteam mit Mörser", 5));
		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanonen Team", "Waffenteam mit Maschinenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter Team", "Waffenteam mit schwerem Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer Team", "Waffenteam mit Raketenwerfer", 15));
		//ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer-Team (Flak)", "Waffenteam mit Flak-Raketenwerfer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanonen Team", "Waffenteam mit Laserkanone", 20));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flakraketen", 10));
		add(flak = new OptionsZaehlerGruppe(ID, randAbstand +280, cnt, "", ogE, 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Scharfschützengewehr", "Soldat mit Scharfschützengewehr", 2));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", "Soldat mit Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Granatwerfer", "Soldat mit Granatwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", "Soldat mit Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", "Soldat mit Plasmawerfer", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, 4));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Laserpistole", 0));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, 4));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Sprenggranaten", 5));

		sizeSetzen();

	}

	@Override
	public void refreshen() {

		rkTransport.setAktiv(!rkAquila.isSelected() && !rkTransport2.isSelected() && !rkTransport3.isSelected() && !mustNotTakeTrans);
		rkAquila.setAktiv(!rkTransport.isSelected() && !rkTransport2.isSelected() && !rkTransport3.isSelected() && !mustNotTakeTrans);
		rkTransport2.setAktiv(!rkTransport.isSelected() && !rkAquila.isSelected() && !rkTransport3.isSelected() && !mustNotTakeTrans);
		rkTransport3.setAktiv(!rkTransport.isSelected() && !rkAquila.isSelected() && !rkTransport2.isSelected() && !mustNotTakeTrans);

		if(!o1.isSelected()) o1.setSelected(0,true);
		o2.setAktiv(o1.isSelected("Zugkommandeur"));
		mb.setAktiv(o1.isSelected("Zugkommandeur"));

		o3.setMaxAnzahl( oe1.getAnzahl() + oe2.getAnzahl() + oe3.getAnzahl() + oe4.getAnzahl() <= 2 ? 1 : 0 );

		int selectedVeterans = oe1.getAnzahl() + oe2.getAnzahl() + oe3.getAnzahl() + oe4.getAnzahl() + (o3.isSelected() ? 2 : 0);
		o4.setMaxAnzahl( 4 - selectedVeterans );

		o5.setMaxAnzahl( 4 - oe4.getAnzahl() - o4.getAnzahl() );

		flak.setMaxAnzahl(o3.isSelected("Waffenteam mit Raketenwerfer") ? 1 : 0);
	}



}
