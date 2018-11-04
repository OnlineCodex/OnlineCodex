package oc.wh40k.units.da;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DAVindicators extends Eintrag {

    RuestkammerStarter rkD1;
    RuestkammerStarter rkD2;
    RuestkammerStarter rkD3;

    public DAVindicators() {
        name = "Vindicators";

        addToInformationVector("Vindicators", 1);

        rkD1 = new RuestkammerStarter(ID, randAbstand, cnt, "DAVindicatorKammer", "Vindicator");
        rkD1.initKammer(true);
        add(rkD1);

        rkD2 = new RuestkammerStarter(ID, randAbstand, cnt, "DAVindicatorKammer", "Vindicator");
        rkD2.initKammer(true);
        add(rkD2);

        rkD3 = new RuestkammerStarter(ID, randAbstand, cnt, "DAVindicatorKammer", "Vindicator");
        rkD3.initKammer(true);
        add(rkD3);

        complete();
    }

    @Override
    public void refreshen() {

        //Detachments
        boolean max1Error = false;
        if (getCountFromInformationVector("Armoured Task Force") > 0) {
            int i = getCountFromInformationVector("Vindicators") + getCountFromInformationVector("Whirlwinds") + getCountFromInformationVector("Predators");
            if (i > 5 || i < 3) {
                max1Error = true;
            }
        }

        //Errors
        if (max1Error) {
            setFehlermeldung("3-5");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("Vindicators", -1);
        super.deleteYourself();
    }
}