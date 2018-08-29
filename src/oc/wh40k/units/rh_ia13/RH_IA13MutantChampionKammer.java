package oc.wh40k.units.rh_ia13;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class RH_IA13MutantChampionKammer extends RuestkammerVater {

	OptionsUpgradeGruppe champ;
	OptionsUpgradeGruppe champW;

	public RH_IA13MutantChampionKammer() {
		}

	public void initButtons(boolean... defaults) {

		
		ogE.addElement(new OptionsGruppeEintrag("Champion", 5));
		ogE.addElement(new OptionsGruppeEintrag("Champion (Khorne)","Champion (Covenant of Khorne)", 20));
		ogE.addElement(new OptionsGruppeEintrag("Champion (Nurgle)","Champion (Covenant of Nurgle)", 20));
		ogE.addElement(new OptionsGruppeEintrag("Champion (Slaanesh)","Champion (Covenant of Slaanesh)", 20));
		ogE.addElement(new OptionsGruppeEintrag("Champion (Tzeentch)","Champion (Covenant of Tzeentch)", 20));
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
		
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
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
