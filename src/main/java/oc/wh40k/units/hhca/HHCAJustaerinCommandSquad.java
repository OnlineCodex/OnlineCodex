package oc.wh40k.units.hhca;

import oc.*;

public class HHCAJustaerinCommandSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o2, o4, o7a, o7aStandard, o7b, o7bStandard, o7c, o8;
    OptionsUpgradeGruppe o1, o3;
    OptionsZaehlerGruppe o7aStandard2;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkTransportPhobos;
    RuestkammerStarter rkTransportDreadclaw;

    public HHCAJustaerinCommandSquad() {
        name = "Justaerin Terminator Squad\n";
        grundkosten = 90;
        überschriftSetzen = true;
        this.setEintragsCNT(0);

        addToInformationVector("HHCALegionCommandSquad", 1);

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Justaerin Terminators", 3, 10, 45);
        add(squad);

        seperator();
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Power weapon"), 0));
        add(o7aStandard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", 5));
        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", 5));
        ogE.addElement(new OptionsGruppeEintrag("Chain fist", 10));
        add(o7a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
        add(o7bStandard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 7));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 7));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 7));
        add(o7b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 15));
        add(o7c = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Reaper autocannon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 25));
        add(o8 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        rkTransportPhobos = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerPhobos", "Legion Land Raider Phobos\n");
        rkTransportPhobos.initKammer();
        rkTransportPhobos.setButtonText("Legion Land Raider Phobos");
        add(rkTransportPhobos);

        seperator();
        rkTransportDreadclaw = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerDreadclaw", "Dreadclaw Drop Pod\n");
        rkTransportDreadclaw.initKammer();
        rkTransportDreadclaw.setButtonText("Dreadclaw Drop Pod");
        add(rkTransportDreadclaw);

        complete();
    }

    @Override
    public void refreshen() {

        int nksubractor = (o7a.getAnzahl() > o8.getAnzahl() ? o7a.getAnzahl() : o8.getAnzahl());

        o7b.setMaxAnzahl(squad.getModelle() - o7c.getAnzahl() - o8.getAnzahl());
        o7a.setMaxAnzahl(squad.getModelle() - o7c.getAnzahl());

        o7aStandard.setMaxAnzahl(squad.getModelle() - o7a.getAnzahl() - o7c.getAnzahl());
        o7bStandard.setMaxAnzahl(squad.getModelle() - o7b.getAnzahl() - o7c.getAnzahl() - o8.getAnzahl());
        o7aStandard.setAnzahl(0, o7aStandard.getMaxAnzahl());
        o7bStandard.setAnzahl(0, o7bStandard.getMaxAnzahl());

        o7c.setMaxAnzahl(squad.getModelle() - (nksubractor > o7b.getAnzahl() ? nksubractor : o7b.getAnzahl()));

        if (squad.getModelle() >= 5) {
            o8.setAktiv(true);
        } else {
            o8.setAktiv(false);
        }

        int maxAnzahl = squad.getModelle() / 5;

        o8.setMaxAnzahl(maxAnzahl);

        int offeneFKOptionen = squad.getModelle() - o7b.getAnzahl() - o7c.getAnzahl();
        if (maxAnzahl > 0 && offeneFKOptionen < 2) {
            o8.setMaxAnzahl(offeneFKOptionen);
        }

        rkTransportPhobos.setAktiv(squad.getModelle() <= 5 && !rkTransportDreadclaw.isSelected()
                && getCountFromInformationVector("HHCARoW") != 1);

        rkTransportDreadclaw.setAktiv(squad.getModelle() <= 5 && !rkTransportPhobos.isSelected()
                && getCountFromInformationVector("HHCARoW") != 1);

        rkTransportDreadclaw.getPanel().setLocation(
                (int) rkTransportDreadclaw.getPanel().getLocation().getX(),
                (int) rkTransportPhobos.getPanel().getLocation().getY() + rkTransportPhobos.getPanel().getSize().height + 5
        );

    }

    @Override
    public void deleteYourself() {
        addToInformationVector("HHCALegionCommandSquad", -1);
        super.deleteYourself();
    }

}
