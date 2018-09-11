package oc.wh40k.units.cd;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CDLordofChange extends Eintrag {

	OptionsUpgradeGruppe waffe1;
	OptionsEinzelUpgrade waffe2;
	
	public CDLordofChange() {

		name = "Lord of Change";
        grundkosten = getPts("Lord of Change");
        power = 17;
        
		ogE.addElement(new OptionsGruppeEintrag("Baleful sword", getPts("Baleful sword")));
		ogE.addElement(new OptionsGruppeEintrag("Rod of sorcery", getPts("Rod of sorcery")));
		add(waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		waffe1.setSelected(0, true);
        
		add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Staff of Tzeentch", getPts("Staff of Tzeentch")));
		waffe2.setSelected(true);
		
		complete();

	}

	@Override
	public void refreshen() {
		if(!waffe2.isSelected())waffe2.setSelected(true);
	}
}
