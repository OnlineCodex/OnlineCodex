package oc.wh40k.units.sm;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class SMProtektorSergeant extends RuestkammerVater {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe bolter;
    OptionsZaehlerGruppe boltpistole;

    public SMProtektorSergeant() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
        add(boltpistole = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        bolter.setAnzahl(0, 1);
        boltpistole.setAnzahl(0, 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Grav", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

        seperator();


        ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
        ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Grav-Pistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(1 - bolter.getAnzahl() - (boltpistole.isSelected() ? o2.getAnzahl() : 0));
        o2.setMaxAnzahl(2 - boltpistole.getAnzahl() - (bolter.getAnzahl() > o1.getAnzahl() ? bolter.getAnzahl() : o1.getAnzahl()));

        boolean legal = o1.getAnzahl() + o2.getAnzahl() + bolter.getAnzahl() + boltpistole.getAnzahl() == 2;
        boltpistole.setLegal(legal);
        bolter.setLegal(legal);
        o1.setLegal(legal);
        o2.setLegal(legal);
    }

}
