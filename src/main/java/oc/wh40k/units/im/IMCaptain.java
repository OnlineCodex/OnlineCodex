package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMCaptain extends Eintrag {
    OptionsEinzelUpgrade jump;

    public IMCaptain() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, CAPTAIN);
    	
        name = "Captain";
        grundkosten = getPts("Captain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Captain with Jump Pack") - getPts("Captain")));

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 5 + (jump.isSelected() ? 1 : 0);
        
        if(((IMSpaceMarinesRuestkammer) weapons.getKammer()).jump != jump.isSelected()){
        	((IMSpaceMarinesRuestkammer) weapons.getKammer()).jump = jump.isSelected();
        	((IMSpaceMarinesRuestkammer) weapons.getKammer()).refreshen();
        }
    }
}
