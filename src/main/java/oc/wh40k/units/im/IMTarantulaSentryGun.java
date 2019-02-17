package oc.wh40k.units.im;

import oc.*;

public class IMTarantulaSentryGun extends Eintrag {

	private final OptionsZaehlerGruppe o3;
    private final AnzahlPanel squad;

    public IMTarantulaSentryGun() {
        name = "Tarantula Sentry Gun";
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Tarantula Sentry Gun", 1, 3, getPts("Tarantula Sentry Gun"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-Melta", getPts("Multi-Melta")));
        ogE.addElement(new OptionsGruppeEintrag("Twin assault cannnon", getPts("Twin assault cannon")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o3.setAnzahl(0, 1);
    }

    @Override
    public void refreshen() {
        o3.setMaxAnzahl(squad.getModelle());
        o3.setLegal(o3.getAnzahl() == squad.getModelle());
    }
}
