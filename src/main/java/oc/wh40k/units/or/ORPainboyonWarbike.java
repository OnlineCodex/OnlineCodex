package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORPainboyonWarbike extends Eintrag {

    private final RuestkammerStarter waffen;

    public ORPainboyonWarbike() {
        name = "Painboy on Warbike";
        grundkosten = getPts("Painboy on Warbike") + getPts("'Urty syringe");
        power = 6;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));

        ORWaffenUndGeschenke kammer = new ORWaffenUndGeschenke("no weapon", "Power klaw", false, false, false, false, false, false, true, false);
        kammer.setKillsawNK(true);
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
