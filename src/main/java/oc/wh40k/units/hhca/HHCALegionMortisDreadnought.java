package oc.wh40k.units.hhca;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class HHCALegionMortisDreadnought extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o4;
	OptionsZaehlerGruppe o3;
	//RuestkammerStarter rkTransport;

	public HHCALegionMortisDreadnought () {
		name = "Legion Mortis Dreadnought";
		grundkosten = 125;

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolters", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multi-meltas", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked autocannons", 10));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked missile launchers", 20));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked lascannons", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Extra Armour", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));	
		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missiles", 10));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));		
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		seperator();

		/*rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransporterKammer", "Dedicated transport");
		//Rhino, Pod, Dreadclaw, Phobos, Spartan
		rkTransport.initKammer(false, true, true, false, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);*/
		
        complete();
	}

	@Override
	public void refreshen() {
			if (!o1.isSelected()) o1.setSelected(0, true);
			o3.setAktiv(!o4.isSelected());
			o4.setAktiv(!o3.isSelected());
    		
	}

}
