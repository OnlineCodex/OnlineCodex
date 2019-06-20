package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

//[IA Experimental]

public class TAKX139TaunarSupremacyArmour extends Eintrag {

	private final OptionsZaehlerGruppe o1;
	private final OptionsUpgradeGruppe o2, o3;
		
	public TAKX139TaunarSupremacyArmour() {
        name = "KX139 Ta'unar Supremacy Armour";
        grundkosten = getPts("KX139 Ta'unar Supremacy Armour");

        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Tri-axis ion cannon", "Arm-mounted tri-axis ion cannons", getPts("Arm-mounted tri-axis ion cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Fusion eradictor", getPts("Fusion eradictor"))); 
        add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));
        o1.setAnzahl(0, 2);
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Pulse ordnance multi-driver system", getPts("Pulse ordnance multi-driver system")));
        ogE.addElement(new OptionsGruppeEintrag("Nexus meteor missile system", getPts("Nexus meteor missile system"))); 
        ogE.addElement(new OptionsGruppeEintrag("Heavy rail cannon", getPts("Heavy rail cannon")));
        add(o2 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("4 burst cannon", getPts("Burst cannon")*4));
        add(o3 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));
      
        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
    	o2.alwaysSelected();
    	o3.alwaysSelected();
    	
    	power = 55;
    }

}
