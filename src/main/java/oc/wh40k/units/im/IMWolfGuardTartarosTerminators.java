package oc.wh40k.units.im;

import oc.*;

public class IMWolfGuardTartarosTerminators extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1x;
	private final OptionsZaehlerGruppe o2, o2x;
	private final OptionsZaehlerGruppe o3, o4, o5;
	private final RuestkammerStarter rkBoss;

    public IMWolfGuardTartarosTerminators() {
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Wolf Guard Tartaros Terminators", 5, 10, getPts("Wolf Guard Tartaros Terminators")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Combi-Bolter", getPts("Combi-Bolter")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("heavy flamer (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Reaper autocannon", getPts("reaper autocannon")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator(8);

        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator(8);

        ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Grenade Harness", getPts("Grenade Harness")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "Tartaros Pack Leader");
        ((IMSpaceWolvesRuestkammer) rkBoss.getKammer()).type = "Wolf Guard Tartaros Pack Leader";
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Wolf Guard Tartaros Pack Leader"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {

        o1x.setMaxAnzahl(squad.getModelle() - 1 - o3.getAnzahl() - o4.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - 1 - o3.getAnzahl() - o4.getAnzahl());

        int x = squad.getModelle() - 1 - o4.getAnzahl();
        if (squad.getModelle() == 10) {
            o3.setMaxAnzahl(Math.min(x, 2));
        } else {
            o3.setMaxAnzahl(Math.min(x, 1));
        }

        o2x.setMaxAnzahl(squad.getModelle() - 1 - o2.getAnzahl() - o4.getAnzahl());
        o2x.setAnzahl(0, squad.getModelle() - 1 - o2.getAnzahl() - o4.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle() - 1 - o4.getAnzahl());

        o4.setMaxAnzahl(squad.getModelle() - 1 - Math.max(o3.getAnzahl(), o2.getAnzahl()));

        o5.setMaxAnzahl(squad.getModelle() / 5);

        power = 12;
        if (squad.getModelle() > 5) {
            power = 24;
        }
    }
}
