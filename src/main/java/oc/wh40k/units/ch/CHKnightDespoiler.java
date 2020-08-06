package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHKnightDespoiler extends Eintrag {

	private final OptionsUpgradeGruppe laser, thunder, stubber;

    public CHKnightDespoiler() {

        kategorie = 1;

        name = "Knight Despoiler";
        grundkosten = getPts("Knight Despoiler");

        ogE.addElement(new OptionsGruppeEintrag("Reaper chainsword", getPts("Reaper chainsword")));
        ogE.addElement(new OptionsGruppeEintrag("Thermal cannon", getPts("Thermal cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Avenger gatling cannon & HF", getPts("Avenger gatling cannon") + getPts("Heavy flamer (other)")));
        ogE.addElement(new OptionsGruppeEintrag("Rapid-fire battle cannon & HS", getPts("Rapid-fire battle cannon") + getPts("Heavy stubber")));
        add(laser = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Thunderstrike gauntlet", getPts("Thunderstrike gauntlet")));
        ogE.addElement(new OptionsGruppeEintrag("Thermal cannon", getPts("Thermal cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Avenger gatling cannon & HF", getPts("Avenger gatling cannon") + getPts("Heavy flamer (other)")));
        ogE.addElement(new OptionsGruppeEintrag("Rapid-fire battle cannon & HS", getPts("Rapid-fire battle cannon") + getPts("Heavy stubber")));
        add(thunder = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        add(stubber = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ironstorm missile pod", getPts("Ironstorm missile pod")));
        ogE.addElement(new OptionsGruppeEintrag("Stormspear rocket pod", getPts("Stormspear rocket pod")));
        ogE.addElement(new OptionsGruppeEintrag("Twin icarus autocannon", getPts("Twin icarus autocannon")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        power = 23;

        complete();
    }


    @Override
    public void refreshen() {
    	laser.alwaysSelected();
    	thunder.alwaysSelected();
    	stubber.alwaysSelected();
    	
    	if(laser.isSelected("Reaper chainsword") && thunder.isSelected("Thunderstrike gauntlet")) {
    		grundkosten = getPts("Knight Despoiler with 1 reaper chainsword and 1 thunderstrike gauntlet");
    	} else {
    		grundkosten = getPts("Knight Despoiler");
    	}
    }
}
