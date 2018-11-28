package oc.wh40k.units.im;

import oc.*;

public class IMBattleSistersSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkTransport;

    public IMBattleSistersSquad() {
        name = "Battle Sisters Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Battle Sisters", 5, 15, getPts("Battle Sisters Squad"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ASSororitastrupp.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (AMI)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (AMI)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, IMPrioris.class, "Upgrade zur Prioris");
        ((IMPrioris) rkBoss.getKammer()).type = "Sister Superior";
        rkBoss.initKammer(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {

        if (squad.getModelle() <= 5)
            power = 4;
        else if (squad.getModelle() <= 10)
            power = 8;
        else if (squad.getModelle() <= 15)
            power = 12;

    }

}
