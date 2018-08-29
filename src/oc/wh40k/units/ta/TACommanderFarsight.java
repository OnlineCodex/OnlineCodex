package oc.wh40k.units.ta;

import oc.Eintrag;

public class TACommanderFarsight extends Eintrag {

    public TACommanderFarsight() {
        name = "Commander Farsight";
        grundkosten = getPts("Commander Farsight");
        
        add(ico = new oc.Picture("oc/wh40k/images/OShovah.gif"));    

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        power = 8;
    }
    
	//@OVERRIDE
	public void deleteYourself() {
		
		super.deleteYourself();
	}
    
}
