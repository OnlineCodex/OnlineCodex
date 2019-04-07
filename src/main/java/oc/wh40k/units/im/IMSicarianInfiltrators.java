package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMSicarianInfiltrators extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o1x;

	public IMSicarianInfiltrators() {
        name = "Sicarian Infiltrators";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Sicarian Infiltrators", 5, 10, getPts("Sicarian Infiltrators")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Stub c. + Power sw.", "Stub carbine + Power sword", getPts("Stub carbine") + getPts("Power sword (AME)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
        ogE.addElement(new OptionsGruppeEintrag("Flechette b. + Taser g.", "Flechette blaster und Taser goad", getPts("Flechette blaster") + getPts("Taser goad")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        complete();
    }

    @Override
    public void refreshen() {
        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle());

        power = 6;
        if (squad.getModelle() > 6) {
            power = 12;
        }
    }


}
