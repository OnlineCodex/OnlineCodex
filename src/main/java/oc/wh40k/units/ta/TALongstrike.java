package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

import java.util.Vector;

public class TALongstrike extends Eintrag {

    Vector<RuestkammerStarter> rk;
    RuestkammerStarter warlord;

    public TALongstrike() {
        name = "Longstrike";
        überschriftSetzen = true;
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

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits)warlord.getKammer()).setPflichtauswahl("T'au: Strength of Belief");
        add(warlord);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        
        warlord.getPanel().setLocation(
                (int) warlord.getPanel().getLocation().getX(),
                (int) rk.lastElement().getPanel().getLocation().getY() + rk.lastElement().getPanel().getSize().height + 5
        );
    }
}
