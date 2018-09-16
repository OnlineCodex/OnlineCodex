package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKValdorKammer extends RuestkammerVater {

        OptionsUpgradeGruppe o1;

	public DKValdorKammer() {}
	
	public void initButtons(boolean... b) {
		name = "Valdor";
		grundkosten = 320;


		add(ico = new oc.Picture("oc/wh40k/images/ValdorTankHunter.gif"));
		


        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzlicher Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Maschinengewehr", 10));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Maschinengewehre", "Seitenkuppeln mit Maschinengewehren", 0));
		ogE.addElement(new OptionsGruppeEintrag("schwere Bolter", "Seitenkuppeln mit schweren Boltern", 5));
		ogE.addElement(new OptionsGruppeEintrag("schwere Flamer", "Seitenkuppeln mit schweren Flammenwerfern", 5));
		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanonen", "Seitenkuppeln mit Maschinenkanonen", 10));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanonen", "Seitenkuppeln mit Laserkanonen", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		sizeSetzen();

	}

	public void refreshen() {
            o1.alwaysSelected();
	}
}
