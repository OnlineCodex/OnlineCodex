package oc.wh40k.units.sm;

public class SMTheRedBrethren extends SMTerminatorAssaultSquad {

    public SMTheRedBrethren() {
        super();

        name = "The Red Brethren\n";
    }

    @Override
    public void refreshen() {
        super.refreshen();

        setUnikat(true);

        o1.setAktiv(false);
    }

}
