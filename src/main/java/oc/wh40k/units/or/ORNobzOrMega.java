package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORNobzOrMega extends Eintrag {
    RuestkammerStarter PikkUp;
    RuestkammerStarter Kampfpanza;

    public ORNobzOrMega() {
        grundkosten = 0;
        überschriftSetzen = false;

        seperator();

        PikkUp = new RuestkammerStarter(ID, randAbstand, cnt, ORNobzKammer.class, "Nobz", 1);
        PikkUp.initKammer();
        add(PikkUp);

        Kampfpanza = new RuestkammerStarter(ID, randAbstand, cnt, ORMeganobzKammer.class, "Meganobz", 1);
        Kampfpanza.initKammer();
        add(Kampfpanza);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        PikkUp.setAktiv(!Kampfpanza.isSelected());
        Kampfpanza.setAktiv(!PikkUp.isSelected());
        Kampfpanza.getPanel().setLocation((int) Kampfpanza.getPanel().getLocation().getX(), (int) PikkUp.getPanel().getLocation().getY() + PikkUp.getPanel().getSize().height);

        PikkUp.setLegal(PikkUp.isSelected() || Kampfpanza.isSelected());
        Kampfpanza.setLegal(PikkUp.isSelected() || Kampfpanza.isSelected());
    }

}
