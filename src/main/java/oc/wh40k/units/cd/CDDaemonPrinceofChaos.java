package oc.wh40k.units.cd;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CDDaemonPrinceofChaos extends Eintrag {

	OptionsUpgradeGruppe waffe1;
	OptionsEinzelUpgrade waffe2;
	OptionsUpgradeGruppe mark;
	RuestkammerStarter psychicPowers;
	
	public CDDaemonPrinceofChaos() {

		name = "Daemon Prince of Chaos";
        grundkosten = getPts("Daemon Prince of Chaos");
        power = 11;
        
		ogE.addElement(new OptionsGruppeEintrag("Hellforged sword", getPts("Hellforged sword")));
		ogE.addElement(new OptionsGruppeEintrag("Daemonic axe", getPts("Daemonic axe")));
		ogE.addElement(new OptionsGruppeEintrag("Malefic talons", getPts("Malefic talons")));
		add(waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		waffe1.setSelected(0, true);
        
		seperator();
		
		add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warp bolter", getPts("Warp bolter")));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
		add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(1);
		((PsychicPowers)psychicPowers.getKammer()).enableDarkHereticus();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(true);
		
		complete();

	}

	@Override
	public void refreshen() {
		psychicPowers.setAktiv(!mark.isSelected("Mark of Khorne") && !(mark.getAnzahl() == 0));
		
		if(mark.isSelected("Mark of Nurgle"))
			((PsychicPowers)psychicPowers.getKammer()).enableNurgle();
		if(mark.isSelected("Mark of Tzeentch"))
			((PsychicPowers)psychicPowers.getKammer()).enableTzeentch();;
		if(mark.isSelected("Mark of Slaanesh"))
			((PsychicPowers)psychicPowers.getKammer()).enableSlaanesh();
	}
}
