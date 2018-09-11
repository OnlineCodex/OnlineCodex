package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORMek extends Eintrag {

    RuestkammerStarter waffen;
    
    boolean megaBool=false;

    public ORMek() {
        name = "Mek";
        grundkosten = getPts("Mek") + getPts("Stikkbombs");
        power = 3;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));
     
        seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot oiler", getPts("Grot oiler")));
       
        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setKillsawNK(true);
        waffen.initKammer(false,false,true,false,false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
        complete();
    }

    @Override
    public void refreshen() {}

}
