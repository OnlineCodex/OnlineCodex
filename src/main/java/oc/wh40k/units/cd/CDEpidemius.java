package oc.wh40k.units.cd;


public class CDEpidemius extends CDHerold {

    public CDEpidemius() {

        name = "Epidemius";
        grundkosten = getPts("Epidemius");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/CDEpidemius.gif"));

        complete();

    }

    @Override
    public void refreshen() {
        super.refreshen();
        setUnikat(true);
    }
}
