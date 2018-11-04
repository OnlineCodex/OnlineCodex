package oc.wh40k.units.ia;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IACrusaders extends Eintrag {

    AnzahlPanel squad;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkTransport;

    public IACrusaders() {
        name = "Crusaders\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Crusaders", 2, 10, 15);
        add(squad);

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "IATransporterKammer", "Transporter");
        rkTransport.initKammer(true, true, false);
        rkTransport.setButtonText("Transporter");
        add(rkTransport);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
