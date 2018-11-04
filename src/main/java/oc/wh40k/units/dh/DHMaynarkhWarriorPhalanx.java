package oc.wh40k.units.dh;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DHMaynarkhWarriorPhalanx extends Eintrag {

    AnzahlPanel squad;
    RuestkammerStarter rkTransport;

    public DHMaynarkhWarriorPhalanx() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Necron-Krieger", 10, 20, 13);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/NEKrieger.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flensing scrarabs", 10));

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DHTransporterKammer", "Transporter");
        rkTransport.initKammer(true, true);
        rkTransport.setButtonText("Transporter");
        add(rkTransport);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
