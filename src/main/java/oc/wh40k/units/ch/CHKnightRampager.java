package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHKnightRampager extends Eintrag {

	private final OptionsUpgradeGruppe laser, thunder, stubber;

    public CHKnightRampager() {

        kategorie = 1;

        name = "Knight Rampager";
        grundkosten = getPts("Knight Rampager");

        ogE.addElement(new OptionsGruppeEintrag("Reaper chainsword", getPts("Reaper chainsword")));
        add(laser = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Thunderstrike gauntlet", getPts("Thunderstrike gauntlet")));
        add(thunder = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber")));
        add(stubber = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        power = 19;

        complete();
    }


    @Override
    public void refreshen() {
    	laser.alwaysSelected();
    	thunder.alwaysSelected();
    	stubber.alwaysSelected();
    }
}
