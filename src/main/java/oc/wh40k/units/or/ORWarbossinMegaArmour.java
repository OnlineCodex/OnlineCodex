package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORWarbossinMegaArmour extends Eintrag {

    OptionsEinzelUpgrade attacksquig;
    RuestkammerStarter waffen;
    
    boolean megaBool=false;
    boolean gazzBool=false;

    public ORWarbossinMegaArmour() {
        name = "Warboss in Mega Armour";
        grundkosten = getPts("Warboss in Mega Armour");
        power = 7;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));
        
        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setDefaultFK("Kustom shoota");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setDefaultNK("Power klaw");
        waffen.initKammer(false,true,false,false,true,false,true,false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
        complete();
    }

    @Override
    public void refreshen() {}
}