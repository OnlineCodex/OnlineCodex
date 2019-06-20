package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

//[APO 2]

public class TATigerSharkFighterBomber extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2, o3;

    public TATigerSharkFighterBomber() {
        name = "Tiger Shark";
        grundkosten = getPts("Tiger Shark Figther-Bomber");

        add(ico = new oc.Picture("oc/wh40k/images/TigerShark.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("2 ion cannons", getPts("Ion cannon")*2));
        ogE.addElement(new OptionsGruppeEintrag("2 heavy burst cannon", getPts("Heavy burst cannon")*2));
        ogE.addElement(new OptionsGruppeEintrag("2 Swiftstrike railguns", getPts("Swiftstrike railgun")*2));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("2 burst cannons", getPts("Burst cannon")*2));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("2 missile pods", getPts("Missile pod")*2));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "2 Skyspear missile racks", getPts("Skyspear missile rack")*2));

        seperator();

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
        
        power = 21;
    }

}
