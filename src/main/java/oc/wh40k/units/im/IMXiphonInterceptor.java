//IA Adeptus Astartes
package oc.wh40k.units.im;

import oc.Eintrag;

public class IMXiphonInterceptor extends Eintrag {

    public IMXiphonInterceptor() {
        name = "Xiphon Interceptor";
        grundkosten = getPts("Xiphon Interceptor") + 2 * getPts("Twin lascannon") + getPts("Xiphon missile battery");
        power = 11;

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }
}
