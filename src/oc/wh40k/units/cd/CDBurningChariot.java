package oc.wh40k.units.cd;

public class CDBurningChariot extends CDHerold {

	public CDBurningChariot() {

		name = "Burning Chariot";
        grundkosten = getPts("Burning Chariot");
        power = 5;        
        
        complete();

	}

	@Override
	public void refreshen() {
            super.refreshen();
	}
}
