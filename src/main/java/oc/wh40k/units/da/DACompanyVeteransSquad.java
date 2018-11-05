package oc.wh40k.units.da;

import oc.*;

public class DACompanyVeteransSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe bolter;
    OptionsZaehlerGruppe boltpistolen;
    OptionsZaehlerGruppe boltkett;
    OptionsZaehlerGruppe kettenschwerter;
    OptionsZaehlerGruppe spezial1;
    OptionsZaehlerGruppe spezial2;
    OptionsZaehlerGruppe spezial3;
    OptionsZaehlerGruppe parierschild;
    OptionsZaehlerGruppe melterbomben;
    OptionsZaehlerGruppe sturmschild;


    RuestkammerStarter ot;
    OptionsZaehlerGruppe flakk;

    public DACompanyVeteransSquad() {
        name = "Kompanieveteranentrupp";
        grundkosten = 0;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Kompanieveteranen", 5, 10, 18));

        add(ico = new oc.Picture("oc/wh40k/images/DACompanyVeteransSquad.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
        add(boltpistolen = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
        add(kettenschwerter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        ogE.addElement(new OptionsGruppeEintrag("Boltp. + Kettenschw.", "Boltpistole + Kettenschwert", 0));
        add(boltkett = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Gravstrahler", 10));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
        ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
        ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 30));
        add(spezial1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        bolter.setMaxAnzahl(squad.getModelle());
        boltpistolen.setMaxAnzahl(squad.getModelle());
        bolter.setAnzahl(0, bolter.getMaxAnzahl());
        boltpistolen.setAnzahl(0, boltpistolen.getMaxAnzahl());

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Parierschild", 5));
        add(parierschild = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
        ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
        add(melterbomben = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
        ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 10));
        add(sturmschild = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Gravstrahler", 15));
        add(spezial2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 15));
        ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 20));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Gravkanone", 15));
        add(spezial3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        ogE.addElement(new OptionsGruppeEintrag("Flugabwehrraketen", "Flugabwehrraketen", 10));
        add(flakk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ot = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
        ot.initKammer(true, true, true, false, false, false);
        ot.setButtonText("Transporter");
        add(ot);

        complete();
    }

    @Override
    public void refreshen() {
        boltpistolen.setMaxAnzahl(squad.getModelle() - kettenschwerter.getAnzahl() - boltkett.getAnzahl());
        boltpistolen.setAnzahl(0, boltpistolen.getMaxAnzahl());

        int bokeAbzug = kettenschwerter.getAnzahl() > (spezial1.getAnzahl() + spezial2.getAnzahl() + spezial3.getAnzahl()) ? kettenschwerter.getAnzahl() : (spezial1.getAnzahl() + spezial2.getAnzahl() + spezial3.getAnzahl());

        kettenschwerter.setMaxAnzahl(squad.getModelle() - boltkett.getAnzahl());
        boltkett.setMaxAnzahl(squad.getModelle() - bokeAbzug);

        bolter.setMaxAnzahl(squad.getModelle() - boltkett.getAnzahl() - spezial1.getAnzahl() - spezial2.getAnzahl() - spezial3.getAnzahl());
        bolter.setAnzahl(0, bolter.getMaxAnzahl());

        spezial1.setMaxAnzahl(squad.getModelle() - boltkett.getAnzahl() - spezial2.getAnzahl() - spezial3.getAnzahl());

        int spez2max = (squad.getModelle() == 10 ? 2 : 1) > (squad.getModelle() - boltkett.getAnzahl() - spezial1.getAnzahl() - spezial3.getAnzahl()) ? (squad.getModelle() - boltkett.getAnzahl() - spezial1.getAnzahl() - spezial3.getAnzahl()) : (squad.getModelle() == 10 ? 2 : 1);
        spezial2.setMaxAnzahl(spez2max);

        spezial3.setMaxAnzahl(1 > (squad.getModelle() - boltkett.getAnzahl() - spezial1.getAnzahl() - spezial2.getAnzahl()) ? (squad.getModelle() - boltkett.getAnzahl() - spezial1.getAnzahl() - spezial2.getAnzahl()) : 1);

        parierschild.setMaxAnzahl(squad.getModelle());
        melterbomben.setMaxAnzahl(squad.getModelle());
        sturmschild.setMaxAnzahl(squad.getModelle());

        flakk.setMaxAnzahl(spezial3.isSelected("Raketenwerfer") ? 1 : 0);

        //Detachments
        if (getCountFromInformationVector("Battle Company") > 0) {
            ((DATransporterKammer) ot.getKammer()).mod = 0;
        }
    }

}
