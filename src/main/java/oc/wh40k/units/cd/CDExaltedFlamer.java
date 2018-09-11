package oc.wh40k.units.cd;

public class CDExaltedFlamer extends CDHerold {

	public CDExaltedFlamer() {

		name = "Exalted Flamer";
        grundkosten = getPts("Exalted Flamer");
        power = 4;        
        
        complete();

	}

	@Override
	public void refreshen() {
            super.refreshen();
	}
}
