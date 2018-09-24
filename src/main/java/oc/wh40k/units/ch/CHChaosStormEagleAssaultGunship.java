package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHChaosStormEagleAssaultGunship extends Eintrag {

	OptionsUpgradeGruppe o1, claws;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe mark;
    
	public CHChaosStormEagleAssaultGunship() {
		name = "Chaos Storm Eagle Assault Gunship";
		grundkosten = getPts("Chaos Storm Eagle Assault Gunship");

		add(ico = new oc.Picture("oc/wh40k/images/Höllendrache.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));
		ogE.addElement(new OptionsGruppeEintrag("Twin multi-melta", getPts("Twin multi-melta")));
		ogE.addElement(new OptionsGruppeEintrag("Reaper autocannon", getPts("Reaper autocannon")));
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", getPts("Havoc launcher")));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
        seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Hellstrike missiles", getPts("Hellstrike missiles")));
		ogE.addElement(new OptionsGruppeEintrag("Balefire missiles", getPts("Balefire missiles")));
		ogE.addElement(new OptionsGruppeEintrag("2 twin lascannon", getPts("Twin lascannon")*2));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
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
		o2.alwaysSelected();
		o3.alwaysSelected();
		
		power = 18;
	}

}
