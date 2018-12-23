package oc.wh40k.units.im;

import oc.*;

public class IMDevastatorSquad extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o1;
    private final OptionsZaehlerGruppe o1x;

    public IMDevastatorSquad() {
        name = "Devastator Squad\n";
        überschriftSetzen = true;
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, getPts("Devastator Squad")));

        add(ico = new oc.Picture("oc/wh40k/images/SMDevastatorTrupp.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armorium Cherub", getPts("Devastator Squad - Armorium Cherub")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        ogE.addAll(IMSpaceMarinesHeavyWeapons.createRK("", "", buildaVater));
        if (buildaVater.getFormationType().equals("Blood Angels"))
            ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", getPts("Heavy Flamer (SM)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new IMSergeant("Devastator Squad"), "Sergeant");
        rkBoss.setGrundkosten(getPts("Sergeant"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
        o1x.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - 1 - o1.getAnzahl());

        if (squad.getModelle() >= 5) power = 8;
        if (squad.getModelle() >= 10) power = 11;
    }
}