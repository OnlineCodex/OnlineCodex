package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMChaplain extends Eintrag {
    OptionsEinzelUpgrade jump;

    public IMChaplain() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, CHAPLAIN);
        name = "Chaplain";
        grundkosten = getPts("Chaplain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Crozius arcanum");

        seperator();

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Chaplain with Jump Pack") - getPts("Chaplain")));

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

