package oc.wh40k.units.da;

import oc.*;

public class DARavenwingBikeSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe trike, o3, o4, o5;
    OptionsEinzelUpgrade boss;
    RuestkammerStarter rkBoss;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2a;
    OptionsZaehlerGruppe o2b;

    boolean added = false;

    public DARavenwingBikeSquad() {
        name = "Ravenwing Bike Squad";
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/DARavenwingAttackSquadron.gif"));

        seperator();

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Ravenwing-Biker", 3, 6, 25);
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
        add(o2a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        o2.setMaxAnzahl(squad.getModelle());
        o2.setAnzahl(0, squad.getModelle());

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Gravstrahler", 15));
        add(o2b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Trike", "Ravenwing-Trike", 45));
        add(trike = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o5.setSelected(0, true);

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DASergeant", "Upgrade zum Sergeant");
        rkBoss.initKammer(false, false, true);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        seperator();

        complete();
    }

    @Override
    public void refreshen() {

        if (getCountFromInformationVector("Ravenwing Huntmasters") > 0) {
            squad.setModelle(6);
        }

        if (!rkBoss.isSelected()) rkBoss.setSelected(true);

        o2a.setMaxAnzahl(squad.getModelle() - 1 - o2b.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle() - 1 - o2a.getAnzahl() - o2b.getAnzahl());
        o2.setAnzahl(0, o2.getMaxAnzahl());


        if (trike.isSelected()) {
            o5.setAktiv(true);
            if (!o5.isSelected()) {
                o5.setSelected(0, true);
            }
        } else {
            o5.setAktiv(false);
        }

        if (getCountFromInformationVector("Ravenwing Huntmasters") > 0) {
            trike.setSelected(0, true);
        }

        if (getCountFromInformationVector("Ravenwing Huntmasters") > 0 && getCountFromInformationVector("DARavenwingAngriffsschwadron") > 3) {
            setFehlermeldung("max. 3");
        } else {
            setFehlermeldung("");
        }
    }


}
