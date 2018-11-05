//IA1 2nd Ed

package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class APOMinotaurArtilleryTank extends Eintrag {

    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    public APOMinotaurArtilleryTank() {
        name = "Minotaur Artillery Tank";
        grundkosten = 275;

        add(ico = new oc.Picture("oc/wh40k/images/MinotaurArtilleryTank.gif"));

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "heavy stubber", "pintle-mounted heavy stubber", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "storm bolter", "pintle-mounted storm bolter", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Enclosed Crew Compartment", 15));

        complete();

    }

    public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());
    }
}
