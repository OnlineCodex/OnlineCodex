package oc.wh40k.units.hhca;

import oc.*;

public class HHCALegionAssaultSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe o2;
    RuestkammerStarter rkBoss;

    public HHCALegionAssaultSquad() {
        name = "Legion Assault Squad\n";
        grundkosten = 100;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Assault Marine", 10, 20, 15);
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
        ogE.addElement(new OptionsGruppeEintrag("Combat shields", 3));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Hand flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "HHCASergeant", "Assault Sergeant");
        rkBoss.setGrundkosten(0);
        //Assault, Bike, Breacher, Destroyer, Heavy, Reaver, Reco, Seeker, Support, Tactical, Terminator, Veteran
        rkBoss.initKammer(true, false, false, false, false, false, false, false, false, false, false, false);
        rkBoss.setAbwaehlbar(false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
        if (!rkBoss.isSelected()) rkBoss.setSelected(true);

        o1.setPreis(0, squad.getModelle() * 5);
        o1.setPreis(1, squad.getModelle() * 3);
        o2.setMaxAnzahl(squad.getModelle() / 5);
    }

}
