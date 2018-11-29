package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class ORKaptinBadrukk extends Eintrag {

    OptionsEinzelZaehler Munigrot;
    RuestkammerStarter warlord;

    public ORKaptinBadrukk() {

        kategorie = 1;
        name = "Kaptin Badrukk";
        grundkosten = getPts("Kaptin Badrukk");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/GhazghkullThraka.gif"));

        seperator();

        Munigrot = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Ammo runt", 1, getPts("Ammo runt"));
        add(Munigrot);

        seperator();
        
        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits) warlord.getKammer()).setPflichtauswahl("Freebooterz: Killa Reputation");
        add(warlord);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}
