package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class SMTheEmperorsChampion extends Eintrag {

    OptionsUpgradeGruppe o1;

    public SMTheEmperorsChampion() {
        name = "The Emperor's Champion";
        grundkosten = 140;
        addToInformationVector("SMHQ", 1);
        add(ico = new oc.Picture("oc/wh40k/images/BTChampiondesImperators.jpg"));
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

        if (getCountFromInformationVector("SMBlackTemplars") != 1) {
            setFehlermeldung("Keine Black Templars");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("SMHQ", -1);
        super.deleteYourself();
    }

}
