package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;

public class DAAzrael extends Eintrag {

    boolean troopAdd = false;

    public DAAzrael() {
        name = "Azrael";
        grundkosten = 215;

        add(ico = new oc.Picture("oc/wh40k/images/DAAzrael.gif"));

        seperator();

        addToInformationVector("DAHQ", 1);
        complete();
    }

    @Override
    public void deleteYourself() {
        if (!ally) {
            addToInformationVector("DADeathwing-Terminatortrupp", -1);
            addToInformationVector("DARavenwing-Angriffsschwadron", -1);
        }
        addToInformationVector("DAHQ", -1);

        if (getCountFromInformationVector("DADeathwing-Terminatortrupp") < 1) {
            BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Deathwing-Terminatortrupp");
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Deathwing-Terminatortrupp");
        }
        if (getCountFromInformationVector("DARavenwing-Angriffsschwadron") < 1) {
            BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Ravenwing-Angriffsschwadron");
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Ravenwing-Angriffsschwadron");
        }
        super.deleteYourself();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

        if (!troopAdd && !ally) {
            addToInformationVector("DADeathwing-Terminatortrupp", 1);
            addToInformationVector("DARavenwing-Angriffsschwadron", 1);

            BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Deathwing-Terminatortrupp");
            BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Deathwing-Terminatortrupp");
            BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Ravenwing-Angriffsschwadron");
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Ravenwing-Angriffsschwadron");
            troopAdd = true;
        }

        if (troopAdd && ally) {
            addToInformationVector("DADeathwing-Terminatortrupp", -1);
            addToInformationVector("DARavenwing-Angriffsschwadron", -1);

            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Deathwing-Terminatortrupp");
            BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Deathwing-Terminatortrupp");
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Ravenwing-Angriffsschwadron");
            BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Ravenwing-Angriffsschwadron");
        }
    }
}
