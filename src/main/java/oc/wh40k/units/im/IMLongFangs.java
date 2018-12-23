package oc.wh40k.units.im;

import oc.*;

public class IMLongFangs extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o1;
    private final OptionsZaehlerGruppe o1x;
    private final RuestkammerStarter rkBoss;
    private final RuestkammerStarter rkBoss2;
    private final RuestkammerStarter rkBoss3;

    public IMLongFangs() {
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Long Fangs", 5, 6, getPts("Long Fangs"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addAll(IMSpaceWolvesHeavyWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));


        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Long Fang Pack Leader"), "Long Fang Pack Leader");
        rkBoss.setGrundkosten(getPts("Long Fang Pack Leader"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        seperator();

        rkBoss2 = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Wolf Guard Pack Leader"), "Wolf Guard Pack Leader");
        rkBoss2.setGrundkosten(getPts("Long Fangs"));
        rkBoss2.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss2);

        seperator();

        rkBoss3 = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Wolf Guard Pack Leader in Terminator Armour (Long Fangs)"), "Wolf Guard Terminator Pack Leader");
        rkBoss3.setGrundkosten(getPts("Wolf Guard Terminator Pack Leader"));
        rkBoss3.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss3);


        complete();
    }

    @Override
    public void refreshen() {
        o1x.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - 1 - o1.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle() - 1);
        rkBoss.setAbwaehlbar(false);

        rkBoss2.setAktiv(!rkBoss3.isSelected());
        rkBoss3.setAktiv(!rkBoss2.isSelected());

        power = 7;
        if (squad.getModelle() > 5) {
            power += 1;
        }
        if (rkBoss2.isSelected()) {
            power += 2;
        }
        if (rkBoss3.isSelected()) {
            power += 3;
        }
    }

}
