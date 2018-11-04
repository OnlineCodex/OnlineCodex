package oc.wh40k.units.da;

import oc.*;

public class DADreadnoughts extends Eintrag {

    AnzahlPanel squad;
    OptionsEinzelUpgrade venerable;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3, o4;
    RuestkammerStarter techmarine;
    RuestkammerStarter rkPod;
    RuestkammerStarter rkLuciusPod;

    public DADreadnoughts() {
        name = "Dreadnoughts";

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Dreadnought", "Dreadnoughts", 1, 3, 100);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/DADreadnought.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. MaschKa", "Synchronisierte Maschinenkanone", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Schwebo", "Synchronisierte Schwerer Bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Flamer", "Synchronisierte Schwerer Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 15));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));
        o3.setAnzahl(0, 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 0));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sync. MaschKa", "Synchronisierte Maschinenkanone", 15));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setAnzahl(0, 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flammenwerfer", 10));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));
        o2.setAnzahl(0, 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Zusätzliche Panzerung", 10));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));

        seperator();

        rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
        rkPod.initKammer(false, false, true, false, false, false);
        rkPod.setButtonText("Landungskapsel");
        add(rkPod);

        complete();
    }

    @Override
    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());
        o2.setMaxAnzahl(o1.getAnzahl(0));
        o3.setMaxAnzahl(squad.getModelle());

        rkPod.setAktiv(squad.getModelle() == 1);

        //Detachments
        if (getCountFromInformationVector("Battle Company") > 0) {
            ((DATransporterKammer) rkPod.getKammer()).mod = 0;
        }
    }

}
