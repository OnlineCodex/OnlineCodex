package oc.wh40k.units.ta;

import java.util.Vector;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TALongstrike extends Eintrag {

	private final Vector<RuestkammerStarter> rk;

    public TALongstrike() {
        name = "Longstrike";
        applyTitle = true;
        grundkosten = 0;
        power = 10;

        add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));


        seperator();

        rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 1; i++) {
            rk.add(new RuestkammerStarter(ID, randAbstand, cnt, TATX7HammerheadKammer.class, "Longstrike"));
            rk.lastElement().initKammer(false, false, false, false, false, false, true);
            rk.lastElement().setGrundkosten(getPts("Longstrike"));
            add(rk.lastElement());
        }

        rk.firstElement().setAbwaehlbar(false);

        seperator();

        addWarlordTraits("T'au: Strength of Belief");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);

        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) rk.lastElement().getPanel().getLocation().getY() + rk.lastElement().getPanel().getSize().height + 5
        );
    }
}
