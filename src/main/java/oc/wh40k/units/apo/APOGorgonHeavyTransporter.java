//IA1 2nd Ed

package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class APOGorgonHeavyTransporter extends Eintrag {


    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsZaehlerGruppe o1x;
    OptionsZaehlerGruppe o1;

    public APOGorgonHeavyTransporter() {
        name = "Gorgon";
        grundkosten = 430;


        add(ico = new oc.Picture("oc/wh40k/images/Gorgon.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "heavy stubber", "pintle-mounted heavy stubber", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "storm bolter", "pintle-mounted storm bolter", 10));

        ogE.addElement(new OptionsGruppeEintrag("Mortars", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Heavy stubbers", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamers", 5));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolters", 5));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        complete();

    }

    public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());

        o1x.setAktiv(!o1.isSelected());
        o1.setLegal((o1.getAnzahl() == o1.getMaxAnzahl()) || !o1.isSelected());
    }
}
