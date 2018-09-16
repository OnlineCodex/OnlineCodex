package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHLordofChange extends Eintrag {

	OptionsUpgradeGruppe waffe1;
	OptionsEinzelUpgrade waffe2;
	RuestkammerStarter psychicPowers;
	
	public CHLordofChange() {

		name = "Lord of Change";
        grundkosten = getPts("Lord of Change");
        power = 17;
        
		ogE.addElement(new OptionsGruppeEintrag("Baleful sword", getPts("Baleful sword")));
		ogE.addElement(new OptionsGruppeEintrag("Rod of sorcery", getPts("Rod of sorcery")));
		add(waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		waffe1.setSelected(0, true);
        
		add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Staff of Tzeentch", getPts("Staff of Tzeentch")));
		waffe2.setSelected(true);
		
		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(3);
        ((PsychicPowers)psychicPowers.getKammer()).enableTzeentch();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(true);
		
		complete();

	}

	@Override
	public void refreshen() {
		if(!waffe2.isSelected())waffe2.setSelected(true);
	}
}
