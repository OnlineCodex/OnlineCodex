package oc.wh40k.units.hhca;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class HHCATransportKammerProteus  extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3;

	public HHCATransportKammerProteus () {
            grundkosten = 200;
	}

	public void initButtons(boolean... defaults) {


		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy flamer", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
		ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
		ogE.addElement(new OptionsGruppeEintrag("Auxiliary Drive", 10));
		ogE.addElement(new OptionsGruppeEintrag("Extra Armour", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured Ceramite", 20));
		ogE.addElement(new OptionsGruppeEintrag("Explorator Augury Web", 50));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));
		
        sizeSetzen();
	}

	@Override
	public void refreshen() {
			
    		
	}
        
}