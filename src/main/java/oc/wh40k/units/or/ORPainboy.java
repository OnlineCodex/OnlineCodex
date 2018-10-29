package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORPainboy extends Eintrag {
    OptionsEinzelUpgrade grotorderly;
    RuestkammerStarter waffen;
    
    boolean megaBool=false;

    public ORPainboy() {
        name = "Painboy";
        grundkosten = getPts("Painboy") + getPts("'Urty syringe");
        power = 6;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));

        add(grotorderly = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot orderly", getPts("Grot orderly")));
       
        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setDefaultFK("no weapon");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setDefaultNK("Power Klaw");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setKillsawNK(true);
        waffen.initKammer(false,false,false,false,false,false,true,false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
        complete();
    }

    @Override
    public void refreshen() {
    	
    }
    
    @Override
    public void deleteYourself() {
    	addToInformationVector("ORHQ", -1);
        super.deleteYourself();
    }

}
