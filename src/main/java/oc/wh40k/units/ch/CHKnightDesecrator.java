package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHKnightDesecrator extends Eintrag {

	private final OptionsUpgradeGruppe laser, thunder, stubber;

    public CHKnightDesecrator() {

        kategorie = 1;

        name = "Knight Desecrator";
        grundkosten = getPts("Knight Desecrator");

        ogE.addElement(new OptionsGruppeEintrag("Laser destructor", getPts("Laser destructor")));
        add(laser = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Reaper chainsword", getPts("Reaper chainsword")));
        ogE.addElement(new OptionsGruppeEintrag("Thunderstrike gauntlet", getPts("Thunderstrike gauntlet")));
        add(thunder = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber")));
        add(stubber = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        power = 23;

        complete();
    }


    @Override
    public void refreshen() {
    	laser.alwaysSelected();
    	thunder.alwaysSelected();
    	stubber.alwaysSelected();
    }
}
