package oc.wh40k.units.am;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class AMMilitarumTempestusScions extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelZaehler oe4;
	OptionsEinzelZaehler oe5;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkTransport2;
	RuestkammerStarter rkTransport3;
	
//	boolean lastState = false;

	public AMMilitarumTempestusScions() {
	}
	
	public void initButtons(boolean... defaults) {
		name = "Tempestus Scions";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Tempestus Scions", 5, 10, 12);
		squad.setGrundkosten(10);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGStormTrooperSquad.jpg"));

        seperator();

		add(oe4 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Funk + HE Gewehr", "Scion mit Funkgerät und HE Lasergewehr", 1, 5));
		add(oe5 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Funk + HE Pistole", "Scion mit Funkgerät und HE Laserpistole", 1, 5));
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Granatwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("HE Salvengewehr", 10));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tempestor", 0));

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
		
		ogE.addElement(new OptionsGruppeEintrag("HE Laserpistole", 0));
		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		o3.setAnzahl(0, 1);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "AMChimaere", "Chimäre");
		rkTransport.initKammer(true);
		add(rkTransport);
		
		rkTransport2 = new RuestkammerStarter(ID, randAbstand, cnt, "AMChimaereIA1", "[IA1 2nd Ed] Chimäre");
		rkTransport2.initKammer(true);
		add(rkTransport2);

		rkTransport3 = new RuestkammerStarter(ID, randAbstand, cnt, "AMTauroxPrime", "Taurox Prime");
		rkTransport3.initKammer(true);
		add(rkTransport3);
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		oe1.setSelected(true);
		
		oe4.setAktiv(!oe5.isSelected());
		oe5.setAktiv(!oe4.isSelected());
		
		rkTransport.setAktiv(!rkTransport2.isSelected() && !rkTransport3.isSelected());
		rkTransport2.setAktiv(!rkTransport.isSelected() && !rkTransport3.isSelected());
		rkTransport3.setAktiv(!rkTransport2.isSelected() && !rkTransport.isSelected());
	}

}
