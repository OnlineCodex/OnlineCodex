package oc.wh40k.units.ta;

import java.util.Vector;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TATX7HammerheadGunships extends Eintrag {

	private OptionsUpgradeGruppe o2;
	private OptionsUpgradeGruppe o3;
	
    public TATX7HammerheadGunships() {
        name = "TX7 Hammerhead Gunship";
        überschriftSetzen = true;
        grundkosten = getPts("TX7 Fire Support Hammerhead Gunship");

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Railgun", getPts("Railgun")));
        ogE.addElement(new OptionsGruppeEintrag("Ion cannon", getPts("Ion cannon")));
        o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(o2);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 MV1 Gun Drones", getPts("MV1 Gun Drone") * 2 + getPts("Pulse carbine") * 4));
        ogE.addElement(new OptionsGruppeEintrag("2 Burst cannons", getPts("Burst cannon") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Smart missile systems", getPts("Smart missile system") * 2));
        o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(o3);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Seeker missile", getPts("Seeker missile")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();
    }

    @Override
    public void refreshen() {
        if (!o2.isSelected()) o2.setSelected(0, true);
        if (!o3.isSelected()) o3.setSelected(0, true);
        
        power = 10;
    }
}
