package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CHSorcereronDiscofTzeentch extends Eintrag {

	private final RuestkammerStarter waffen;

    public CHSorcereronDiscofTzeentch() {

        name = "Sorcerer on Disc of Tzeentch";
        grundkosten = getPts("Sorcerer on Disc of Tzeentch");
        power = 8;

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultRanged("Bolt pistol");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultCloceCombat("Force sword");
        ((CHWaffenkammer) waffen.getKammer()).setSorcerer(true);
        waffen.initKammer(true, true, true, false);
        waffen.setButtonText("Waffenkammer");
        waffen.setUeberschriftTrotzNullKostenAusgeben(true);
        add(waffen);
        waffen.setAbwaehlbar(false);

        seperator();

        addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }
}
