package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMWolfGuardCataphractiiTerminators extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1, o1x, o1y;
	private final OptionsZaehlerGruppe o2, o2x;
	private final OptionsZaehlerGruppe o3;
	private final RuestkammerStarter rkBoss;

    public IMWolfGuardCataphractiiTerminators() {
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Wolf Guard Cataphractii Terminators", 5, 10, getPts("Wolf Guard Cataphractii Terminators")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Combi-Bolter", getPts("Combi-Bolter")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", getPts("Heavy Flamer (SM INFANTRY)")));
        add(o1y = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
        ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "Cataphractii Pack Leader");
        ((IMSpaceWolvesRuestkammer) rkBoss.getKammer()).type = "Wolf Guard Cataphractii Pack Leader";
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Wolf Guard Cataphractii Pack Leader"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {

        o1x.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl() - o1y.getAnzahl() - o3.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - 1 - o1.getAnzahl() - o1y.getAnzahl() - o3.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle() - 1 - o1y.getAnzahl() - o3.getAnzahl());

        final int o1verb = o1.getAnzahl() + o3.getAnzahl() + 1;

        if (squad.getModelle() == 10) {
            o1y.setMaxAnzahl(squad.getModelle() - o1verb > 2 ? 2 : squad.getModelle() - o1verb);
        } else {
            o1y.setMaxAnzahl(squad.getModelle() - o1verb >= 1 ? 1 : 0);
        }

        o2x.setMaxAnzahl(squad.getModelle() - 1 - o2.getAnzahl() - o3.getAnzahl());
        o2x.setAnzahl(0, squad.getModelle() - 1 - o2.getAnzahl() - o3.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle() - 1 - o3.getAnzahl());

        final int o1opt = o1.getAnzahl() + o1y.getAnzahl();
        final int o2opt = o2.getAnzahl();
        o3.setMaxAnzahl(squad.getModelle() - 1 - (o1opt > o2opt ? o1opt : o2opt));

        power = 12;
        if (squad.getModelle() > 5) {
            power = 24;
        }
    }
}
