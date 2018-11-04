package oc.wh40k.units.ne;


import oc.Eintrag;

public class NECtanShardoftheDeceiver extends Eintrag {


    public NECtanShardoftheDeceiver() {
        name = "C'tan Shard of the Deceiver";
        grundkosten = getPts("C'tan Shard of the Deceiver");

        add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));

        seperator();


        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        power = 12;
    }

}
