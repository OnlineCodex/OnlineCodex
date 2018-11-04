package oc.wh40k.units.dw;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

import java.util.Vector;

public class DWTerminators extends Eintrag {//Sternguard

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
    OptionsZaehlerGruppe o2x;
    OptionsZaehlerGruppe o2, o3;
    Vector<RuestkammerStarter> rk;

    public DWTerminators() {
        name = "Terminators\n";
        grundkosten = 0;
        überschriftSetzen = true;

        rk = new Vector<RuestkammerStarter>();

        for (int i = 0; i < 5; i++) {
            rk.add(new RuestkammerStarter(ID, randAbstand, cnt, "DWTerminator", "Terminator"));
            rk.lastElement().initKammer();
            rk.lastElement().setGrundkosten(40);
            add(rk.lastElement());
        }

        for (int i = 0; i < 1; i++) {
            rk.get(i).setAbwaehlbar(false);
        }

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/SMProtektorgarde.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}
