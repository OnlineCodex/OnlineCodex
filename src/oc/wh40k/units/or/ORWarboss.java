package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORWarboss extends Eintrag {

    OptionsEinzelUpgrade attacksquig;
    RuestkammerStarter waffen;
    
    boolean megaBool=false;
    boolean gazzBool=false;

    public ORWarboss() {
        name = "Warboss";
        grundkosten = getPts("Warboss");
        power = 4;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));

        add(attacksquig = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Attack squig", getPts("Attack squig")));
        
        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setDefaultFK("Kustom shoota");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setDefaultNK("Big choppa");
        waffen.initKammer(true,true,false,false,true);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
        
        complete();
    }

    @Override
    public void refreshen() {}
}