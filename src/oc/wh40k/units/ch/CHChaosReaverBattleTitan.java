package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CHChaosReaverBattleTitan extends Eintrag {

	OptionsUpgradeGruppe o1, o2;
	OptionsZaehlerGruppe o3, o4;
    
	public CHChaosReaverBattleTitan() {
		name = "Chaos Reaver Battle Titan";
		grundkosten = getPts("Chaos Reaver Battle Titan");

		add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Dual turbo-laser destructor", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Titan plasma blastgun", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Titan inferno gun", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Titan Vulcan mega-bolter", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Apocalypse missile launcher", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Incinerator missile bank", getPts("")));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Reaver gatling blaster", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Reaver laser blaster", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Reaver volcano cannon", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Reaver melta cannon", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Reaver power fist", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Reaver chainfist", getPts("")));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		complete();
	}

	@Override
	public void refreshen() {
		
		o3.setLegal(o3.getAnzahl()==1);
		o4.setLegal(o4.getAnzahl()==2);
		
		power = 120;
	}

}
