package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsZaehlerGruppe;

public class IMHeavyWeaponsSquad extends Eintrag {

	private final OptionsZaehlerGruppe o1;
	private final AnzahlPanel squad;

    public IMHeavyWeaponsSquad() {
        grundkosten = 0;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Heavy Weapons Teams", 3, 3, getPts("Heavy Weapons Squad") + getPts("Frag grenade (AM)")));
        power = 3;
        add(ico = new oc.Picture("oc/wh40k/images/IGHeavyWeaponsSquad.jpg"));


        seperator();

        ogE = IMAstraMilitarumHeavyWeapons.createRK("", "", buildaVater);
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        o1.setAnzahl(0, squad.getModelle());

        complete();
    }

    @Override
    public void refreshen() {
        o1.setLegal(o1.getAnzahl() == 3);
    }

}
