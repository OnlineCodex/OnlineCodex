package oc.wh40k.units.im;

import oc.*;

public class IMSkyclaws extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1, o1x, o2;
    RuestkammerStarter rkBoss, rkBoss2;

    public IMSkyclaws() {
        checkBuildaVater();
        name = "Skyclaws\n";
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Skyclaw", 5, 10, getPts("Skyclaws")));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Chain sword", getPts("Chain sword (SM)")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
        ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Skyclaw Pack Leader");
        ((IMSpaceWolvesRuestkammer) rkBoss.getKammer()).setType("Skyclaw Pack Leader");
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Skyclaw Pack Leader"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        seperator();

        rkBoss2 = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Guard Sky Leader");
        ((IMSpaceWolvesRuestkammer) rkBoss2.getKammer()).setType("Wolf Guard Sky Leader");
        rkBoss2.initKammer();
        rkBoss2.setGrundkosten(getPts("Swiftclaws"));
        rkBoss2.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss2);

        complete();
    }

    @Override
    public void refreshen() {
        rkBoss.setAbwaehlbar(false);

        o2.setMaxAnzahl(squad.getModelle() - 1);
        o2.setAnzahl(0, squad.getModelle() - 1);

        o1x.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl());
        o1x.setAnzahl(0, o1x.getMaxAnzahl());

        o1.setMaxAnzahl(2 - (((IMSpaceWolvesRuestkammer) rkBoss.getKammer()).o2.isSelected("Bolt pistol") ? 0 : 1));

        power = 5;
        if (squad.getModelle() > 5) {
            power += 4;
        }
        if (rkBoss2.isSelected()) {
            power += 2;
        }
    }

}
