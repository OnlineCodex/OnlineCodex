package oc.wh40k.units.im;

import static oc.KeyWord.*;
import static oc.wh40k.units.im.ImperiumUtils.getPsychicPowerGroug;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMLibrarian extends Eintrag {

    private final OptionsEinzelUpgrade jump;
    private final RuestkammerStarter psychicPowers;

    public IMLibrarian() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, PSYKER, LIBRARIAN);
        name = "Librarian";
        grundkosten = getPts("Librarian") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Librarian with Jump Pack") - getPts("Librarian")));

        seperator();
        
        addWeapons(new IMSpaceMarinesRuestkammer("Librarian", getKeywords()), true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, getPsychicPowerGroug(checkBuildaVater())), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(false);
        add(psychicPowers);

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 6 + (jump.isSelected() ? 1 : 0);
        
        if(((IMSpaceMarinesRuestkammer) weapons.getKammer()).jump != jump.isSelected()){
        	((IMSpaceMarinesRuestkammer) weapons.getKammer()).jump = jump.isSelected();
        	((IMSpaceMarinesRuestkammer) weapons.getKammer()).refreshen();
        }
    }
}