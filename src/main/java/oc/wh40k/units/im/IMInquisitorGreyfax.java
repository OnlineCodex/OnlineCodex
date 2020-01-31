package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;
import oc.wh40k.units.Warlordtraits;

public class IMInquisitorGreyfax extends Eintrag {
	private final RuestkammerStarter psychicPowers;

    public IMInquisitorGreyfax() {
    	super(IMPERIUM, INQUISITION, ORDO_HERETICUS);
        name = "Inquisitor Greyfax";
        grundkosten = getPts("Inquisitor Greyfax");
        power = 5;

        seperator();
        
        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setHereticus(true);
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableTelethesiaDiscipline();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
		addWarlordTraits("Ordo Hereticus: No Escape", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        String selectedTrait = (((Warlordtraits)getWarlordtraits()).getSelectedTrait());
        System.out.print(selectedTrait);
        if(selectedTrait.equalsIgnoreCase("Ordo Malleus: Psychic Mastery")) {
        	((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        } else {
        	((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        }
    }

}
