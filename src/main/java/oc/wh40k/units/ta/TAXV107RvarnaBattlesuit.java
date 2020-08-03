package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

//[IA Experimental]

public class TAXV107RvarnaBattlesuit extends Eintrag {

	private final OptionsUpgradeGruppe o1;
	private final OptionsZaehlerGruppe o2;
	
	public TAXV107RvarnaBattlesuit() {
        name = "XV107 R'varna Battlesuit";
        grundkosten = getPts("XV107 R'varna Battlesuit");

        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV84 Shielded Missile Drone", getPts("MV84 Shielded Missile Drone")));
        add(o2 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Two pulse submunitions cannon", getPts("Pulse submunitions cannon")*2));
        add(o1 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));
        o1.setSelected(0, true);
        
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Advanced targeting system", getPts("Advanced targeting system (Y'vahra und R'varna)")));
        ogE.addElement(new OptionsGruppeEintrag("Counterfire defence system", getPts("Counterfire defence system (Y'vahra und R'varna)")));
        ogE.addElement(new OptionsGruppeEintrag("Drone controller", getPts("Drone controller")));
        ogE.addElement(new OptionsGruppeEintrag("Early warning override", getPts("Early warning override (Ghostkeel Riptide and Stormsurge)")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-tracker", getPts("Multi-tracker")));
        ogE.addElement(new OptionsGruppeEintrag("Shield generator", getPts("Shield generator (Y'vahra und R'varna)")));
        ogE.addElement(new OptionsGruppeEintrag("Target lock", getPts("Target lock (Y'vahra und R'varna)")));
        ogE.addElement(new OptionsGruppeEintrag("Velocity tracker", getPts("Velocity tracker (Y'vahra und R'varna)")));
        add(new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 2));

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
    	o1.alwaysSelected();
    	
    	power = 19;
        if (o2.isSelected()) {
            power += 2;
        }
    }

}
