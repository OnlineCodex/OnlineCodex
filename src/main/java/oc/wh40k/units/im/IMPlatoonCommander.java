package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMPlatoonCommander extends Eintrag {

    RuestkammerStarter kammer;

    public IMPlatoonCommander() {
        name = "Platoon Commander";
        grundkosten = getPts("Platoon Commander") + getPts("Frag grenade (AM)");
        power = 2;

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, IMAstraMilitarumRuestkammer.class, "");
        ((IMAstraMilitarumRuestkammer) kammer.getKammer()).setType("Platoon Commander");
        kammer.initKammer();
        kammer.setButtonText("Waffen");
        add(kammer);
        kammer.setAbwaehlbar(false);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) kammer.getPanel().getLocation().getY() + kammer.getPanel().getSize().height + 5
        );
    }
}