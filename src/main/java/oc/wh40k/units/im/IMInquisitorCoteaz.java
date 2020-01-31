package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;
import oc.wh40k.units.Warlordtraits;

public class IMInquisitorCoteaz extends Eintrag {
	private final RuestkammerStarter psychicPowers;

    public IMInquisitorCoteaz() {
    	super(IMPERIUM, INQUISITION, ORDO_MALLEUS);
        name = "Inquisitor Coteaz";
        grundkosten = getPts("Inquisitor Greyfax");
        power = 4;

        seperator();
        
        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setMalleus(true);
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableTelethesiaDiscipline();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
		addWarlordTraits("Ordo Malleus: Psychic Mastery", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        String selectedTrait = (((Warlordtraits)getWarlordtraits()).getSelectedTrait());
        System.out.print(selectedTrait);
        if(selectedTrait.equalsIgnoreCase("Ordo Malleus: Psychic Mastery")) {
        	((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(3);
        } else {
        	((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        }
    }

}
