package oc.wh40k.units.im;

import oc.*;

public class IMDamnedLegionnaires extends Eintrag {

    private final AnzahlPanel squad;

    public IMDamnedLegionnaires() {
        name = "Damned Legionnaires";
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
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new IMSergeant("Damned Legionnaires"), "Legionnaire Sergeant");
        rkBoss.setGrundkosten(getPts("Sword Brother"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

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

