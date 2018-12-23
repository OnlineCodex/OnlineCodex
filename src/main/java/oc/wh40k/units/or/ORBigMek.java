package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORBigMek extends Eintrag {

    OptionsEinzelUpgrade grotoiler;
    RuestkammerStarter waffen;

    boolean megaBool = false;
    boolean gazzBool = false;

    public ORBigMek() {
        kategorie = 1;
        name = "Big Mek";
        grundkosten = getPts("Big Mek") + getPts("Stikkbombs");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));

        add(grotoiler = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot oiler", getPts("Grot oiler")));

        seperator();

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
