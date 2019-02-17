package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsZaehlerGruppe;

public class TYBroodBrothersHeavyWeaponSquad extends Eintrag {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe flak;
    OptionsZaehlerGruppe o1x;
    AnzahlPanel squad;

    public TYBroodBrothersHeavyWeaponSquad() {
        grundkosten = 0;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Heavy Weapons Squad", 3, 3, getPts("BroodBrothersHeavyWeaponSquad") + getPts("Frag grenade")));
        power = 3;
        add(ico = new oc.Picture("oc/wh40k/images/IGHeavyWeaponsSquad.jpg"));


        seperator();

        ogE = TYBroodBrothersHeavyWeapons.createRK("", "", buildaVater);
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        o1.setAnzahl(0, squad.getModelle());

        complete();
    }

    @Override
    public void refreshen() {
        o1.setLegal(o1.getAnzahl() == 3);
    }

}
