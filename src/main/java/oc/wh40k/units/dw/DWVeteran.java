package oc.wh40k.units.dw;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DWVeteran extends RuestkammerVater {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2, o3, o4;
    OptionsZaehlerGruppe bolter;
    OptionsZaehlerGruppe handwaffe;
    OptionsEinzelUpgrade flakk, hellfire;
    OptionsEinzelUpgrade heavyThunderhammer;

    boolean isSergeant = false;

    public DWVeteran() {
        grundkosten = 22;
    }

    @Override
    public void initButtons(boolean... defaults) {
        try {
            isSergeant = defaults[0];
        } catch (Exception e) {
        }

        ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", 0));
        add(handwaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        bolter.setAnzahl(0, 1);
        handwaffe.setAnzahl(0, 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
        ogE.addElement(new OptionsGruppeEintrag("Hand-Flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Grav-Pistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Infernus-Pistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
        ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
        ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 10));
        if (isSergeant) ogE.addElement(new OptionsGruppeEintrag("Xenophase Schwert", 25));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

        cnt = randAbstand;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Infernus schwerer Bolter", 20));
        ogE.addElement(new OptionsGruppeEintrag("Schrappnellkanone", 25));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, -88));

        add(hellfire = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "option", "Hellfire", 5));
        add(flakk = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "option", "Flugabwehrraketen", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Stalker Bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Gravgewehr", 15));
        ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, -88));

        seperator();

        add(heavyThunderhammer = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Schwerer Energiehammer", 30));

        seperator();

        if (isSergeant) {
            add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Auspex", 5));
            add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Parierschild", 5));
            add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Melterbomben", 5));
            add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Teleport-Peilsender", 10));
            add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Digitalwaffen", 10));
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        heavyThunderhammer.setAktiv(!bolter.isSelected() && !handwaffe.isSelected() && !o1.isSelected() && !o2.isSelected() && !o3.isSelected() && !o4.isSelected());
        hellfire.setAktiv(o3.isSelected("Schwerer Bolter") || o3.isSelected("Infernus schwerer Bolter"));
        flakk.setAktiv(o3.isSelected("Raketenwerfer"));

        int possibleRangedWeapons = 2 - handwaffe.getAnzahl() - bolter.getAnzahl() - o2.getAnzahl() - o3.getAnzahl() - o4.getAnzahl();
        int possibleMeleeWeapons = 2 - handwaffe.getAnzahl() - bolter.getAnzahl() - o1.getAnzahl() - o3.getAnzahl() - o4.getAnzahl();
        int possibleSpecialWeapons = 1 - bolter.getAnzahl() - o3.getAnzahl();
        int possibleHeavyWeapons = 1 - bolter.getAnzahl() - o4.getAnzahl();

        o1.setMaxAnzahl(possibleRangedWeapons);
        o2.setMaxAnzahl(possibleMeleeWeapons);
        o3.setMaxAnzahl(possibleHeavyWeapons);
        o4.setMaxAnzahl(possibleSpecialWeapons);
    }

}
