package oc.wh40k.units.im;

import oc.*;

public class IMDamnedLegionnaires extends Eintrag {

    AnzahlPanel squad;
    RuestkammerStarter rkBoss;
    OptionsUpgradeGruppe o1;

    public IMDamnedLegionnaires() {
        name = "Damned Legionnaires\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Legionnaires", 5, 10, getPts("Damned Legionnaires") + getPts("Boltgun (SM)") + getPts("Bolt pistol (SM)"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/SMLegionoftheDamnedSquad.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (SM)") - getPts("Boltgun (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (SM)") - getPts("Boltgun (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun (SM)") - getPts("Boltgun (SM)")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", getPts("Heavy flamer (SM)") - getPts("Boltgun (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM)") - getPts("Boltgun (SM)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMSergeant", "Legionnaire Sergeant");
        ((IMSergeant) rkBoss.getKammer()).type = "Damned Legionnaires";
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Sword Brother"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        power = 8;
        if (squad.getModelle() > 5) {
            power = 15;
        }


    }

}

