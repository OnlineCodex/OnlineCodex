package oc.wh40k.units.ec;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ECCorsairNightwing extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe;
	
    public ECCorsairNightwing() {
//        name = "Nightwing Interceptor";
        grundkosten = 0;
        
        add(ico = new oc.Picture("oc/wh40k/images/ECNightwingInterceptor.jpg"));

        seperator();
        
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Nightwing Interceptor", 1, 2, 125);
        add(squad);
        
        seperator();
        
        add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Corsair kinetic shroud", 15));
        

        complete();
    }

    @Override
    public void refreshen() {
    	oe.setModelle(squad.getModelle());
    }
    
}
