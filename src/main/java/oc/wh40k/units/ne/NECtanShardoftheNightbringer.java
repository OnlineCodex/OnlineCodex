package oc.wh40k.units.ne;


import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class NECtanShardoftheNightbringer extends Eintrag {
	
    RuestkammerStarter warlord;

    public NECtanShardoftheNightbringer() {
        name = "C'tan Shard of the Nightbringer";
        grundkosten = getPts("C'tan Shard of the Nightbringer");
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
        setUnikat(true);
    }
}
