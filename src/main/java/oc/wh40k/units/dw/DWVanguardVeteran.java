package oc.wh40k.units.dw;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DWVanguardVeteran extends RuestkammerVater {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2, o3, o4;
    OptionsEinzelUpgrade boltpistole, handwaffe;
    OptionsEinzelUpgrade flakk, hellfire;
    OptionsEinzelUpgrade thunderhammer;

    public DWVanguardVeteran() {
        grundkosten = 22;
    }

    @Override
    public void initButtons(boolean... defaults) {

        add(boltpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole", 0));
        boltpistole.setSelected(true);
        add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Nahkampfwaffe", 0));
        handwaffe.setSelected(true);

        ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiestab", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", 5));
        ogE.addElement(new OptionsGruppeEintrag("Hand-Flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Grav-Pistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Infernus-Pistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 20));
        ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(thunderhammer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schwerer Energiehammer", 30));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        int maxWeapons = 2 - (boltpistole.isSelected() ? 1 : 0) - (handwaffe.isSelected() ? 1 : 0) - (thunderhammer.isSelected() ? 2 : 0);
        o1.setMaxAnzahl(maxWeapons);
        thunderhammer.setAktiv(!boltpistole.isSelected() && !handwaffe.isSelected() && !o1.isSelected());
    }

}
