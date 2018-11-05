package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMXiphonPatternInterceptor extends Eintrag {

    public SMXiphonPatternInterceptor() {
        name = "Xiphon Pattern Interceptor";
        grundkosten = 205;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chaff launcher", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured cockpit", 5));

        complete();
    }

    @Override
    public void refreshen() {
    }

    @Override
    public void deleteYourself() {
    }

}
