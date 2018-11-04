package oc.wh40k.units.in;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class INPriester extends RuestkammerVater {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3;

    public INPriester() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Priester", "Priester", 1, 12, 25));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
        ogE.addElement(new OptionsGruppeEintrag("Eviscerator", 30));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmgewehr", 0));
        ogE.addElement(new OptionsGruppeEintrag("Bolter", 1));
        ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 1));
        ogE.addElement(new OptionsGruppeEintrag("Shotgun", 1));
        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Condemnor Bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        sizeSetzen(200, 100, 390, KAMMER_HOEHE + cnt);
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o2.setMaxAnzahl(squad.getModelle());
        o3.setMaxAnzahl(squad.getModelle());
    }

    @Override
    public Object getSpecialValue() {
        return (Integer) squad.getModelle();
    }

}
