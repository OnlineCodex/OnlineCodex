package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCommissar extends Eintrag {

    private final RuestkammerStarter kammer;

    public IMCommissar() {
        name = "Commissar";
        grundkosten = getPts("Commissar");
        power = 2;

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, new IMAstraMilitarumRuestkammer("Commissar"));
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