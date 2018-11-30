package oc.wh40k.units.ne;


import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class NETranscendentCtan extends Eintrag {

    RuestkammerStarter warlord;

    public NETranscendentCtan() {
        name = "Transcendent C'tan";
        grundkosten = getPts("Transcendent C'tan") + getPts("Crackling tendrils");
        power = 12;
        add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits)warlord.getKammer()).allowSubfactions(false);
        add(warlord);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
