package oc.wh40k.units.im;

import oc.*;

import java.util.Vector;

public class IMDeathwatchVanguardVeterans extends Eintrag {//Sternguard

	private final Vector<RuestkammerStarter> rk;

    public IMDeathwatchVanguardVeterans() {
        name = "Vanguard Veterans\n";
        grundkosten = 0;
        überschriftSetzen = true;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", getPts("Melta bombs")));

        seperator();

        rk = new Vector<RuestkammerStarter>();

        for (int i = 0; i < 10; i++) {
            rk.add(new RuestkammerStarter(ID, randAbstand, cnt, DeathWatchKammer.class, "Vanguard Veteran"));
            ((DeathWatchKammer) rk.get(i).getKammer()).setType("Vanguard Veteran");
            rk.lastElement().initKammer();
            rk.lastElement().setGrundkosten(getPts("Vanguard Veteran Squad with Jump Packs"));
            add(rk.lastElement());
        }

        for (int i = 0; i < 1; i++) {
            rk.get(i).setAbwaehlbar(false);
        }

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/SMProtektorgarde.jpg"));

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
