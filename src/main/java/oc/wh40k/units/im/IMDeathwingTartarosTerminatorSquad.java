package oc.wh40k.units.im;

import oc.*;

public class IMDeathwingTartarosTerminatorSquad extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o1x;
    private final OptionsZaehlerGruppe o2;
    private final OptionsZaehlerGruppe o2x;
    private final OptionsZaehlerGruppe o3;
    private final OptionsZaehlerGruppe o4;
    private final OptionsZaehlerGruppe o5;

    public IMDeathwingTartarosTerminatorSquad() {
        name = "Tartaros Terminator Squad";
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Tartaros Terminators", 5, 10, getPts("Tartaros Terminator Squad")));

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

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceMarinesRuestkammer("Tartaros Sergeant", getKeywords()), "Tartaros Sergeant");
        rkBoss.setGrundkosten(getPts("Tartaros Sergeant"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {

        o1x.setMaxAnzahl(squad.getModelle() - 1 - o3.getAnzahl() - o4.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - 1 - o3.getAnzahl() - o4.getAnzahl());

        int x = squad.getModelle() - 1 - o4.getAnzahl();
        if (squad.getModelle() == 10) {
            o3.setMaxAnzahl(x > 2 ? 2 : x);
        } else {
            o3.setMaxAnzahl(x > 1 ? 1 : x);
        }

        o2x.setMaxAnzahl(squad.getModelle() - 1 - o2.getAnzahl() - o4.getAnzahl());
        o2x.setAnzahl(0, squad.getModelle() - 1 - o2.getAnzahl() - o4.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle() - 1 - o4.getAnzahl());

        x = squad.getModelle() - 1 - o3.getAnzahl();
        int y = squad.getModelle() - 1 - o2.getAnzahl();
        o4.setMaxAnzahl(x > y ? y : x);

        o5.setMaxAnzahl(squad.getModelle() / 5);

        power = 12;
        if (squad.getModelle() > 5) {
            power = 24;
        }
    }
}
