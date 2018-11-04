package oc.wh40k.units.ia;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IAPrimarisPsyker extends Eintrag {

    public IAPrimarisPsyker() {
        name = "Primaris-Psioniker";
        grundkosten = 50;

        add(ico = new oc.Picture("oc/wh40k/images/IGPrimarisPsyker.gif"));

        addToInformationVector("AMPrimarisPsyker", 1);

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterschaftsgrad 2", 25));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Digitalwaffen", 10));

        complete();
    }

    @Override
    public void refreshen() {
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }


}
