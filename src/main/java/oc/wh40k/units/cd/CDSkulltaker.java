package oc.wh40k.units.cd;

public class CDSkulltaker extends CDHerold {

    public CDSkulltaker() {

        name = "Skulltaker";
        grundkosten = getPts("Skulltaker");
        power = 5;
        complete();

    }

    @Override
    public void refreshen() {
        super.refreshen();
        setUnikat(true);
    }
}
