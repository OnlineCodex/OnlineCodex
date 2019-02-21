package oc.wh40k.units.im;

import oc.*;

public class IMIronstriderBallistarii extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o1x;

    public IMIronstriderBallistarii() {
        name = "Ironstrider Ballistarii";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Ironstrider Ballistarii", 1, 6, getPts("Ironstrider Ballistarii")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin cognis autocannon", getPts("Twin cognis autocannon")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Twin cognis lascannon", getPts("Twin cognis lascannon")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
        power = squad.getModelle() * 4;
    }


}
