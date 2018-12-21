package oc.wh40k.units.necrons;


import oc.Eintrag;

public class NETranscendentCtan extends Eintrag {


    public NETranscendentCtan() {
        name = "Transcendent C'tan";
        grundkosten = getPts("Transcendent C'tan") + getPts("Crackling tendrils");
        power = 12;
        add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));
        
        seperator();

        addWarlordTraits("", false);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
