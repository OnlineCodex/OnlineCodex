package oc.wh40k.units.im;

import oc.*;

public class IMWolfScouts extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe wpn1, wpn2, boltgun, plasmapistol, boltpistol;
    OptionsZaehlerGruppe nk;
    OptionsEinzelZaehler camo;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkBoss2;

    public IMWolfScouts() {
        name = "Wolf Scouts\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Wolf Scouts", 5, 10, getPts("Wolf Scouts"));
        add(squad);

        seperator();

        add(camo = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Camo cloaks", 4, getPts("Camo cloak")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("bolt pistol (SM)")));
        add(boltpistol = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
        add(plasmapistol = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("boltgun (SM)")));
        add(boltgun = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Combat knife", getPts("combat knife")));
        ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", getPts("sniper rifle (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Astartes shotgun", getPts("Astartes shotgun")));
        add(wpn1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher (SM)")));
        ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
        add(wpn2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
        add(nk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Scout Pack Leader");
        ((IMSpaceWolvesRuestkammer) rkBoss.getKammer()).setType("Wolf Scout Pack Leader");
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Wolf Scout Pack Leader"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        seperator();

        rkBoss2 = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Guard Pack Leader");
        ((IMSpaceWolvesRuestkammer) rkBoss2.getKammer()).setType("Wolf Guard Pack Leader (Wolf Scouts)");
        rkBoss2.initKammer();
        rkBoss2.setGrundkosten(getPts("Blood Claws"));
        rkBoss2.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss2);

        complete();
    }

    @Override
    public void refreshen() {
        camo.setMaxAnzahl(squad.getModelle() - 1);

        boltpistol.setMaxAnzahl(squad.getModelle() - 1 - plasmapistol.getAnzahl());
        boltpistol.setAnzahl(0, squad.getModelle() - 1 - plasmapistol.getAnzahl());

        boltgun.setMaxAnzahl(squad.getModelle() - 1 - wpn1.getAnzahl() - wpn2.getAnzahl() - nk.getAnzahl());
        boltgun.setAnzahl(0, squad.getModelle() - 1 - wpn1.getAnzahl() - wpn2.getAnzahl() - nk.getAnzahl());
        
        wpn1.setMaxAnzahl(squad.getModelle() - 1 - wpn2.getAnzahl() - nk.getAnzahl());
        wpn2.setMaxAnzahl((wpn1.getAnzahl() + nk.getAnzahl()) < (squad.getModelle() - 1) ? 1 : 0);

        nk.setMaxAnzahl(plasmapistol.isSelected() ? 0 : ((wpn1.getAnzahl() + wpn2.getAnzahl()) < (squad.getModelle() - 1) ? 1 : 0));
        plasmapistol.setMaxAnzahl(nk.isSelected() ? 0 : 1);

        rkBoss.setAbwaehlbar(false);

        power = 4;

        if (squad.getModelle() > 5) {
            power += 4;
        }
        if (rkBoss2.isSelected()) {
            power += 2;
        }
    }

}
