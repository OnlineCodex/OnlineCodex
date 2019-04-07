package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class CHFiendsofSlaanesh extends Eintrag {

	private final AnzahlPanel fiends;
	private final OptionsZaehlerGruppe blissbringer;

    public CHFiendsofSlaanesh() {

        name = "Fiends of Slaanesh";
        grundkosten = 0;
        power = 2;

        add(fiends = new AnzahlPanel(ID, randAbstand, cnt, "Fiends of Slaanesh", 1, 9, getPts("Fiends of Slaanesh")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Gore Hounds", getPts("Blissbringer")));
        add(blissbringer = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        complete();

    }

    @Override
	public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = fiends.getModelle() * 2;

        blissbringer.setAktiv(fiends.getModelle()>=3);
        blissbringer.setMaxAnzahl(1);
    }
}
