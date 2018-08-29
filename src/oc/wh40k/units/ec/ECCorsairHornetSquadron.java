package oc.wh40k.units.ec;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ECCorsairHornetSquadron extends Eintrag {

    RuestkammerStarter h1;
    RuestkammerStarter h2;
    RuestkammerStarter h3;
    RuestkammerStarter h4;
    RuestkammerStarter h5;

    OptionsEinzelUpgrade oe1, oe2, oe3;
    
    public ECCorsairHornetSquadron() {
        name = "Corsair Hornet Squadron";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairHornetSquadron.jpg"));

        seperator();
        
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Corsair kinetic shroud", 15));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Chain snares", 5));
        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Corsair void burners", 5));
        
        seperator();
        
        h1 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairHornetKammer", "Hornet");
        h1.initKammer();
        add(h1);

        h2 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairHornetKammer", "Hornet");
        h2.initKammer();
        add(h2);

        h3 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairHornetKammer", "Hornet");
        h3.initKammer();
        add(h3);
        
        h4 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairHornetKammer", "Hornet");
        h4.initKammer();
        add(h4);
        
        h5 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairHornetKammer", "Hornet");
        h5.initKammer();
        add(h5);

        complete();

    }

    @Override
    public void refreshen() {
    	h1.setAbwaehlbar(false);
        
        int walkers = (h1.isSelected() ? 1 : 0) + (h2.isSelected() ? 1 : 0) + (h3.isSelected() ? 1 : 0) + 
        		(h4.isSelected() ? 1 : 0) + (h5.isSelected() ? 1 : 0);

        oe1.setModelle(walkers);
        oe2.setModelle(walkers);
        oe3.setModelle(walkers);
    }

}
