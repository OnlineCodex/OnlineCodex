package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMDreadclaw extends Eintrag {


	public CMDreadclaw() {
                name = "Dreadclaw";
                grundkosten = 85;

                add(ico = new oc.Picture("oc/wh40k/images/Ahriman.gif"));


                complete();
	}

	@Override
	public void refreshen() {
	}

}
