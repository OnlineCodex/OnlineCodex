package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORHermanvonStrab extends Eintrag {

	private final OptionsZaehlerGruppe o7;
	private final OptionsZaehlerGruppe o2;
	public ORHermanvonStrab() {
        name = "Herman von Strab";
        grundkosten = 0;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Laserpistole", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 0));
        ogE.addElement(new OptionsGruppeEintrag("Bolter", 1));
        ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 1));
        add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        o7.setAnzahl(0, 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        o2.setAnzahl(0, 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Loorbeer", "Der Lorbeer der Befehlsgewalt", 25));
        ogE.addElement(new OptionsGruppeEintrag("Autoreliquiar", "Das taktische Autoreliquiar des Tyberius", 25));
        ogE.addElement(new OptionsGruppeEintrag("Klinge der Eroberung", "Die Klinge der Eroberung", 25));
        ogE.addElement(new OptionsGruppeEintrag("Todesmaske", "Die Todesmaske des Ollanius", 30));
        ogE.addElement(new OptionsGruppeEintrag("Kurovs Aquila", 60));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 5));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprenggranaten", 2));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plattenrüstung", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tarnmäntel", 10));

        complete();
    }

    // @OVERRIDE
    @Override
	public void refreshen() {

    }

}
