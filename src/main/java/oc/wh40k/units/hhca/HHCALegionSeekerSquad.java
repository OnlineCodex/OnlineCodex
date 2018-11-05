package oc.wh40k.units.hhca;

import oc.*;

public class HHCALegionSeekerSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe o2, o3;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkTransportEagle;
    RuestkammerStarter rkTransportDreadclaw;
    RuestkammerStarter rkTransportPhobos;
    RuestkammerStarter rkTransportPod;
    RuestkammerStarter rkTransportProteus;
    RuestkammerStarter rkTransportRhino;

    public HHCALegionSeekerSquad() {
        name = "Legion Seeker Squad\n";
        grundkosten = 100;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 15);
        add(squad);

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
        ;
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();
        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "HHCASergeant", "Legion Sergeant");
        rkBoss.setGrundkosten(0);
        //Assault, Bike, Breacher, Destroyer, Heavy, Reaver, Reco, Seeker, Support, Tactical, Terminator, Veteran
        rkBoss.initKammer(false, false, false, false, false, false, false, true, false, false, false, false);
        rkBoss.setAbwaehlbar(false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);

        seperator();
        rkTransportPod = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerPod", "Legion Drop Pod\n");
        rkTransportPod.initKammer();
        rkTransportPod.setButtonText("Legion Drop Pod");
        add(rkTransportPod);

        seperator();
        rkTransportEagle = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerEagle", "Legion Storm Eagle Assault Gunship\n");
        rkTransportEagle.initKammer();
        rkTransportEagle.setButtonText("Legion Storm Eagle Assault Gunship");
        add(rkTransportEagle);

        seperator();
        rkTransportPhobos = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerPhobos", "Legion Land Raider Phobos\n");
        rkTransportPhobos.initKammer();
        rkTransportPhobos.setButtonText("Legion Land Raider Phobos");
        add(rkTransportPhobos);

        seperator();
        rkTransportProteus = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerProteus", "Legion Land Raider Proteus\n");
        rkTransportProteus.initKammer();
        rkTransportProteus.setButtonText("Legion Land Raider Proteus");
        add(rkTransportProteus);

        seperator();
        rkTransportRhino = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerRhino", "Legion Rhino Armoured Carrier\n");
        rkTransportRhino.initKammer();
        rkTransportRhino.setButtonText("Legion Rhino Armoured Carrier");
        add(rkTransportRhino);

        seperator();
        rkTransportDreadclaw = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerDreadclaw", "Dreadclaw Drop Pod\n");
        rkTransportDreadclaw.initKammer();
        rkTransportDreadclaw.setButtonText("Dreadclaw Drop Pod");
        add(rkTransportDreadclaw);

        complete();
    }

    @Override
    public void refreshen() {
        if (!rkBoss.isSelected()) rkBoss.setSelected(true);

        int subtractor = 1; // boss

        o3.setMaxAnzahl(squad.getModelle() - subtractor);

        o2.setMaxAnzahl(squad.getModelle() - subtractor - o3.getAnzahl());
        o2.setAnzahl(0, o3.getMaxAnzahl() - o3.getAnzahl());

        rkTransportPod.setAktiv(squad.getModelle() <= 10 && !rkTransportRhino.isSelected()
                && !rkTransportEagle.isSelected()
                && !rkTransportPhobos.isSelected()
                && !rkTransportProteus.isSelected()
                && !rkTransportDreadclaw.isSelected()
                && getCountFromInformationVector("HHCARoW") == 3);

        rkTransportEagle.setAktiv(squad.getModelle() <= 10 && !rkTransportPod.isSelected()
                && !rkTransportRhino.isSelected()
                && !rkTransportPhobos.isSelected()
                && !rkTransportProteus.isSelected()
                && !rkTransportDreadclaw.isSelected()
                && getCountFromInformationVector("HHCARoW") == 1);

        rkTransportPhobos.setAktiv(squad.getModelle() <= 10 && !rkTransportPod.isSelected()
                && !rkTransportEagle.isSelected()
                && !rkTransportRhino.isSelected()
                && !rkTransportProteus.isSelected()
                && !rkTransportDreadclaw.isSelected()
                && getCountFromInformationVector("HHCARoW") == 2);

        rkTransportProteus.setAktiv(squad.getModelle() <= 10 && !rkTransportPod.isSelected()
                && !rkTransportEagle.isSelected()
                && !rkTransportPhobos.isSelected()
                && !rkTransportRhino.isSelected()
                && !rkTransportDreadclaw.isSelected()
                && getCountFromInformationVector("HHCARoW") == 2);

        rkTransportRhino.setAktiv(squad.getModelle() <= 10 && !rkTransportPod.isSelected()
                && !rkTransportEagle.isSelected()
                && !rkTransportPhobos.isSelected()
                && !rkTransportProteus.isSelected()
                && !rkTransportDreadclaw.isSelected()
                && getCountFromInformationVector("HHCARoW") != 1
                && getCountFromInformationVector("HHCARoW") != 3);

        rkTransportDreadclaw.setAktiv(squad.getModelle() <= 10 && !rkTransportRhino.isSelected()
                && !rkTransportEagle.isSelected()
                && !rkTransportPhobos.isSelected()
                && !rkTransportProteus.isSelected()
                && !rkTransportRhino.isSelected());

        rkTransportPod.getPanel().setLocation(
                (int) rkTransportPod.getPanel().getLocation().getX(),
                (int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
        );

        rkTransportEagle.getPanel().setLocation(
                (int) rkTransportEagle.getPanel().getLocation().getX(),
                (int) rkTransportPod.getPanel().getLocation().getY() + rkTransportPod.getPanel().getSize().height + 5
        );

        rkTransportPhobos.getPanel().setLocation(
                (int) rkTransportPhobos.getPanel().getLocation().getX(),
                (int) rkTransportEagle.getPanel().getLocation().getY() + rkTransportEagle.getPanel().getSize().height + 5
        );

        rkTransportProteus.getPanel().setLocation(
                (int) rkTransportProteus.getPanel().getLocation().getX(),
                (int) rkTransportPhobos.getPanel().getLocation().getY() + rkTransportPhobos.getPanel().getSize().height + 5
        );

        rkTransportRhino.getPanel().setLocation(
                (int) rkTransportRhino.getPanel().getLocation().getX(),
                (int) rkTransportProteus.getPanel().getLocation().getY() + rkTransportProteus.getPanel().getSize().height + 5
        );
        rkTransportDreadclaw.getPanel().setLocation(
                (int) rkTransportDreadclaw.getPanel().getLocation().getX(),
                (int) rkTransportRhino.getPanel().getLocation().getY() + rkTransportRhino.getPanel().getSize().height + 5
        );
    }

}
