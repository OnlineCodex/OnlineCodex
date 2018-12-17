package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMMaster extends Eintrag {
    OptionsEinzelUpgrade jump;

    public IMMaster() {
    	super(TODO);
        name = "Master";
        grundkosten = getPts("Master") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Master with Jump Pack") - getPts("Master")));

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 5 + (jump.isSelected() ? 1 : 0);
    }
}
