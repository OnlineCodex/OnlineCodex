package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORWarboss extends Eintrag {

    private final RuestkammerStarter waffen;

    public ORWarboss() {
        name = "Warboss";
        grundkosten = getPts("Warboss") + getPts("Slugga") * 2 + getPts("Stikkbombs");
        power = 4;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Attack squig", getPts("Attack squig")));

        seperator();

        ORWaffenUndGeschenke kammer = new ORWaffenUndGeschenke("Power klaw", "Kombi-weapon with rokkit-launcha", true, false, false, false, false, false, true, false);
        kammer.setWarboss(true);
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, kammer);
        waffen.setButtonText("Waffen und Geschenke");
        waffen.setAbwaehlbar(false);
        add(waffen);

        seperator();

		addWarlordTraits("", true);

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