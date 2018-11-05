package oc.wh40k.units.im;

import oc.*;

public class IMRetributorSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsUpgradeGruppe o2;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkTransport;

    public IMRetributorSquad() {
        name = "Retributor Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Retributor Squad", 5, 10, getPts("Retributor Squad"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ASSororitastrupp.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (AMI)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMPrioris", "Upgrade zur Prioris");
        ((IMPrioris) rkBoss.getKammer()).type = "Sister Superior";
        rkBoss.initKammer(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {

        if (squad.getModelle() <= 5)
            power = 6;
        else if (squad.getModelle() <= 10)
            power = 10;
    }

}
