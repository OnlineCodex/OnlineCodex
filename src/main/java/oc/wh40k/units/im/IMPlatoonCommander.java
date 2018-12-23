package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMPlatoonCommander extends Eintrag {

    private final RuestkammerStarter kammer;

    public IMPlatoonCommander() {
        name = "Platoon Commander";
        grundkosten = getPts("Platoon Commander") + getPts("Frag grenade (AM)");
        power = 2;

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, new IMAstraMilitarumRuestkammer("Platoon Commander"));
        kammer.setButtonText("Waffen");
        kammer.setAbwaehlbar(false);
        add(kammer);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) kammer.getPanel().getLocation().getY() + kammer.getPanel().getSize().height + 5
        );
    }
}