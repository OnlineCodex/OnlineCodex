package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORGorkanaut extends Eintrag {

    OptionsEinzelUpgrade o1, o2, o3, o4, o5;

    public ORGorkanaut() {

        kategorie = 5;
        name = "Gorkanaut";
        grundkosten = getPts("Gorkanaut");
        power = 15;

        add(ico = new oc.Picture("oc/wh40k/images/Gorkanaut.gif"));

        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Skorcha", getPts("Skorcha")));
        add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Twin big shoota", getPts("Twin big shoota") * 2));
        add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rokkit launcha", getPts("Rokkit launcha") * 2));
        add(o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deffstorm mega-shoota", getPts("Deffstorm mega-shoota")));
        add(o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Klaw of Gork (or possibly Mork)", getPts("Klaw of Gork (or possibly Mork)")));

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        o1.setSelected(true);
        o2.setSelected(true);
        o3.setSelected(true);
        o4.setSelected(true);
        o5.setSelected(true);
    }
}