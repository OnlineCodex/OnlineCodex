package oc.wh40k.units.cs;

import oc.*;

public class CSDreadclawTalonSeuchenmarinesKammer extends RuestkammerVater {

    AnzahlPanel squad;
    OptionsUpgradeGruppe vdlk;
    OptionsZaehlerGruppe o7;
    RuestkammerStarter champion;

    public CSDreadclawTalonSeuchenmarinesKammer() {
    }

    public void initButtons(boolean... defaults) {
        //name = "Seuchenmarines\n";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Seuchenmarines", 5, 20, 24);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone der Verzweiflung", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
        add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Veteranen", "Veteranen des Langen Krieges", 1));
        add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        champion = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Seuchenchampion", 1);
        // Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
        champion.initKammer(false, false, false, false, true, false);
        champion.setUeberschriftTrotzNullKostenAusgeben(true);
        add(champion);
        champion.setAbwaehlbar(false);

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        int count = squad.getModelle();

        vdlk.setPreis("Veteranen des Langen Krieges", 1 * count);

        if (!champion.isSelected()) champion.setSelected(true);
    }

}
