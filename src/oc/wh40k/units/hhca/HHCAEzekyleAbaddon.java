package oc.wh40k.units.hhca;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class HHCAEzekyleAbaddon extends Eintrag {
	
	OptionsUpgradeGruppe o0, o1;

	public HHCAEzekyleAbaddon() {
		name = "Ezekyle Abaddon";
		grundkosten = 215;
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		addToInformationVector("HHCAPraetor", 1);
		
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        if (!o1.isSelected()) {o1.setSelected(0, true);}
	}
	
	@Override
	public void deleteYourself() {
		
		addToInformationVector("HHCAPraetor", -1);
		super.deleteYourself();
	}
	

}
