package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHDefiler extends Eintrag {

	OptionsUpgradeGruppe o1, o2, fkwaffen;
	RuestkammerStarter ausruestung;
    OptionsUpgradeGruppe mark;
    
	public CHDefiler() {
		name = "Defiler";
		grundkosten = getPts("Defiler");

		add(ico = new oc.Picture("oc/wh40k/images/Klauenmonstrum.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Twin heavy flamer", getPts("Twin heavy flamer")));
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", getPts("Havoc launcher")));
		ogE.addElement(new OptionsGruppeEintrag("Defiler scourge", getPts("Defiler scourge")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Reaper autocannon", getPts("Reaper autocannon")));
		ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));
		ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);
		
		seperator();
		
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
		if(!o1.isSelected()) o1.setSelected(0, true);
		if(!o2.isSelected()) o2.setSelected(0, true);
		
		power = 16;
	}

}
