package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORNobzOrMega extends Eintrag {

    private final RuestkammerStarter PikkUp;
    private final RuestkammerStarter Kampfpanza;

    public ORNobzOrMega() {
        kategorie = 2;
        grundkosten = 0;
        überschriftSetzen = false;

        seperator();

        PikkUp = new RuestkammerStarter(ID, randAbstand, cnt, new ORNobzKammer(), "Nobz", 1);
        add(PikkUp);

        Kampfpanza = new RuestkammerStarter(ID, randAbstand, cnt, new ORMeganobzKammer(), "Meganobz", 1);
        add(Kampfpanza);

        complete();
    }

    @Override
    public void refreshen() {
        PikkUp.setAktiv(!Kampfpanza.isSelected());
        Kampfpanza.setAktiv(!PikkUp.isSelected());
        Kampfpanza.getPanel().setLocation((int) Kampfpanza.getPanel().getLocation().getX(), (int) PikkUp.getPanel().getLocation().getY() + PikkUp.getPanel().getSize().height);

        PikkUp.setLegal(PikkUp.isSelected() || Kampfpanza.isSelected());
        Kampfpanza.setLegal(PikkUp.isSelected() || Kampfpanza.isSelected());
    }
}
