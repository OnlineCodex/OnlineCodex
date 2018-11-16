package oc.wh40k.units.im;

import oc.*;

public class IMGreyHunters extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe special, boltguns, chainswords, boltpistols;
    OptionsZaehlerGruppe plasmapistol;
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
        add(chainswords = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("bolt pistol (SM)")));
        add(boltpistols = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("boltgun (SM)")));
        add(boltguns = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
        add(special = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
        add(plasmapistol = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wolf standard", getPts("Wolf standard")));

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

        rkBoss3 = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Guard Terminator Pack Leader");
        ((IMSpaceWolvesRuestkammer) rkBoss3.getKammer()).setType("Wolf Guard Pack Leader in Terminator Armour (Grey Hunters)");
        rkBoss3.initKammer();
        rkBoss3.setGrundkosten(getPts("Wolf Guard Terminator Pack Leader"));
        rkBoss3.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss3);


        complete();
    }

    @Override
    public void refreshen() {
        chainswords.setMaxAnzahl(squad.getModelle() - 1);
        boltpistols.setMaxAnzahl(squad.getModelle() - 1);
        boltpistols.setAnzahl(0, squad.getModelle() - 1);

        boltguns.setMaxAnzahl(squad.getModelle() - 1 - special.getAnzahl() - plasmapistol.getAnzahl());
        boltguns.setAnzahl(0, squad.getModelle() - 1 - special.getAnzahl() - plasmapistol.getAnzahl());
        special.setMaxAnzahl(squad.getModelle() == 10 ? 2 : 1);
        rkBoss.setAbwaehlbar(false);

        rkBoss2.setAktiv(!rkBoss3.isSelected());
        rkBoss3.setAktiv(!rkBoss2.isSelected());

        power = 4;

        if (squad.getModelle() > 5) {
            power += 4;
        }
        if (rkBoss2.isSelected()) {
            power += 2;
        }
        if (rkBoss3.isSelected()) {
            power += 3;
        }
    }

}
