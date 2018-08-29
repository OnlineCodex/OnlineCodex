package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class CHChaosSokarPatternStormbirdGunship extends Eintrag {

	OptionsUpgradeGruppe o1, claws;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o3,o4;
    OptionsUpgradeGruppe mark;
    
	public CHChaosSokarPatternStormbirdGunship() {
		name = "Chaos Sokar Pattern Stormbird Gunship";
		grundkosten = getPts("Chaos Sokar Pattern Stormbird Gunship");

		add(ico = new oc.Picture("oc/wh40k/images/Höllendrache.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("4 Twin lascannon", getPts("Twin lascannon")*4));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")*3));
		ogE.addElement(new OptionsGruppeEintrag("Reaper battery", getPts("Reaper battery")));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,3));
		o2.setAnzahl(0, 3);
		
        seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Dreadstrike missiles", getPts("Dreadstrike missiles")));
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
		o1.alwaysSelected();
		o3.alwaysSelected();
		
		power = 50;
	}

}
