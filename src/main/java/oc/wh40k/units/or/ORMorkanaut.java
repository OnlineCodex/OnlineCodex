package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORMorkanaut extends Eintrag {

    OptionsEinzelUpgrade o1, o2, o3, o4, o5;

    public ORMorkanaut() {

        name = "Morkanaut";
        grundkosten = getPts("Morkanaut");
        power = 15;

        add(ico = new oc.Picture("oc/wh40k/images/Gorkanaut.gif"));

        seperator();

        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kustom mega-blasta", getPts("Kustom mega-blasta")));
        add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Twin big shoota", getPts("Twin big shoota") * 2));
        add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Two Rokkit launcha", getPts("Rokkit launcha") * 2));
        add(o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kustom mega-zappa", getPts("Kustom mega-zappa")));
        add(o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Klaw of Gork (or possibly Mork)", getPts("Klaw of Gork (or possibly Mork)")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kustom force field", getPts("Kustom force field")));

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