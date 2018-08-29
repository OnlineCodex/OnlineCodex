package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.ae.AEExarch;

public class CHTzaangorEnlightened extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe weapons;
	OptionsEinzelUpgrade aviarch;
	RuestkammerStarter rkBoss;
	
	public CHTzaangorEnlightened() {

		kategorie = 1;

		name = "Tzaangor Enlightened";
		grundkosten = 0;
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Tzaangor Enlightened", 3, 9, getPts("Tzaangor Enlightened")));
		add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Divining spears", getPts("Divining spear")));
		ogE.addElement(new OptionsGruppeEintrag("Chainswords/Autopistols", getPts("Chainsword") + getPts("Autopistol")));
		ogE.addElement(new OptionsGruppeEintrag("Fatecaster greatbows", getPts("Fatecaster greatbow")));
		add(weapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CHEmptykammer", "Aviarch");
		((CHEmptykammer)rkBoss.getKammer()).type = "Aviarch";
		rkBoss.initKammer();
		rkBoss.setGrundkosten(getPts("Aviarch"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}
	

	@Override
	public void refreshen() {
		weapons.alwaysSelected();
		
		weapons.setPreis("Divining spears", getPts("Divining spear")*(squad.getModelle()));
		weapons.setPreis("Chainswords/Autopistols", (getPts("Chainsword") + getPts("Autopistol"))*(squad.getModelle()));
		weapons.setPreis("Fatecaster greatbows", getPts("Fatecaster greatbow")*(squad.getModelle()));
		
		power = 3;
	}
}
