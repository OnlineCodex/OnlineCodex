package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMLordCommissar extends Eintrag {

    private final RuestkammerStarter kammer;

    public IMLordCommissar() {
        name = "Lord Commissar";
        grundkosten = getPts("Lord Commissar");
        power = 4;

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, new IMAstraMilitarumRuestkammer("Lord Commissar"));
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