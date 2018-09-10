package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CMChaosRelicPredator extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;

	public CMChaosRelicPredator() {
		name = "Relic Predator Tank";
		grundkosten = 75;

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamers", 20));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolters", 20));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", 50));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Autocannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Magna-melta cannon", 45));
		ogE.addElement(new OptionsGruppeEintrag("Flamestorm cannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Conversion Beamer", 65));
		ogE.addElement(new OptionsGruppeEintrag("TL Lascannon", "twin-linked lascannon" , 25));
		ogE.addElement(new OptionsGruppeEintrag("Plasma Destroyer", 35));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra Armour", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combi-bolter", "pintle-mounted combi-bolter",  5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dirge Caster", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer Blade", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warpflame Gargoyles", 5));
        ogE.addElement(new OptionsGruppeEintrag("Combi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-Melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-Plasma", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Havoc Launcher", 12));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Destroyer Blades", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Possession", 15));
		
		complete();
	}

	@Override
	public void refreshen() {
        o2.alwaysSelected();
	}
}
