package oc.wh40k.units.im;

import oc.*;

public class IMCompanyVeteransonBikes extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o1;
    private final OptionsZaehlerGruppe o2;
    private final OptionsZaehlerGruppe o3;

    public IMCompanyVeteransonBikes() {
        name = "Company Veterans on Bikes";

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Company Veterans", 2, 5, getPts("Company Veterans on Bike") + getPts("Twin boltgun")));
        squad.setGrundkosten(getPts("Power sword (SM)"));

        seperator();

        ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
        ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
        ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        o1.setAnzahl(0, 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));

        ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
        ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
        ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
        ogE.addAll(IMSpaceMarinesSpecialWeapons.createRK("", "", buildaVater));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        o2.setAnzahl(5, 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new IMSergeant("Company Veterans"), "Sergeant");
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle() - 1 - o3.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle() - 1 - o3.getAnzahl());
        o3.setMaxAnzahl(squad.getModelle() - 1 - (o1.getAnzahl() > o2.getAnzahl() ? o1.getAnzahl() : o2.getAnzahl()));

        boolean legal = (o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl() * 2) == (squad.getModelle() - 1) * 2;
        o1.setLegal(legal);
        o2.setLegal(legal);
        o3.setLegal(legal);

        power = 6;
        if (squad.getModelle() > 2) {
            power = 14;
        }
    }
}
