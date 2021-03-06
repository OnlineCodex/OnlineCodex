package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.ae.AEAutarchWeaponsDouble;

public class TATigerSharkAX10 extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2, o3;
	private final OptionsZaehlerGruppe o4;

    public TATigerSharkAX10() {
        name = "Tiger Shark AX-1-0";
        grundkosten = getPts("Tiger Shark AX-1-0");

        add(ico = new oc.Picture("oc/wh40k/images/TigerShark.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("2 rail cannons", getPts("Rail cannon")*2));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("2 burst cannons", getPts("Burst cannon")*2));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("2 missile pods", getPts("Missile pod")*2));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Seeker missiles", getPts("Seeker missile")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 6));

        seperator();

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
        
        power = 30;
    }

}
