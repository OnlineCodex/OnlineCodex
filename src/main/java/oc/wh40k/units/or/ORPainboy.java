package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORPainboy extends Eintrag {

    private final RuestkammerStarter waffen;

    public ORPainboy() {
        name = "Painboy";
        grundkosten = getPts("Painboy") + getPts("'Urty syringe");
        power = 3;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt,
                new ORWaffenUndGeschenke("no weapon", "Power klaw", false, false, false, false, false, false, true, false));
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