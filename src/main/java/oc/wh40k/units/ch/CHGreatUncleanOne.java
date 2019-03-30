package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHGreatUncleanOne extends Eintrag {

	private final OptionsUpgradeGruppe o1;
	private final RuestkammerStarter psychicPowers;

    public CHGreatUncleanOne() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, MONSTER, PSYKER, GREAT_UNCLEAN_ONE);

        name = "Great Unclean One";
        grundkosten = 0;
        power = 17;

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Bilesword and bileblade", getPts("Great Unclean one with Bilesword and bileblade")));
        ogE.addElement(new OptionsGruppeEintrag("Bilesword and plague fail", getPts("Great Unclean one with Bilesword and plague fail")));
        ogE.addElement(new OptionsGruppeEintrag("Doomsday bell and bileblade", getPts("Great Unclean one with Doomsday bell and bileblade")));
        ogE.addElement(new OptionsGruppeEintrag("Doomsday bell and plague fail", getPts("Great Unclean one with Doomsday bell and plague fail")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableNurgle();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("", NURGLE);

        complete();
    }
    
    @Override
    public void refreshen() {
    	o1.alwaysSelected();
    }
}
