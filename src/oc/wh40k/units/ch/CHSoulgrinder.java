package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHSoulgrinder extends Eintrag {

	OptionsUpgradeGruppe waffe1;
	OptionsUpgradeGruppe mark;
	
	public CHSoulgrinder() {

		name = "Soulgrinder";
        grundkosten = getPts("Soulgrinder");
        power = 11;
        
		ogE.addElement(new OptionsGruppeEintrag("Warpsword", getPts("Warpsword")));
		ogE.addElement(new OptionsGruppeEintrag("Warpclaw", getPts("Warpclaw")));
		add(waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		waffe1.setSelected(0, true);
		
		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
		add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();

	}

	@Override
	public void refreshen() {
		mark.alwaysSelected();
	}
}
