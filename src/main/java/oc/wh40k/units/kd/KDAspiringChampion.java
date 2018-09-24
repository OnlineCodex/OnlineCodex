
package oc.wh40k.units.kd;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class KDAspiringChampion extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
    RuestkammerStarter nahkampfWaffen;
    RuestkammerStarter fernkampfWaffen;
    OptionsZaehlerGruppe mutationen;
    OptionsEinzelUpgrade handwaffe, boltpistole, bolter;
    OptionsUpgradeGruppe psiWaffe;

	boolean isBesessen = false; // Nur Mutationen
	boolean isHexer = false;    // Nur Mutationen und Melterbombe
	boolean isSlaanesh = false; // Schockverstärker und Bolter und Boltpistole
	boolean isChampion = false; // Bolter, Boltpistole und Handwaffe
	boolean isNurgle = false;   // Seuchenmesser, Bolter und Boltpistole
	boolean isKhorne = false;   // Boltpistole, Nahkampfwaffe
	boolean isAuserkoren = false;   // zus. Melter-/Plasma-Option durch Trupp-Upgrades
	
	public KDAspiringChampion() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
			try {
					isBesessen = defaults[0];
					isHexer = defaults[1];
					isSlaanesh = defaults[2];
					isChampion = defaults[3];
					isNurgle = defaults[4];
					isKhorne = defaults[5];
					isAuserkoren = defaults[6];
                } catch(Exception e) {}

		if(isBesessen) {
			ogE.addElement(new OptionsGruppeEintrag("Geschenk der Mutation", 10));
			add(mutationen = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		} else if (isHexer) {
			
			ogE.addElement(new OptionsGruppeEintrag("Psiwaffe", 0));
			ogE.addElement(new OptionsGruppeEintrag("Psistab", 0));
			ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
			ogE.addElement(new OptionsGruppeEintrag("Psiaxt", 0));
			add(psiWaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			psiWaffe.alwaysSelected();
			
			add(boltpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole",0));
			boltpistole.setSelected(true);
			
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Geschenk der Mutation", 10));	
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		} else {	
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));				
			if(isSlaanesh) {
				add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schockverstärker", 15));
			}
			
			seperator();
			
			add(boltpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole", 0));
			boltpistole.setSelected(true);
			
			if(isChampion){
				add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Handwaffe", 0));
				add(bolter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bolter", 0));
				
				handwaffe.setSelected(true);
				bolter.setSelected(true);
			} else if(isKhorne) {
				add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Handwaffe", 0));
				handwaffe.setSelected(true);
			} else if(isNurgle) {
				add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Seuchenmesser", 0));
				handwaffe.setSelected(true);
				add(bolter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bolter", 0));
				bolter.setSelected(true);
			} else if(isSlaanesh) {
				add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Handwaffe", 0));
				handwaffe.setSelected(true);
				add(bolter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bolter", 0));
				bolter.setSelected(true);
			}
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Kettenaxt", 8));
			ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
			ogE.addElement(new OptionsGruppeEintrag("Axt des Khorne", 30));
			add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Kombibolter", 3));
			ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
			ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
			ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
			if(isAuserkoren){
				ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
				ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
			}
			ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
			add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		}
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		int nahkampfwaffen = 0;
		int fernkampfwaffen = 0;
		int substractor1 = 0;
		int substractor2 = 0;
		
		if(isChampion || isSlaanesh || isNurgle) {
			if(handwaffe.isSelected() && boltpistole.isSelected()) { substractor1 = 2; }
			else if(handwaffe.isSelected() || boltpistole.isSelected()) { substractor1 = 1; }
			else if(!handwaffe.isSelected() && !boltpistole.isSelected()) { substractor1 = 0; }
			
			if(bolter.isSelected()) substractor2 = 1;
			
			nahkampfwaffen = 2 - substractor1 - (bolter.isSelected()?o2.getAnzahl():0);
			fernkampfwaffen = 3 - substractor1 - substractor2 - o1.getAnzahl();
			
			if(nahkampfwaffen < 0) nahkampfwaffen = 0;
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(nahkampfwaffen > 2) nahkampfwaffen = 2;
			
			o1.setMaxAnzahl(nahkampfwaffen);
			o2.setMaxAnzahl(fernkampfwaffen);
			
			legal = ((bolter.isSelected()?1:0) + (boltpistole.isSelected()?1:0) + (handwaffe.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl())==3;
			bolter.setLegal(legal);
			boltpistole.setLegal(legal);
			handwaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
		}
		
		if(isKhorne) {
			if(handwaffe.isSelected() && boltpistole.isSelected()) { substractor1 = 2; }
			else if(handwaffe.isSelected() || boltpistole.isSelected()) { substractor1 = 1; }
			else if(!handwaffe.isSelected() && !boltpistole.isSelected()) { substractor1 = 0; }
			
			nahkampfwaffen = 2 - substractor1 - o2.getAnzahl();
			fernkampfwaffen = 2 - substractor1 - o1.getAnzahl();
			
			if(nahkampfwaffen < 0) nahkampfwaffen = 0;
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(nahkampfwaffen > 2) nahkampfwaffen = 2;
			
			o1.setMaxAnzahl(nahkampfwaffen);
			o2.setMaxAnzahl(fernkampfwaffen);
			
			legal = ((boltpistole.isSelected()?1:0) + (handwaffe.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl())==2;
			boltpistole.setLegal(legal);
			handwaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
		}
		
//		if(isNurgle){
//			if(handwaffe.isSelected() && bolter.isSelected()) { substractor1 = 2; }
//			else if(handwaffe.isSelected() || bolter.isSelected()) { substractor1 = 1; }
//			else if(!handwaffe.isSelected() && !bolter.isSelected()) { substractor1 = 0; }
//			
//			if(boltpistole.isSelected()) substractor2 = 1;
//			
//			nahkampfwaffen = 3 - substractor1 - substractor2 - o2.getAnzahl();
//			fernkampfwaffen = 3 - substractor1 - substractor2 - o1.getAnzahl();
//			
//			if(nahkampfwaffen < 0) nahkampfwaffen = 0;
//			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
//			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
//			if(nahkampfwaffen > 1) nahkampfwaffen = 1;
//			
//			if(!boltpistole.isSelected()) { 
//				o1.setMaxAnzahl(nahkampfwaffen);
//			} else {
//				o1.setMaxAnzahl(0);
//			}
//			o2.setMaxAnzahl(fernkampfwaffen);
//			
//			legal = ((bolter.isSelected()?1:0) + (boltpistole.isSelected()?1:0) + (handwaffe.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl())==3;
//			bolter.setLegal(legal);
//			boltpistole.setLegal(legal);
//			handwaffe.setLegal(legal);
//			o1.setLegal(legal);
//			o2.setLegal(legal);
//		}
		
		
//		if(isSlaanesh){
//			if(bolter.isSelected()) { substractor1 = 1; }
//			if(boltpistole.isSelected()) substractor2 = 1;
//			
//			nahkampfwaffen = 2 - substractor1 - substractor2 - o2.getAnzahl();
//			fernkampfwaffen = 2 - substractor1 - substractor2 - o1.getAnzahl();
//			
//			if(nahkampfwaffen < 0) nahkampfwaffen = 0;
//			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
//			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
//			if(nahkampfwaffen > 1) nahkampfwaffen = 1;
//			
//			if(!boltpistole.isSelected()) { 
//				o1.setMaxAnzahl(nahkampfwaffen);
//			} else {
//				o1.setMaxAnzahl(0);
//			}
//			o2.setMaxAnzahl(fernkampfwaffen);
//			
//			legal = ((bolter.isSelected()?1:0) + (boltpistole.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl())==2;
//			bolter.setLegal(legal);
//			boltpistole.setLegal(legal);
//			o1.setLegal(legal);
//			o2.setLegal(legal);
//		}
//		
		if(isHexer){
			psiWaffe.alwaysSelected();
			boltpistole.setSelected(true);
			legal=true;
		}
	}

}
