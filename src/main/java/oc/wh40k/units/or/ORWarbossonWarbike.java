package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORWarbossonWarbike extends Eintrag {

    OptionsEinzelUpgrade attacksquig;
    RuestkammerStarter waffen;
    
    boolean megaBool=false;
    boolean gazzBool=false;

    public ORWarbossonWarbike() {
        name = "Warboss on Warbike";
        grundkosten = getPts("Warboss on Warbike");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));

        add(attacksquig = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Attack squig", getPts("Attack squig")));
        
        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setDefaultFK("no weapon");
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