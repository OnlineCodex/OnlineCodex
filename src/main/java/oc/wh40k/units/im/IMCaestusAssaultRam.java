package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMCaestusAssaultRam extends Eintrag {

    public IMCaestusAssaultRam() {
        name = "Caestus Troops Ram";
        grundkosten = 275;

        add(ico = new oc.Picture("oc/wh40k/images/SMCaestusAssaultRam.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Frag Troops Launchers", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleport Homer", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ceramite Plating", 20));
        complete();
    }

    @Override
    public void refreshen() {
    }

}
