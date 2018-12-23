package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORWarbossinMegaArmour extends Eintrag {

    private final RuestkammerStarter waffen;

    public ORWarbossinMegaArmour() {
        name = "Warboss in Mega Armour";
        grundkosten = getPts("Warboss in Mega Armour");
        power = 7;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt,
                new ORWaffenUndGeschenke("Kustom shoota", "Power klaw", false, true, false, false, true, false, true, false), "");
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