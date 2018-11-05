package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORWarbossGrahkrag extends Eintrag {

    OptionsEinzelUpgrade Munigrot;

    public ORWarbossGrahkrag() {

        kategorie = 1;
        name = "Warboss Grahkrag";
        grundkosten = 120;

        add(ico = new oc.Picture("oc/wh40k/images/WarbossGrahkrag.gif"));
        seperator();

        addToInformationVector("ORGrahkrag", 1);
        addToInformationVector("ORHQ", 1);

        complete();

    }

    @Override
    public void deleteYourself() {
        addToInformationVector("ORGrahkrag", -1);
        addToInformationVector("ORHQ", -1);
        super.deleteYourself();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}
