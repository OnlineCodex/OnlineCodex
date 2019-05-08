package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.KEEPER_OF_SECRETS;
import static oc.KeyWord.MONSTER;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.SLAANESH;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHShalaxiHelbane extends Eintrag {

	private final OptionsUpgradeGruppe o1;
	private final RuestkammerStarter psychicPowers;

    public CHShalaxiHelbane() {
        super(CHAOS, SLAANESH, DAEMON, CHARACTER, MONSTER, PSYKER, KEEPER_OF_SECRETS);

        name = "Shalaxi Helbane";
        grundkosten = getPts("Shalaxi Helbane");
        power = 14;

        ogE.addElement(new OptionsGruppeEintrag("Living whip", getPts("Living whip")));
        ogE.addElement(new OptionsGruppeEintrag("Shining aegis", getPts("Shining aegis")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableSlaanesh();
        ((PsychicPowers) psychicPowers.getKammer()).setSlaanesh(true);
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("Slaanesh: Quicksilver Duelist", SLAANESH);

        complete();

    }
    
    @Override
    public void refreshen() {
    	o1.alwaysSelected();
    }
}
