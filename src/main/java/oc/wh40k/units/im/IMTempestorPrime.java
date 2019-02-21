package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMTempestorPrime extends Eintrag {

	private final RuestkammerStarter kammer;

    public IMTempestorPrime() {
        name = "Tempestor Prime";
        grundkosten = getPts("Tempestor Prime") + getPts("Frag grenade (AM)") + getPts("Krak grenade (AM)");
        power = 2;

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, IMAstraMilitarumRuestkammer.class, "");
        ((IMAstraMilitarumRuestkammer) kammer.getKammer()).setType("Temperstor Prime");
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