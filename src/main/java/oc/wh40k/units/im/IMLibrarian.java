package oc.wh40k.units.im;

import static oc.KeyWord.*;
import static oc.wh40k.units.im.ImperiumUtils.getPsychicPowerGroug;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMLibrarian extends Eintrag {

    private final OptionsEinzelUpgrade jump;

    public IMLibrarian() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, PSYKER, LIBRARIAN);
        name = "Librarian";
        grundkosten = getPts("Librarian") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Librarian with Jump Pack") - getPts("Librarian")));

        seperator();
        
        addWeapons(new IMSpaceMarinesRuestkammer("Librarian", getKeywords()), true);

        seperator();

        addPsychicPowers(2, getPsychicPowerGroug(checkBuildaVater()));

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