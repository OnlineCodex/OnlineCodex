package oc.wh40k.units.da;

import oc.*;

public class DACommandSquad extends Eintrag {

    OptionsEinzelZaehler championOption;
    OptionsEinzelZaehler apoOption;
    OptionsEinzelUpgrade standard;
    OptionsUpgradeGruppe specialStandards;
    RuestkammerStarter ot;
    OptionsEinzelZaehler o1, bomben, sturmschild, kettenschwert, boltpistole;
    OptionsZaehlerGruppe waffen;
    boolean ordensbanner = false;
    boolean bdVergeltung = false;
    boolean bdVerwuestung = false;
    boolean bdStaerke = false;
    public DACommandSquad() {
        name = "Kommandotrupp";
        grundkosten = 90;

        add(ico = new oc.Picture("oc/wh40k/images/DACommandSquad.gif"));

        seperator();

        add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Plasmapistole", 2, 15));

        add(bomben = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Melterbomben", 5, 5));
        add(sturmschild = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sturmschild", 5, 15));

        seperator(8);
        add(boltpistole = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Boltpistole", 5, 0));
        boltpistole.setAnzahl(5);
        add(kettenschwert = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Kettenschwert", 5, 0));
        kettenschwert.setAnzahl(5);

        ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", "Kombiflammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombimelter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombiplasmawerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Gravstrahler", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Gravstrahler", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
        ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 35));
        add(waffen = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 10));

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Kompaniestandarte", 15));
        ogE.addElement(new OptionsGruppeEintrag("Verehrte Standarte", 35));
        ogE.addElement(new OptionsGruppeEintrag("Ordensbanner", "Ordensbanner der Dark Angels", 25));
        add(specialStandards = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(championOption = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Kompaniechampion", "Upgrade zum Kompaniechampion", 1, 15));

        seperator();

        add(apoOption = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Apothecarius", "Upgrade zum Apothecarius", 1, 15));

        seperator();

        ot = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
        ot.initKammer(true, true, true, false, false, false);
        ot.setButtonText("Transporter");
        add(ot);

        complete();
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("DAKommando", -1);
        //Einzigartige Banner
        if (ordensbanner) {
            addToInformationVector("DAOrdensbanner", -1);
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
        super.deleteYourself();
    }

    @Override
    public void refreshen() {
        int subs = championOption.getAnzahl() + apoOption.getAnzahl();


        bomben.setMaxAnzahl(5 - subs);
        sturmschild.setMaxAnzahl(5 - subs);
        boltpistole.setMaxAnzahl(5 - subs);
        kettenschwert.setMaxAnzahl(5 - subs);

        waffen.setMaxAnzahl(10 - (subs * 2) - kettenschwert.getAnzahl() - boltpistole.getAnzahl() - o1.getAnzahl());

        int freierpool = (5 - subs) * 2 - boltpistole.getAnzahl() - kettenschwert.getAnzahl() - waffen.getAnzahl();
        if (freierpool > (5 - subs - boltpistole.getAnzahl())) {
            freierpool = 5 - subs - boltpistole.getAnzahl();
        }
        if (freierpool < 0) {
            freierpool = 0;
        }
        o1.setMaxAnzahl(freierpool);

        //Einzigartige Banner
        if (ordensbanner != specialStandards.isSelected("Ordensbanner der Dark Angels")) {
            ordensbanner = specialStandards.isSelected("Ordensbanner der Dark Angels");
            addToInformationVector("DAOrdensbanner", (ordensbanner ? 1 : -1));
            RefreshListener.fireRefresh();
        }
        specialStandards.setLegal("Ordensbanner der Dark Angels", !specialStandards.isSelected("Ordensbanner der Dark Angels") ||
                getCountFromInformationVector("DAOrdensbanner") <= 1);

        //Detachments
        if (getCountFromInformationVector("Battle Company") > 0) {
            ((DATransporterKammer) ot.getKammer()).mod = 0;
        }
    }

}
