package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORWarboss extends Eintrag {

    OptionsEinzelUpgrade attacksquig;
    RuestkammerStarter waffen;

    boolean megaBool = false;
    boolean gazzBool = false;

    public ORWarboss() {
        name = "Warboss";
        grundkosten = getPts("Warboss") + getPts("Slugga") * 2 + getPts("Stikkbombs");
        power = 4;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));

        add(attacksquig = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Attack squig", getPts("Attack squig")));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setWarboss(true);
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultRanged("Kombi-weapon with rokkit-launcha");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultCloceCombat("Power klaw");
        waffen.initKammer(true, false, false, false, false, false, true);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
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