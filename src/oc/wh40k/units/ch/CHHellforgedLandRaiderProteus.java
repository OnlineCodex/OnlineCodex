package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHHellforgedLandRaiderProteus extends Eintrag {

	RuestkammerStarter ausruestung;
	OptionsUpgradeGruppe fkwaffen, fkwaffen2;
    OptionsUpgradeGruppe mark;
    
    
	public CHHellforgedLandRaiderProteus() {
		name = "Hellforged Land Raider Proteus";
		grundkosten = getPts("Hellforged Land Raider Proteus") + getPts("Twin Lascannon") * 2;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosLandRaider.gif"));
		
		seperator();
		
        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Twin heavy flamer", getPts("Twin heavy flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        add(fkwaffen2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Accursed Phylactery", getPts("Accursed Phylactery")));
		
		seperator();
		
        ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", getPts("Havoc launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
        add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
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
		power = 19;
		
		fkwaffen2.alwaysSelected();
	}

}
