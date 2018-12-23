package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;

//[IA3 2nd Ed]

public class TAHazardKampfanzugteam extends Eintrag {

    RuestkammerStarter o1;
    RuestkammerStarter o2;
    RuestkammerStarter o3;

    public TAHazardKampfanzugteam() {
        name = "Hazard Kampfanzugteam";
        überschriftSetzen = true;
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/TAHazardKampfanzugteam.jpg"));


        o1 = new RuestkammerStarter(ID, randAbstand, cnt, new TAHazardKammer(), "Hazard Shas'vre");
        add(o1);

        o2 = new RuestkammerStarter(ID, randAbstand, cnt, new TAHazardKammer(), "Hazard Shas'vre");
        add(o2);

        o3 = new RuestkammerStarter(ID, randAbstand, cnt, new TAHazardKammer(), "Hazard Shas'vre");
        add(o3);

        complete();
    }

    @Override
    public void refreshen() {
        o2.getPanel().setLocation((int) o2.getPanel().getLocation().getX(), (int) o1.getPanel().getLocation().getY() + o1.getPanel().getSize().height);
        o3.getPanel().setLocation((int) o3.getPanel().getLocation().getX(), (int) o2.getPanel().getLocation().getY() + o2.getPanel().getSize().height);
    }
}
