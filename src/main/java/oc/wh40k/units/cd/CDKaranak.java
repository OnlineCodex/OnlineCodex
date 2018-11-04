package oc.wh40k.units.cd;

public class CDKaranak extends CDHerold {

    public CDKaranak() {

        name = "Karanak";
        grundkosten = getPts("Karanak");
        power = 6;

        complete();

    }

    @Override
    public void refreshen() {
        super.refreshen();
        setUnikat(true);
    }
}
