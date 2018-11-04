//APO2

package oc.wh40k.units.rh_ia13;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class RH_IA13Baneblade extends Eintrag {

    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsUpgradeGruppe o4;
    OptionsEinzelUpgrade mt;

    public RH_IA13Baneblade() {
        name = "Renegade Baneblade";
        grundkosten = 490;


        add(ico = new oc.Picture("oc/wh40k/images/Baneblade.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "heavy stubber", "pintle-mounted heavy stubber", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "storm bolter", "pintle-mounted storm bolter", 10));
        add(mt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Militia Training", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Sponsons", 0));
        ogE.addElement(new OptionsGruppeEintrag("Extra armour plates", 0));
        ogE.addElement(new OptionsGruppeEintrag("4 Sponsons", 100));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));


        complete();

    }

    public void refreshen() {
        o4.alwaysSelected();
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());

        if (getCountFromInformationVector("RHBloodyHandedReaver") == 1) {
            mt.setSelected(true);
        }
    }
}
