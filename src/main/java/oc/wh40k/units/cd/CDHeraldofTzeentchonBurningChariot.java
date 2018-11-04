package oc.wh40k.units.cd;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDHeraldofTzeentchonBurningChariot extends Eintrag {

    OptionsEinzelUpgrade waffe1;
    OptionsEinzelUpgrade waffe2;

    public CDHeraldofTzeentchonBurningChariot() {

        name = "Herald of Tzeentch on Burning Chariot";
        grundkosten = getPts("Herald of Tzeentch on Burning Chariot");
        power = 5;

        add(waffe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ritual dagger", getPts("Ritual dagger")));
        waffe1.setSelected(true);

        add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Staff of change", getPts("Staff of change")));

        seperator();

        add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blue Horrors", getPts("Blue Horrors") * 3));


        complete();

    }

    @Override
    public void refreshen() {
        if (!waffe1.isSelected()) waffe1.setSelected(true);
    }
}
