package oc.wh40k.units.ta;

import oc.*;

public class TATX4Piranhas extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsEinzelZaehler o5;
	private final OptionsZaehlerGruppe o4;

    public TATX4Piranhas() {
        name = "TX4 Piranhas";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Piranha", "Piranhas", 1, 5, getPts("TX4 Piranhas") + getPts("MV1 Gun Drone") * 2 + getPts("Pulse carbine") * 4);
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/PiranhaSchweberteam.gif"));

        add(o5 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Seeker missile", 2, getPts("Seeker missile")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Burst cannon", getPts("Burst cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Fusion blaster", getPts("Fusion blaster")));
        add(o4 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 1));
        o4.setAnzahl(0, 1);

        seperator(5);

        complete();
    }

    @Override
    public void refreshen() {

        o5.setMaxAnzahl(squad.getModelle() * 2);

        o4.setMaxAnzahl(squad.getModelle());
        if (o4.getAnzahl() < squad.getModelle()) {
            o4.setLegal(false);
        } else {
            o4.setLegal(true);
        }

        power = 4 * squad.getModelle();
    }

    @Override
    public void deleteYourself() {
    }

}
