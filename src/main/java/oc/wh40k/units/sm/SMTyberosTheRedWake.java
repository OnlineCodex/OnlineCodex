package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMTyberosTheRedWake extends Eintrag {

    boolean honourGuardSelected = false;
    boolean commandSquadSelected = false;

    public SMTyberosTheRedWake() {
        name = "Tyberos the Red Wake";
        grundkosten = 190;

        addToInformationVector("SMOnlyOneChapterMaster", 1);
        addToInformationVector("SMChapterMaster", 1);

        BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("The Red Brethren");

        add(ico = new oc.Picture("oc/wh40k/images/SMKorsarroKhan.gif"));

        complete();
    }

    @Override
    public void deleteYourself() {

        BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("The Red Brethren");

        addToInformationVector("SMChapterMaster", -1);
        addToInformationVector("SMOnlyOneChapterMaster", -1);

        super.deleteYourself();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

        if (getCountFromInformationVector("SMChapterMaster") > 1 && getCountFromInformationVector("SMOnlyOneChapterMaster") > 0) {
            setFehlermeldung("nur ein Ordensmeister");
        } else {
            setFehlermeldung("");
        }
    }
}
