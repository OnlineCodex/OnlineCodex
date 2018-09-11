package oc.wh40k.units.cd;


public class CDExaltedFlamerofTzeentch extends CDHerold {

	
	public CDExaltedFlamerofTzeentch() {

		name = "Exalted Flamer of Tzeentch";

		grundkosten = 50;
		
		add(ico = new oc.Picture("oc/wh40k/images/CDHerolddesTzeentch.gif"));

		complete();

	}

	@Override
	public void refreshen() {
       
	}
}
