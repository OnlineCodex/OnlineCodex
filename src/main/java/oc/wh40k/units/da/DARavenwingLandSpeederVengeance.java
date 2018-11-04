package oc.wh40k.units.da;

import oc.*;

public class DARavenwingLandSpeederVengeance extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade ej;

    boolean added = false;

    public DARavenwingLandSpeederVengeance() {
        name = "Landspeeder Vengeance";
        grundkosten = 120;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o1.setSelected(0, true);

        seperator();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) {
            o1.setSelected(0, true);
        }
    }

    @Override
    public void deleteYourself() {

        super.deleteYourself();
    }
}
