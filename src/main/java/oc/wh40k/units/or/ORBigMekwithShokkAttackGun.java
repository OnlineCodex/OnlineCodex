package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORBigMekwithShokkAttackGun extends Eintrag {

	OptionsEinzelUpgrade grotoiler;
    RuestkammerStarter waffen;
    
    boolean megaBool=false;
    boolean gazzBool=false;

    public ORBigMekwithShokkAttackGun() {
        kategorie = 1;
        name = "Big Mek";
        grundkosten = getPts("Big Mek") + getPts("Stikkbombs");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));

        add(grotoiler = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot oiler", getPts("Grot oiler")));
        
        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setKillsawNK(true);
        waffen.initKammer(true,false,true,true,true,true,true,false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {}

}
