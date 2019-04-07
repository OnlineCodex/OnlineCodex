package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class TATigerSharkAX10 extends Eintrag {

    public TATigerSharkAX10() {
        name = "Tiger Shark AX-1-0";
        grundkosten = 660;

        add(ico = new oc.Picture("oc/wh40k/images/TigerSharkAX10.jpg"));

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Seeker missiles", 6, 8));

        seperator();

        final RuestkammerStarter rk = new RuestkammerStarter(ID, randAbstand, cnt, TAFahrzeugKammer.class, "Rüstkammer");
        rk.initKammer(true, false);
        rk.setButtonText("Rüstkammer");
        add(rk);

        complete();
    }

}
