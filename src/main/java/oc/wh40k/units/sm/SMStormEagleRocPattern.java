package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMStormEagleRocPattern extends Eintrag {

	OptionsUpgradeGruppe wpn;
	
	public SMStormEagleRocPattern() {
		name = "Storm Eagle Assault Gunship - Roc Pattern";
		grundkosten = 295;


		add(ico = new oc.Picture("oc/wh40k/images/Stormtalon.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("TL heavy bolter","twinlinked heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("TL multi-melta","twinlinked multi-melta", 15));
		ogE.addElement(new OptionsGruppeEintrag("Typhoon missile launcher", 25));
		add(wpn = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Searchlight", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Extra armour", 15));
		
		complete();

	}

	public void refreshen() {
		if(!wpn.isSelected()){
			wpn.setSelected(0, true);
		}
	}
}
