package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORGoMorkanaut extends Eintrag {

	private final OptionsUpgradeGruppe typ;
	private final OptionsEinzelUpgrade kff;

    public ORGoMorkanaut() {

        kategorie = 5;
        //name = "GoMorkanaut";
        überschriftSetzen = false;
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/Gorkanaut.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Gorkanaut", 245));
        ogE.addElement(new OptionsGruppeEintrag("Morkanaut", 230));
        add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(kff = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schpezialkraftfeld", 50));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grothälfaz", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

        complete();

    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        if (!typ.isSelected()) {
            typ.setSelected(0, true);
        }

        kff.setAktiv(typ.isSelected(1));
    }
}