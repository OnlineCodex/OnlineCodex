package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCompanyCommander extends Eintrag {

    private final RuestkammerStarter kammer;

    public IMCompanyCommander() {
        name = "Company Commander";
        grundkosten = getPts("Company Commander") + getPts("Frag grenade (AM)");
        power = 3;

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, new IMAstraMilitarumRuestkammer(name), "");
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