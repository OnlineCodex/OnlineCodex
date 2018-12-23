package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_NURGLE;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHGreatUncleanOne extends Eintrag {

    public CHGreatUncleanOne() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, MONSTER, PSYKER, GREAT_UNCLEAN_ONE);

        name = "Great Unclean One";
        grundkosten = 0;
        power = 12;

        ogE.addElement(new OptionsGruppeEintrag("Bilesword and bileblade", getPts("Great Unclean one with Bilesword and bileblade")));
        ogE.addElement(new OptionsGruppeEintrag("Bilesword and plague fail", getPts("Great Unclean one with Bilesword and plague fail")));
        ogE.addElement(new OptionsGruppeEintrag("Doomsday bell and bileblade", getPts("Great Unclean one with Doomsday bell and bileblade")));
        ogE.addElement(new OptionsGruppeEintrag("Doomsday bell and plague fail", getPts("Great Unclean one with Doomsday bell and plague fail")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, DISCIPLINE_OF_NURGLE), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("", NURGLE);

        complete();

    }
}
