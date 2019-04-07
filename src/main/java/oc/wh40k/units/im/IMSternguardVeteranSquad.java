package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMSternguardVeteranSquad extends Eintrag {//Sternguard

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
    OptionsZaehlerGruppe o2;
    RuestkammerStarter rkBoss;

    boolean siegeForce;

    public IMSternguardVeteranSquad() {
        name = "Sternguard Veteran Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Veterans", 5, 10, getPts("Sternguard Veteran Squad")));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Special issue boltgun", getPts("Special issue boltgun")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", getPts("Heavy Flamer (SM)")));
        ogE.addAll(IMSpaceMarinesSpecialWeapons.createRK("", "", buildaVater));
        ogE.addAll(IMSpaceMarinesHeavyWeapons.createRK("", "", buildaVater));
//		ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater)); Ist zwar laut Eintrag möglich, aber unnötig, da es sowieso schon oben gewählt werden kann.
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, IMSergeant.class, "Sergeant");
        ((IMSergeant) rkBoss.getKammer()).type = "Sternguard Veteran Squad";
        rkBoss.initKammer();
        rkBoss.setAbwaehlbar(false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);

        seperator();

        complete();
    }

    @Override
    public void refreshen() {

        if (!rkBoss.isSelected()) rkBoss.setSelected(true);

        o1x.setMaxAnzahl(squad.getModelle() - 1 - o2.getAnzahl() - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - 1 - o2.getAnzahl() - o1.getAnzahl());

        o1.setMaxAnzahl(squad.getModelle() - 1 - o2.getAnzahl());

        if ((squad.getModelle() - 1 - o1.getAnzahl()) > 1) {
            o2.setMaxAnzahl(2);
        } else if ((squad.getModelle() - 1 - o1.getAnzahl()) > 0) {
            o2.setMaxAnzahl(1);
        } else {
            o2.setMaxAnzahl(0);
        }

        power = 7;
        if (squad.getModelle() > 5) {
            power = 14;
        }

    }

}
