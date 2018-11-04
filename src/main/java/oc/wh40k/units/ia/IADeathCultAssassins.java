package oc.wh40k.units.ia;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IADeathCultAssassins extends Eintrag {

    AnzahlPanel squad;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkTransport;

    public IADeathCultAssassins() {
        name = "Death Cult Assassins\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Death Cult Assassin", 2, 10, 15);
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
