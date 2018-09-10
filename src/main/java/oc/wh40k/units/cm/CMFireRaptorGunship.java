package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CMFireRaptorGunship extends Eintrag {
        
	OptionsUpgradeGruppe o2;
	
    public CMFireRaptorGunship() {
		name = "Fire Raptor Gunship";
		grundkosten = 220;

        add(ico = new oc.Picture("oc/wh40k/images/SMCybot.jpg"));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured Ceramite", 20));
        
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Quad bolters", 0));
		ogE.addElement(new OptionsGruppeEintrag("Reaper battery", 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);
		
		complete();
	}

	@Override
	public void refreshen() {
        if(!o2.isSelected()){
        	o2.setSelected(0, true);
        }
	}
	
}
