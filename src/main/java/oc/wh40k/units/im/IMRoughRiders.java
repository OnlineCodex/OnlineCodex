package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class IMRoughRiders extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o5;

	boolean kamirSelected = false;

	public IMRoughRiders() {
		checkBuildaVater();
		name = "Rough Riders";
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Rough Riders", 5, 10, getPts("RoughRiders") + getPts("Hunting lance"));
		squad.setGrundkosten(getPts("Hunting lance") * -2);
		add(squad);
		
		seperator();

		ogE = IMAstraMilitarumSpecialWeapons.createRK("Hunting lance", "Hunting lance", buildaVater);
		ogE.remove(1); //Sniper r. entf.
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		o1.setAnzahl(0, 2);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Rough Rider Sergeant", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Laspistol", getPts("Laspistol")));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (AM)")));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		o5.setSelected(0, true);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (AM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (AM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power lance (AM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (AM)")));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (AM)")));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		o3.setSelected(0, true);

		complete();
	}

	@Override
	public void refreshen() {
		o2.alwaysSelected();
		o5.alwaysSelected();
		o3.alwaysSelected();
		o1.setLegal(o1.getAnzahl() == 2);
	}


}
