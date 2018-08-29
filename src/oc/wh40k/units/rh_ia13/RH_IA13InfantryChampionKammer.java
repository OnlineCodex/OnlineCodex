package oc.wh40k.units.rh_ia13;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class RH_IA13InfantryChampionKammer extends RuestkammerVater {

	OptionsUpgradeGruppe champ;
	OptionsUpgradeGruppe champW;
	
	boolean isDemagogue=false;
	boolean isVet=false;

	public RH_IA13InfantryChampionKammer() {
		}

	public void initButtons(boolean... defaults) {

		try {
			isDemagogue = defaults[0];
			isVet = defaults[1];
		} catch(Exception e) {}

		seperator();

		
		if(isDemagogue){
			ogE.addElement(new OptionsGruppeEintrag("Demagogue", 5));
			ogE.addElement(new OptionsGruppeEintrag("Demagogue (Khorne)","Demagogue (Covenant of Khorne)", 25));
			ogE.addElement(new OptionsGruppeEintrag("Demagogue (Nurgle)","Demagogue (Covenant of Nurgle)", 25));
			ogE.addElement(new OptionsGruppeEintrag("Demagogue (Slaanesh)","Demagogue (Covenant of Slaanesh)", 25));
			ogE.addElement(new OptionsGruppeEintrag("Demagogue (Tzeentch)","Demagogue (Covenant of Tzeentch)", 25));
		}else{
			ogE.addElement(new OptionsGruppeEintrag("Champion", 5));
			ogE.addElement(new OptionsGruppeEintrag("Champion (Khorne)","Champion (Covenant of Khorne)", 25));
			ogE.addElement(new OptionsGruppeEintrag("Champion (Nurgle)","Champion (Covenant of Nurgle)", 25));
			ogE.addElement(new OptionsGruppeEintrag("Champion (Slaanesh)","Champion (Covenant of Slaanesh)", 25));
			ogE.addElement(new OptionsGruppeEintrag("Champion (Tzeentch)","Champion (Covenant of Tzeentch)", 25));
		}
		add(champ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		champ.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Autopistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Stubgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", 0));
		add(champW = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 2));
		
		seperator();
		
		if(!isVet){
			ogE.addElement(new OptionsGruppeEintrag("Carapace armour", 10));
		}
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Powerfist", 25));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 5));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 4));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power maul", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power lance", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!champ.isSelected()){ 
			champ.setSelected(0,true);
		}
		
		if(!champW.isSelected()){
			champW.setSelected(0,true);
		}
		
	}

}
