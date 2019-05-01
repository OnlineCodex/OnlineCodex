package oc.wh40k.units.ae;

import static oc.KeyWord.AELDARI;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.HARLEQUINS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.SHADOWSEER;

import oc.BuildaHQ;
import oc.Eintrag;

public class AEShadowseer extends Eintrag {

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

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}