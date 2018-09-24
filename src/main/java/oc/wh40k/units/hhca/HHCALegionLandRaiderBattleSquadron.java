package oc.wh40k.units.hhca;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class HHCALegionLandRaiderBattleSquadron extends Eintrag {

	OptionsUpgradeGruppe o1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public HHCALegionLandRaiderBattleSquadron() {
		name = "Legion Land Raider Battle Squadron";
		grundkosten = 0;
        überschriftSetzen = true;

        seperator();        		
        ogE.addElement(new OptionsGruppeEintrag("Command tank", 25));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        		
        seperator();
		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "HHCARaiderKammer", "Legion Land Raider");
		t1.initKammer();
		t1.setAbwaehlbar(false);
		t1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(t1);

		seperator();
		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "HHCARaiderKammer", "Legion Land Raider");
		t2.initKammer();
		t2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(t2);

		seperator();
		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "HHCARaiderKammer", "Legion Land Raider");
		t3.initKammer();
		t3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(t3);

		complete();
	}

	
	public void refreshen() {
			int selections = t1.getSelectedAsInt() + t2.getSelectedAsInt() + t3.getSelectedAsInt();
            
            t1.setLegal(selections > 0);
            
            t1.setAktiv(t1.isSelected() || selections < 3);
            t2.setAktiv(t2.isSelected() || (t1.isSelected() && selections < 3));
            t3.setAktiv(t3.isSelected() || (t2.isSelected() && selections < 3));

            t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
            t3.getPanel().setLocation(t3.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);
            
            o1.setAktiv(selections == 3);
	}
	
		
	
			

}
