package oc.wh40k.units.hhca;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class HHCAPraetorServoKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2a, o2b, o3, o4, o5, o6, o7, o8;
	OptionsZaehlerGruppe o2;
	
	public HHCAPraetorServoKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
				
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
		add(o2a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2a.setSelected(0, true);
		
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
		add(o2b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2b.setSelected(0, true);
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Archaeotech pistol", 20));
		ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 20));
		ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 20));
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Paragon blade", 25));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 25));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Digital lasers", 15));
		ogE.addElement(new OptionsGruppeEintrag("Master-crafted weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Banestrike ammunition", 5));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
		ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
		ogE.addElement(new OptionsGruppeEintrag("Boarding shield", 10));
		ogE.addElement(new OptionsGruppeEintrag("Iron halo", 25));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine bike", 25));
		ogE.addElement(new OptionsGruppeEintrag("Legion jetbike", 45));
		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		int substractor = 0;
		int klauen = 0;
		int waffen = 0;
		
		if(o2a.isSelected() && o2b.isSelected()) { substractor = 2; }
		else if(o2a.isSelected() || o2b.isSelected()) { substractor = 1; }
		else if(!o2a.isSelected() && !o2b.isSelected()) { substractor = 0; }
		
		if(o3.isSelected()) { klauen = 2; }
		else if(!o3.isSelected()) { klauen = 0; }
		
		waffen = 2 - substractor - klauen;
		if(waffen < 0) waffen = 0;
		
		o2.setMaxAnzahl(waffen);
		o4.setAktiv(3, o1.isSelected(0) || o1.isSelected(1) || o1.isSelected(2) || o1.isSelected(3));
		
		boolean legal = ((o2a.isSelected()?1:0) + (o2b.isSelected()?1:0) + o2.getAnzahl() + klauen) ==2;
		
		o2a.setLegal(legal);
		o2b.setLegal(legal);
		o2.setLegal(legal);
		o3.setLegal(legal);
		
		
			
	}



}
