package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

public class IMMinistorumPriest extends Eintrag {

    public IMMinistorumPriest() {
    	super(CHARACTER, INFANTRY, MINISTORUM_PRIEST);
    	
        name = "Ministorum Priest";
        grundkosten = getPts("Ministorum Priest") + getPts("Laspistol") + getPts("Frag grenades") + getPts("Krak grenades");
        power = 2;

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Autogun", getPts("Autogun")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chainsword", getPts("Chainsword")));
        
        seperator();
        
        addWeapons(IMAstraMilitarumRuestkammer.class, true);
                
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}