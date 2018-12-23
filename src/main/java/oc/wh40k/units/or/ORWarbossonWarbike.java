package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORWarbossonWarbike extends Eintrag {

    private final RuestkammerStarter waffen;

    public ORWarbossonWarbike() {
        name = "Warboss on Warbike";
        grundkosten = getPts("Warboss on Warbike");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Attack squig", getPts("Attack squig")));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt,
                new ORWaffenUndGeschenke("no weapon", "Big choppa", true, true, false, false, true, false, true, false));
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