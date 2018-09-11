package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TAKrootShaper extends Eintrag {

	OptionsUpgradeGruppe o1;

	public TAKrootShaper() {
		name = "Kroot Shaper";
		grundkosten = getPts("Kroot Shaper") + getPts("Ritual blade");
		
		ogE.addElement(new OptionsGruppeEintrag("Kroot rifle", getPts("Kroot rifle")));
		ogE.addElement(new OptionsGruppeEintrag("Pulse rifle", getPts("Pulse rifle")));
		ogE.addElement(new OptionsGruppeEintrag("Pulse carbine", getPts("Pulse carbine")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		complete();
	}

	@Override
    public void deleteYourself() {
        super.deleteYourself();
    }
	
	@Override
	public void refreshen() {   
		if(o1.getAnzahl() == 0) o1.setSelected(0, true);
		power = 2;
	}

}

