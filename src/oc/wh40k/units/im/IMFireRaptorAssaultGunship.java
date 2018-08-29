package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMFireRaptorAssaultGunship extends Eintrag {
        
	OptionsUpgradeGruppe o2;
	
    public IMFireRaptorAssaultGunship() {
		name = "Fire Raptor Assault Gunship";
		grundkosten = 225;

        add(ico = new oc.Picture("oc/wh40k/images/SMCybot.jpg"));

        seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Quad bolters", 0));
		ogE.addElement(new OptionsGruppeEintrag("TL autocannon", 0));
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
