package oc.wh40k.units.cm;

import oc.*;

public class CMDreadclawTalonKhorneBerserkerKammer extends RuestkammerVater {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1def;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
    OptionsEinzelUpgrade plasmapistole;
    OptionsUpgradeGruppe ikone;
    OptionsUpgradeGruppe vdlk;
    OptionsZaehlerGruppe o7;
    RuestkammerStarter champion;
    OptionsZaehlerGruppe kettenäxte;

    public CMDreadclawTalonKhorneBerserkerKammer() {
    }

    public void initButtons(boolean... defaults) {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Khorne-Berserker", 5, 20, 19);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone des Zorns", 15));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kettenäxte", "Kettenäxte", 3));
        add(kettenäxte = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
        add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Veteranen", "Veteranen des Langen Krieges", 1));
        add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        champion = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Berserkerchampion", 1);
        // Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
        champion.initKammer(false, false, false, false, false, true);
        champion.setUeberschriftTrotzNullKostenAusgeben(true);
        champion.setGrundkosten(10);
        add(champion);
        champion.setAbwaehlbar(false);

        sizeSetzen();
    }


    @Override
    public void refreshen() {

        int count = squad.getModelle();

        vdlk.setPreis("Veteranen des Langen Krieges", 1 * count);

        if (!champion.isSelected()) champion.setSelected(true);

        int subtractor = 1; // Schädelchampion
        kettenäxte.setMaxAnzahl(squad.getModelle() - subtractor);
    }

}
