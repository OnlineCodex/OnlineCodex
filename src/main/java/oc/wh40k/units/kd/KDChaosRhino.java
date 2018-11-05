package oc.wh40k.units.kd;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class KDChaosRhino extends Eintrag {
    RuestkammerStarter ausruestung;

    public KDChaosRhino() {
        name = "Rhino";
        grundkosten = 35;

        add(ico = new oc.Picture("oc/wh40k/images/SWEhrwuerdigerCybot.jpg"));

        seperator();

        ausruestung = new RuestkammerStarter(ID, randAbstand, cnt, "KDFahrzeugruestkammer", "Ausrüstung");
        ausruestung.initKammer(false);
        ausruestung.setButtonText("Ausrüstung");
        add(ausruestung);

        complete();
    }

    @Override
    public void refreshen() {
    }
}
