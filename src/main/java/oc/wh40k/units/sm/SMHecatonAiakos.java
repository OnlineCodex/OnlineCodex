package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMHecatonAiakos extends Eintrag {

	public SMHecatonAiakos() {
		name = "Hecaton Aiakos";
		grundkosten = 225;
		addToInformationVector("SMHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMCaptainCatoSicarius.gif"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		addToInformationVector("SMHQ", -1);
		super.deleteYourself();
	}
	
}
