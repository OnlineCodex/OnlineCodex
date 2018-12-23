package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORDeffkillaWartrike extends Eintrag {

    private final RuestkammerStarter waffen;

    public ORDeffkillaWartrike() {
        name = "Deffkilla Wartrike";
        grundkosten = getPts("Deffkilla Wartrike");
        power = 6;

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, new ORWaffenUndGeschenke("no weapon", "no weapon", false, false, false, false, false, false, true, false));
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