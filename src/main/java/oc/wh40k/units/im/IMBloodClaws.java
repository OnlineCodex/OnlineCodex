package oc.wh40k.units.im;

import oc.*;

public class IMBloodClaws extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1, o1x, o1y;
    OptionsZaehlerGruppe o2;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkBoss2;
    RuestkammerStarter rkBoss3;

    public IMBloodClaws() {
        name = "Blood Claws\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Blood Claws", 5, 15, getPts("Blood Claws"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("bolt pistol (SM)")));
        add(o1y = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Blood Claw Pack Leader");
        ((IMSpaceWolvesRuestkammer) rkBoss.getKammer()).setType("Blood Claw Pack Leader");
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Blood Claw Pack Leader"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        seperator();

        rkBoss2 = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Guard Pack Leader");
        ((IMSpaceWolvesRuestkammer) rkBoss2.getKammer()).setType("Wolf Guard Pack Leader");
        rkBoss2.initKammer();
        rkBoss2.setGrundkosten(getPts("Blood Claws"));
        rkBoss2.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss2);

        seperator();

        rkBoss3 = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Guard Terminator Pack Leader");
        ((IMSpaceWolvesRuestkammer) rkBoss3.getKammer()).setType("Wolf Guard Pack Leader in Terminator Armour (Blood Claws)");
        rkBoss3.initKammer();
        rkBoss3.setGrundkosten(getPts("Wolf Guard Terminator Pack Leader"));
        rkBoss3.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss3);


        complete();
    }

    @Override
    public void refreshen() {
        o1y.setMaxAnzahl(squad.getModelle() - 1 - o2.getAnzahl());
        o1y.setAnzahl(0, squad.getModelle() - 1 - o2.getAnzahl());

        o1x.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - 1 - o1.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle() == 15 ? 2 : 1);
        rkBoss.setAbwaehlbar(false);

        rkBoss2.setAktiv(!rkBoss3.isSelected());
        rkBoss3.setAktiv(!rkBoss2.isSelected());

        power = 4;

        if (squad.getModelle() > 10) {
            power += 6;
        } else if (squad.getModelle() > 5) {
            power += 3;
        }
        if (rkBoss2.isSelected()) {
            power += 2;
        }
        if (rkBoss3.isSelected()) {
            power += 3;
        }
    }

}
