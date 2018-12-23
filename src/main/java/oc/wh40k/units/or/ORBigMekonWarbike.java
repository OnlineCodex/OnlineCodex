package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORBigMekonWarbike extends Eintrag {

    private final RuestkammerStarter waffen;

    public ORBigMekonWarbike() {
        kategorie = 1;
        name = "Big Mek on Warbike";
        grundkosten = getPts("Big Mek on Warbike") + getPts("Stikkbombs");
        power = 6;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));

        ORWaffenUndGeschenke kammer = new ORWaffenUndGeschenke("", "", true, false, true, true, true, true, true, false);
        kammer.setKillsawNK(true);
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, kammer, "");
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