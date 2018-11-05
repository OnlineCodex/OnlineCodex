package oc.wh40k.units.cd;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDHeraldofTzeentchonDisc extends Eintrag {

    OptionsEinzelUpgrade waffe1;
    OptionsEinzelUpgrade waffe2;

    public CDHeraldofTzeentchonDisc() {

        name = "Herald of Tzeentch on Disc";
        grundkosten = getPts("Herald of Tzeentch on Disc");
        power = 5;

        add(waffe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ritual dagger", getPts("Ritual dagger")));
        waffe1.setSelected(true);

        add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Staff of change", getPts("Staff of change")));

        complete();

    }

    @Override
    public void refreshen() {
        if (!waffe1.isSelected()) waffe1.setSelected(true);
    }
}
