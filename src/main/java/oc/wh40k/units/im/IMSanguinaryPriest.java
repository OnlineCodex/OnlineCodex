package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMSanguinaryPriest extends Eintrag {
    OptionsEinzelUpgrade jump;

    public IMSanguinaryPriest() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, SANGUINARY_PRIEST);
        name = "Sanguinary Priest";
        grundkosten = getPts("Sanguinary Priest") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Sanguinary Priest with Jump Pack") - getPts("Sanguinary Priest")));

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 4 + (jump.isSelected() ? 1 : 0);
        
        if(((IMSpaceMarinesRuestkammer) weapons.getKammer()).jump != jump.isSelected()){
        	((IMSpaceMarinesRuestkammer) weapons.getKammer()).jump = jump.isSelected();
        	((IMSpaceMarinesRuestkammer) weapons.getKammer()).refreshen();
        }
    }
}
