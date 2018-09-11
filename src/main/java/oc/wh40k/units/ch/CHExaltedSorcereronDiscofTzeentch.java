package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHExaltedSorcereronDiscofTzeentch extends Eintrag {

    OptionsUpgradeGruppe inferno, stave;
    
	public CHExaltedSorcereronDiscofTzeentch() {

		name = "Exalted Sorcerer on Disc of Tzeentch";
        grundkosten = getPts("Exalted Sorcerer on Disc of Tzeentch");
        power = 7;   
        
        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
		add(stave = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Inferno bolt pistol", getPts("Inferno bolt pistol")));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
		ogE.addElement(new OptionsGruppeEintrag("Warpflame pistol", getPts("Warpflame pistol")));
		add(inferno = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power sword", getPts("Power sword")));
		
		complete();
	}

	@Override
	public void refreshen() {
		inferno.alwaysSelected();
		stave.alwaysSelected();
	}
}
