package oc.wh40k.units.in;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class INGefolgeKriegerAkolythen extends RuestkammerVater {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3;
    OptionsZaehlerGruppe o3def;
    OptionsZaehlerGruppe o4;

    public INGefolgeKriegerAkolythen() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Krieger-Akolyth", "Krieger-Akolythen", 1, 12, 4));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolter", 1));
        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
        ogE.addElement(new OptionsGruppeEintrag("HE-Lasergewehr", "Hochenergie-Lasergewehr", 5));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
        ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 20));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Armaplastrüstung", 0));
        add(o3def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Plattenrüstung", 4));
        ogE.addElement(new OptionsGruppeEintrag("Servorüstung", 10));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        sizeSetzen(200, 100, 390, KAMMER_HOEHE + cnt);
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle() * 2 - o2.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle() < 3 ? squad.getModelle() : 3);
        o4.setMaxAnzahl(squad.getModelle());

        o3.setMaxAnzahl(squad.getModelle());
        o3def.setMaxAnzahl(squad.getModelle() - o3.getAnzahl());
        o3def.setAnzahl(0, squad.getModelle() - o3.getAnzahl());
    }

    @Override
    public Object getSpecialValue() {
        return (Integer) squad.getModelle();
    }

}
