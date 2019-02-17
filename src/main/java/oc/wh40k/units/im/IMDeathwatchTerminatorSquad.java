package oc.wh40k.units.im;

import oc.*;

public class IMDeathwatchTerminatorSquad extends Eintrag {

	private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o1, o2, o1x, o2x;

    boolean raiderSelected = false;

    public IMDeathwatchTerminatorSquad() {
        name = "Terminator Squad";

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Terminators", 5, 10, getPts("Deathwatch Terminators")));
        squad.setGrundkosten(getPts("Power sword (SM)"));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter(DW)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addAll(IMSpaceMarinesTerminatorHeavyWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleport homer", getPts("Teleport homer")));

        complete();
    }

    @Override
    public void refreshen() {

        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
        //o1.setMaxAnzahl(squad.getModelle() / 5);

        o2x.setMaxAnzahl(squad.getModelle() - 1 - o2.getAnzahl());
        o2x.setAnzahl(0, squad.getModelle() - 1 - o2.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle() - 1);

        power = 13;
        if (squad.getModelle() > 5) {
            power = 26;
        }
    }
}
