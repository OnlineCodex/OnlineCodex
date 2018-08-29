package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMCaptainZhrukhalAndrocles extends Eintrag {

	public SMCaptainZhrukhalAndrocles() {
		name = "Captain Zhrukhal Androcles";
		grundkosten = 145;

		add(ico = new oc.Picture("oc/wh40k/images/SMKorsarroKhan.gif"));
                
		complete();
	}

	@Override
	public void refreshen() {
            setUnikat(true);
            
        }

}
