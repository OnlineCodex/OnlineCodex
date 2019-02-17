package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TABarracudaAX52 extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2, o3;
	private final OptionsZaehlerGruppe o4;
	
    public TABarracudaAX52() {
        name = "Barracuda AX-5-2";
        grundkosten = getPts("Barracuda AX-5-2");

        add(ico = new oc.Picture("oc/wh40k/images/TigerSharkAX10.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Heavy burst cannon", getPts("Heavy burst cannon FW")));
        ogE.addElement(new OptionsGruppeEintrag("Ion cannon", getPts("Ion cannon FW")));
        ogE.addElement(new OptionsGruppeEintrag("Swiftstrike railgun", getPts("Swiftstrike railgun")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Two long-barrelled burst cannon", getPts("Long-barrelled burst cannon")*2));
        ogE.addElement(new OptionsGruppeEintrag("Two cyclic ion blasters", getPts("Cyclic ion blaster")*2));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Two missile pods", getPts("Missile pod")*2));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o3.setSelected(0, true);
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Seeker missile", getPts("Seeker missile")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        
        complete();
    }
    
    @Override
    public void refreshen() {
    	o1.alwaysSelected();
    	o2.alwaysSelected();
    	o3.alwaysSelected();
    }

}
