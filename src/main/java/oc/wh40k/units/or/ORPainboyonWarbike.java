package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class ORPainboyonWarbike extends Eintrag {
    OptionsEinzelUpgrade grotorderly;
    RuestkammerStarter waffen;
    RuestkammerStarter warlord;

    boolean megaBool = false;

    public ORPainboyonWarbike() {
        name = "Painboy on Warbike";
        grundkosten = getPts("Painboy on Warbike") + getPts("'Urty syringe");
        power = 6;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultFK("no weapon");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultNK("Power klaw");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setKillsawNK(true);
        waffen.initKammer(false, false, false, false, false, false, true, false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);

        complete();
    }

    @Override
    public void refreshen() {
    	warlord.getPanel().setLocation(
                (int) warlord.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }

}
