package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORDeffkillaWartrike extends Eintrag {

    OptionsEinzelUpgrade attacksquig;
    RuestkammerStarter waffen;
    
    boolean megaBool=false;
    boolean gazzBool=false;

    public ORDeffkillaWartrike() {
        name = "Deffkilla Wartrike";
        grundkosten = getPts("Deffkilla Wartrike");
        power = 6;

        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setDefaultFK("no weapon");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setDefaultNK("no weapon");
        waffen.initKammer(false,false,false,false,false,false,true,false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
        complete();
    }

    @Override
    public void refreshen() {}
}