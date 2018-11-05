package oc.wh40k.units.cs;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CSZhufor extends Eintrag {

    RuestkammerStarter rkTermis;

    public CSZhufor() {
        name = "Zhufor";
        grundkosten = 175;

        add(ico = new oc.Picture("oc/wh40k/images/CSZhufor.jpg"));


        seperator();

        rkTermis = new RuestkammerStarter(ID, randAbstand, cnt, "CSZhuforGefolgeKammer", "", 1);
        rkTermis.initKammer();
        rkTermis.setButtonText("Terminatoren-Gefolge");
        rkTermis.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rkTermis);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
