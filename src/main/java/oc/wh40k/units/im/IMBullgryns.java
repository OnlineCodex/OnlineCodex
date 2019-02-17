package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMBullgryns extends Eintrag {

	private final OptionsZaehlerGruppe o1, o2;
	private final AnzahlPanel squad;

    public IMBullgryns() {
        name = "Bullgryns";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Bullgryns", 3, 9, getPts("Bullgryns") + getPts("Frag bomb")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Grenadier Gauntlet", getPts("Grenadier Gauntlet")));
        ogE.addElement(new OptionsGruppeEintrag("Bullgryn maul", getPts("Bullgryn maul")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        o1.setAnzahl(0, squad.getModelle());
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Slabshield", getPts("Slabshield")));
        ogE.addElement(new OptionsGruppeEintrag("Brute shield", getPts("Brute shield")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        o2.setAnzahl(0, squad.getModelle());

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o2.setMaxAnzahl(squad.getModelle());
        o1.setLegal(o1.getAnzahl() == squad.getModelle());
        o2.setLegal(o2.getAnzahl() == squad.getModelle());

        power = 7;
        if (squad.getModelle() > 6) {
            power = 21;
        } else if (squad.getModelle() > 3) {
            power = 14;
        }
    }

}
