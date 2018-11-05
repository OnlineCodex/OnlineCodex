package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMArmenneusValthex extends Eintrag {

    public SMArmenneusValthex() {
        name = "Armenneus Valthex";
        grundkosten = 145;

        addToInformationVector("SMArmenneusValthex", 1);
        addToInformationVector("SMMeisterderSchmiede", 1);
        addToInformationVector("SMTechmarineOderMeister", 1);

        add(ico = new oc.Picture("oc/wh40k/images/SMArmenneusValthex.gif"));

        if (getCountFromInformationVector("SMMeisterderSchmiede") == 1) {
            BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Ehrwürdiger Cybot");
            BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Cybot");
            BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Ironclad-Cybot");
        }

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        addToInformationVector("SMArmenneusValthex", -1);
        addToInformationVector("SMMeisterderSchmiede", -1);
        addToInformationVector("SMTechmarineOderMeister", -1);

        if (getCountFromInformationVector("SMMeisterderSchmiede") == 0) {
            BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Ehrwürdiger Cybot");
            BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Cybot");
            BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Ironclad-Cybot");
        }
    }

}
