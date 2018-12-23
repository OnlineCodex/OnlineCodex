package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORMek extends Eintrag {

    private final RuestkammerStarter waffen;

    public ORMek() {
        name = "Mek";
        grundkosten = getPts("Mek") + getPts("Stikkbombs");
        power = 2;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot oiler", getPts("Grot oiler")));

        seperator();

        ORWaffenUndGeschenke kammer = new ORWaffenUndGeschenke("Kustom mega-slugga", "", false, false, false, false, false, false, true, false);
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