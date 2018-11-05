package oc.wh40k.units.da;



import oc.*;



public class DADeathwingCommandSquad extends Eintrag {



    OptionsEinzelZaehler championOption, sergeantOption;

    OptionsEinzelZaehler apoOption;

    OptionsEinzelUpgrade standard;

    OptionsUpgradeGruppe specialStandards;

    RuestkammerStarter ot;

    OptionsEinzelZaehler energiefaust, sturmbolter;

    OptionsZaehlerGruppe o1, o3, waffen, cyclone;

    boolean ordensbanner = false;

    boolean bdVergeltung = false;

    boolean bdVerwuestung = false;

    boolean bdStaerke = false;

    boolean champion = false;

    public DADeathwingCommandSquad() {

        name = "Deathwing-Kommandotrupp";

        grundkosten = 200;



        add(ico = new oc.Picture("oc/wh40k/images/DACommandSquad.gif"));



        seperator();



        add(sturmbolter = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sturmbolter", 5, 0));

        sturmbolter.setAnzahl(5);

        ogE.addElement(new OptionsGruppeEintrag("Cyclone", "Cyclone-Raketenwerfer", 25));

        add(cyclone = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));

        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 15));

        ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 20));

        add(waffen = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator(8);



        add(energiefaust = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Energiefaust", 5, 0));

        energiefaust.setAnzahl(5);



        ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 0));

        ogE.addElement(new OptionsGruppeEintrag("Hammer & Schild", "Energiehammer & Sturmschild", 5));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));



        ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 5));

        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));



        seperator(5);



        ogE.addElement(new OptionsGruppeEintrag("Kompaniestandarte", "Deathwing-Kompaniestandarte", 20));

        ogE.addElement(new OptionsGruppeEintrag("Verehrte Standarte", 35));

        add(specialStandards = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));



        seperator();



        add(sergeantOption = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Deathwing-Sergeant", "Upgrade zum Deathwing-Sergeant", 1, 0));



        seperator();



        add(championOption = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Deathwing-Champion", "Upgrade zum Deathwing-Champion", 1, 5));



        seperator();



        add(apoOption = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Deathwing-Apothecarius", "Upgrade zum Deathwing-Apothecarius", 1, 5));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Düsteres Relikt der alten Legion", "Düsteres Relikt", 15));



        seperator();



        ot = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");

        ot.initKammer(false, false, false, true, true, false);

        ot.setButtonText("Transporter");

        add(ot);



        complete();

    }



    @Override

    public void deleteYourself() {

        addToInformationVector("DATermiKommando", -1);

        //Einzigartige Banner

        if (ordensbanner) {

            addToInformationVector("DADeathwingStandarte", -1);

        }

        if (bdVergeltung) {

            addToInformationVector("DABannerDerVergeltung", -1);

        }

        if (bdVerwuestung) {

            addToInformationVector("DABannerDerVerwuestung", -1);

        }

        if (bdStaerke) {

            addToInformationVector("DABannerDerStaerke", -1);

        }

        if (champion) {

            addToInformationVector("DADeathChampion", -1);

        }

        super.deleteYourself();

    }



    @Override

    public void refreshen() {

        int equipable = 5 - championOption.getAnzahl() - apoOption.getAnzahl() - sergeantOption.getAnzahl();

        int nkSub = (waffen.getAnzahl() > o3.getAnzahl()) ? waffen.getAnzahl() : o3.getAnzahl();

        o1.setMaxAnzahl(equipable - nkSub);



        sturmbolter.setMaxAnzahl(5 - championOption.getAnzahl() - waffen.getAnzahl() - o1.getAnzahl());

        sturmbolter.setAnzahl(sturmbolter.getMaxAnzahl());



        energiefaust.setMaxAnzahl(equipable - o3.getAnzahl() - o1.getAnzahl());

        energiefaust.setAnzahl(energiefaust.getMaxAnzahl());



        o3.setMaxAnzahl(equipable - o1.getAnzahl());

        if ((equipable - o1.getAnzahl()) > 0 && !cyclone.isSelected()) {

            waffen.setMaxAnzahl(1);

        } else {

            waffen.setMaxAnzahl(0);

        }



        cyclone.setMaxAnzahl(1 - waffen.getAnzahl());



        //Einzigartige Banner

        if (ordensbanner != specialStandards.isSelected("Deathwing-Kompaniestandarte")) {

            ordensbanner = specialStandards.isSelected("Deathwing-Kompaniestandarte");

            addToInformationVector("DADeathwingStandarte", (ordensbanner ? 1 : -1));

            RefreshListener.fireRefresh();

        }

        specialStandards.setLegal("Deathwing-Kompaniestandarte", !specialStandards.isSelected("Deathwing-Kompaniestandarte") ||

                getCountFromInformationVector("DADeathwingStandarte") <= 1);





        if (champion != championOption.isSelected()) {

            champion = championOption.isSelected();

            addToInformationVector("DADeathChampion", (champion ? 1 : -1));

            RefreshListener.fireRefresh();

        }

        championOption.setLegal(!championOption.isSelected() ||

                getCountFromInformationVector("DADeathChampion") <= 1);



    }



}