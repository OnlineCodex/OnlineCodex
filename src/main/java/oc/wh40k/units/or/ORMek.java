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
        power = 2;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));
     
        seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot oiler", getPts("Grot oiler")));
       
        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setDefaultFK("Kustom mega-slugga");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setKillsawNK(true);
        waffen.initKammer(false,false,false,false,false,false,true,false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
        complete();
    }

    @Override
    public void refreshen() {}

}
