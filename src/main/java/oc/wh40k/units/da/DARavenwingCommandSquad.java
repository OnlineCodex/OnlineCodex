package oc.wh40k.units.da;



import oc.*;



public class DARavenwingCommandSquad extends Eintrag {



    AnzahlPanel squad;

    OptionsEinzelUpgrade standard;

    OptionsUpgradeGruppe specialStandards;

    OptionsEinzelZaehler championOption;

    boolean ordensbanner = false;

    boolean bdVergeltung = false;

    boolean bdVerwuestung = false;

    boolean bdStaerke = false;

    boolean champion = false;

    public DARavenwingCommandSquad() {

        name = "Ravenwing Command Squad\n";

        grundkosten = 0;

        überschriftSetzen = true;





        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Black Knights", 3, 6, 40));



        add(ico = new oc.Picture("oc/wh40k/images/DACommandSquad.gif"));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Kompaniestandarte", "Ravenwing-Kompaniestandarte", 20));

        ogE.addElement(new OptionsGruppeEintrag("Verehrte Standarte", 35));

        add(specialStandards = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));



        seperator();



        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Granatwerfer", "Ravenwing-Granatwerfer", 2, 0));



        seperator();



        add(championOption = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Ravenwing Champion", "Upgrade zum Ravenwing Champion", 1, 5));



        seperator();



        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Ravenwing Apothecary", "Upgrade zum Ravenwing Apothecary", 1, 30));



        complete();

    }



    @Override

    public void deleteYourself() {

        //Einzigartige Banner

        if (ordensbanner) {

            addToInformationVector("DARavenwingStandarte", -1);

        }

        if (champion) {

            addToInformationVector("DARavenChampion", -1);

        }

        super.deleteYourself();

    }



    @Override

    public void refreshen() {



        //Einzigartige Banner

        if (ordensbanner != specialStandards.isSelected("Ravenwing-Kompaniestandarte")) {

            ordensbanner = specialStandards.isSelected("Ravenwing-Kompaniestandarte");

            addToInformationVector("DARavenwingStandarte", (ordensbanner ? 1 : -1));

            RefreshListener.fireRefresh();

        }

        specialStandards.setLegal("Ravenwing-Kompaniestandarte", !specialStandards.isSelected("Ravenwing-Kompaniestandarte") ||

                getCountFromInformationVector("DARavenwingStandarte") <= 1);



        if (champion != championOption.isSelected()) {

            champion = championOption.isSelected();

            addToInformationVector("DARavenChampion", (champion ? 1 : -1));

            RefreshListener.fireRefresh();

        }

        championOption.setLegal(!championOption.isSelected() ||

                getCountFromInformationVector("DARavenChampion") <= 1);

    }



}