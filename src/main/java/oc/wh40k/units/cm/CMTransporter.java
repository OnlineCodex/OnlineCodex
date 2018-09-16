package oc.wh40k.units.cm;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CMTransporter extends RuestkammerVater {

	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;
	OptionsEinzelUpgrade o4;
	OptionsUpgradeGruppe o5;
	OptionsEinzelUpgrade o6;
	OptionsEinzelUpgrade o7;
	OptionsEinzelUpgrade o8;
	OptionsEinzelUpgrade o9;
	OptionsEinzelUpgrade o10;
	OptionsEinzelUpgrade o11;
	OptionsEinzelUpgrade o12;
	OptionsUpgradeGruppe typ;
	OptionsUpgradeGruppe fahrzeugausruestung;

    boolean offerRhino = false;
    boolean offerLandRaider = false;
	
	public CMTransporter() {
        grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {
		this.offerRhino = defaults[0];
        this.offerLandRaider = defaults[1];
        
		add(ico = new oc.Picture("oc/wh40k/images/ChaosRhinoKammer.gif"));
		
		if (this.offerRhino) {
			ogE.addElement(new OptionsGruppeEintrag("Rhino des Chaos", 35));
		}
		if (this.offerLandRaider) {
			ogE.addElement(new OptionsGruppeEintrag("Land Raider des Chaos", 230));
		}
		add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kombi-Bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Kakophon", 5));
        ogE.addElement(new OptionsGruppeEintrag("Bulldozerschaufel", 5));
        ogE.addElement(new OptionsGruppeEintrag("Warpfeuerspeier", 5));
        ogE.addElement(new OptionsGruppeEintrag("Kombiflammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombimelter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombiplasmawerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Zusätzliche Panzerung", 10));
        ogE.addElement(new OptionsGruppeEintrag("Inferno-Raketenwerfer", 12));
        ogE.addElement(new OptionsGruppeEintrag("Zerstörer-Klingen", 15));
        ogE.addElement(new OptionsGruppeEintrag("Dämonenmaschine", 15));
		add(fahrzeugausruestung = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 9));
		
		sizeSetzen();
	}

	public void refreshen() {
		if(typ.isSelected()){
			fahrzeugausruestung.setAktiv(true);
			fahrzeugausruestung.setAktiv("Kombiflammenwerfer",(!fahrzeugausruestung.isSelected("Kombimelter") && !fahrzeugausruestung.isSelected("Kombiplasmawerfer")));
			fahrzeugausruestung.setAktiv("Kombimelter",(!fahrzeugausruestung.isSelected("Kombiflammenwerfer") && !fahrzeugausruestung.isSelected("Kombiplasmawerfer")));
			fahrzeugausruestung.setAktiv("Kombiplasmawerfer",(!fahrzeugausruestung.isSelected("Kombimelter") && !fahrzeugausruestung.isSelected("Kombiflammenwerfer")));
		} else {
			fahrzeugausruestung.setAktiv(false);
		}
	}

}
