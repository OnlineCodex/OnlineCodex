package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DKBombardBattery extends Eintrag {

    RuestkammerStarter t1;
    RuestkammerStarter t2;
    RuestkammerStarter t3;
    OptionsEinzelUpgrade oe2;

    public DKBombardBattery() {
        name = "Bombard Battery";
        grundkosten = 0;
        this.überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/IGHellhoundSquadron.jpg"));

        seperator();

        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 20));

        seperator();

        t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKBombard", "Bombard", 1);
        t1.initKammer();
        t1.setButtonText("Bombard");
        add(t1);

        seperator();

        t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKBombard", "Bombard", 1);
        t2.initKammer();
        t2.setButtonText("Bombard");
        add(t2);

        seperator();

        t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKBombard", "Bombard", 1);
        t3.initKammer();
        t3.setButtonText("Bombard");
        add(t3);

        complete();
    }

    @Override
    public void refreshen() {
        int tanks = t1.getSelectedAsInt() + t2.getSelectedAsInt() + t3.getSelectedAsInt();

        t1.setAbwaehlbar(false);

        t2.setAktiv(t1.isSelected());
        t3.setAktiv(t2.isSelected());

        t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
        t3.getPanel().setLocation(t3.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);

        oe2.setPreis(20 * tanks);
    }

}
