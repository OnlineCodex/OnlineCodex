package oc.wh40k.units.ae;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class AEHeavyWeaponPlatform extends RuestkammerVater {

    private final OptionsZaehlerGruppe o1;

    public AEHeavyWeaponPlatform() {
        grundkosten = 5;

        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));
        ogE.addAll(AEHeavyWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.setLegal(o1.isSelected());
    }
}