package oc.wh40k.units.im;

import oc.*;

public class IMTerminatorAssaultSquad extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1, o1x;

    boolean raiderSelected = false;

    public IMTerminatorAssaultSquad() {
        name = "Terminator Assault Squad";

        //5 Termis 5*31 + 2 * Lightning claws (single/pair) 9/13 + 3 * Thunder hammer (other models) 20 + 3 * Storm shield (other models) 5

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Terminators", 5, 10, getPts("Terminator Assault Squad")));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lightning claws", getPts("Lightning claw (pair)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Hammer + Shield", "Thunder hammer + Storm shield", getPts("Thunder hammer(others)") + getPts("Storm shield(others)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleport homer", getPts("Teleport homer")));

        complete();
    }

    @Override
    public void refreshen() {

        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle());

        power = 13;
        if (squad.getModelle() > 5) {
            power = 26;
        }
    }
}
