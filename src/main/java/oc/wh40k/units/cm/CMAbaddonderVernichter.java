package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMAbaddonderVernichter extends Eintrag {


    public CMAbaddonderVernichter() {
        name = "Abaddon der Vernichter";
        grundkosten = 265;
        add(ico = new oc.Picture("oc/wh40k/images/AbbaddontheDespoiler.gif"));
        setInformationVectorValue("BLAbaddon", 1);
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        if (getCountFromInformationVector("BlackLegion") == 0) { //Bei der BL sind Auserkorene immer Standard
            if (getCountFromInformationVector("Main") > 0) {
                buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Auserkorene");
                buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Auserkorene");
            } else {
                buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Auserkorene");
                buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Auserkorene");

            }
        }
    }

    @Override
    public void deleteYourself() {
        setInformationVectorValue("BLAbaddon", 0);
        if (getCountFromInformationVector("BlackLegion") == 0) {//Bei der BL sind Auserkorene immer Standard
            buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Auserkorene");
            buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Auserkorene");
        }
        super.deleteYourself();
    }

}
