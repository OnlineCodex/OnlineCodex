package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMMinotaurusChaplainIvanusEnkomi extends Eintrag {

	public SMMinotaurusChaplainIvanusEnkomi() {
		name = "Minotaurus Chaplain Ivanus Enkomi";
		grundkosten = 145;

		add(ico = new oc.Picture("oc/wh40k/images/SMCaptainCatoSicarius.gif"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
}
