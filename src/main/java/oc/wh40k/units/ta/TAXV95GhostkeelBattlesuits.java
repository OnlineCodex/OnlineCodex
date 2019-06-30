package oc.wh40k.units.ta;




import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TAXV95GhostkeelBattlesuits extends Eintrag {

//	private final Vector<RuestkammerStarter> rk;
	private final OptionsUpgradeGruppe o5;

    public TAXV95GhostkeelBattlesuits() {
        name = "Ghostkeel Shas'vre";
        überschriftSetzen = true;
        grundkosten = getPts("XV95 Ghostkeel Battlesuit");

        add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));
        
        ogE.addElement(new OptionsGruppeEintrag("MV5 Stealth Drones", getPts("MV5 Stealth Drone") * 2));
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        addWeapons(TAKampfanzugKammer.class, true);
        
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        power = 10;
        o5.alwaysSelected();
    }
}
