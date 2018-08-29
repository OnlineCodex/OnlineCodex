package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHFluxmaster extends Eintrag {

	OptionsEinzelUpgrade waffe1;
	OptionsEinzelUpgrade waffe2;
	RuestkammerStarter psychicPowers;
	
	public CHFluxmaster() {

		name = "Fluxmaster";
        grundkosten = getPts("Fluxmaster");
        power = 5;

		add(waffe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ritual dagger", getPts("Ritual dagger")));
		waffe1.setSelected(true);
        
		add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Staff of change", getPts("Staff of change")));
		
		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers)psychicPowers.getKammer()).enableTzeentch();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(true);
		
		complete();

	}

	@Override
	public void refreshen() {
		if(!waffe1.isSelected())waffe1.setSelected(true);
	}
}
