package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.GREY_KNIGHTS;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.LIBRARIAN;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.TERMINATOR;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMLibrarianGK extends Eintrag {
	private final RuestkammerStarter psychicPowers;

    public IMLibrarianGK() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, GREY_KNIGHTS, CHARACTER, INFANTRY, PSYKER, LIBRARIAN, TERMINATOR);

        name = "Librarian GK";
        grundkosten = getPts("Librarian GK");
        power = 9;

        seperator();

        addWeapons(IMGreyKnightsRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableSanctic();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    	psychicPowers.getPanel().setLocation(
                (int) psychicPowers.getPanel().getLocation().getX(),
                (int) getWeapons().getPanel().getLocation().getY() + getWeapons().getPanel().getSize().height + 5
        );
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
