package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.RuestkammerStarter;

public class SMThunderfireCannons extends Eintrag {

    RuestkammerStarter rkPod;
    AnzahlPanel squad;

    public SMThunderfireCannons() {
        name = "Thunderfire-Cannons";
        grundkosten = 0;

        addToInformationVector("Thunderfire-Cannons", 1);

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Thunderfire-Cannon", "Thunderfire-Cannons", 1, 3, 100);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/SMSalvenkanone.jpg"));

        seperator();

        rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SMDropPodKammer", "Landungskapsel");
        rkPod.initKammer(false);
        rkPod.setButtonText("Landungskapsel");
        rkPod.setSeperator(0);
        add(rkPod);

        complete();
    }

    @Override
    public void refreshen() {
        rkPod.setAktiv(squad.getModelle() == 1);

        //Detachments
        boolean max1Error = false;
        if (getCountFromInformationVector("Armoured Task Force") > 0) {
            int i = getCountFromInformationVector("Thunderfire-Cannons");
            if (i > 3) {
                max1Error = true;
            }
        }

        //Errors
        if (max1Error) {
            setFehlermeldung("0-3");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("Thunderfire-Cannons", -1);
        super.deleteYourself();
    }

}
