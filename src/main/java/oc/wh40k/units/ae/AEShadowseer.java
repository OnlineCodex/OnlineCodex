package oc.wh40k.units.ae;

import static oc.KeyWord.AELDARI;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.HARLEQUINS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.SHADOWSEER;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class AEShadowseer extends Eintrag {
	private final RuestkammerStarter psychicPowers;
	
    public AEShadowseer() {
    	super(AELDARI, CHARACTER, HARLEQUINS, INFANTRY, PSYKER, SHADOWSEER);

        name = "Shadowseer";
        grundkosten = getPts("Shadowseer");
        power = 7;

        seperator();

        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Ynnari"))
        	addWeapons(AEYnnariRuestkammer.class, true);
        else
        	addWeapons(AEHarlequinsRuestkammer.class, true);
        
        seperator();
        
        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Ynnari"))
        	((PsychicPowers) psychicPowers.getKammer()).enableRevenant();
        else
        	((PsychicPowers) psychicPowers.getKammer()).enablePhantasmancy();
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
    }
}