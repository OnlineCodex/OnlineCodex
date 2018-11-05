package oc.wh40k.units.im;

import oc.*;

public class IMGreyHunters extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1, o1x, o1y, o1z;
    OptionsZaehlerGruppe o2;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkBoss2;
    RuestkammerStarter rkBoss3;

    public IMGreyHunters() {
        name = "Grey Hunters\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Grey Hunters", 5, 10, getPts("Grey Hunters"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
        add(o1y = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("bolt pistol (SM)")));
        add(o1z = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("boltgun (SM)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Grey Hunter Pack Leader");
        ((IMSpaceWolvesRuestkammer) rkBoss.getKammer()).setType("Grey Hunter Pack Leader");
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Grey Hunter Pack Leader"));
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

        rkBoss3 = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Guard Pack Leader in TA");
        ((IMSpaceWolvesRuestkammer) rkBoss3.getKammer()).setType("Wolf Guard Pack Leader in Terminator Armour (Grey Hunters)");
        rkBoss3.initKammer();
        rkBoss3.setGrundkosten(getPts("Wolf Guard Pack Leader in Terminator Armour"));
        rkBoss3.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss3);


        complete();
    }

    @Override
    public void refreshen() {
        o1y.setMaxAnzahl(squad.getModelle() - 1);
        o1z.setMaxAnzahl(squad.getModelle() - 1);
        o1z.setAnzahl(0, squad.getModelle() - 1);

        o1x.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl() - o2.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - 1 - o1.getAnzahl() - o2.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle() == 10 ? 2 : 1);
        rkBoss.setAbwaehlbar(false);

        rkBoss2.setAktiv(!rkBoss3.isSelected());
        rkBoss3.setAktiv(!rkBoss2.isSelected());

        power = 6;

        if (squad.getModelle() > 5) {
            power += 5;
        }
        if (rkBoss2.isSelected()) {
            power += 2;
        }
        if (rkBoss3.isSelected()) {
            power += 3;
        }
    }

}
