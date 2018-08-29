package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.ae.AEExarch;

public class IMDominionSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public IMDominionSquad() {
		name = "Dominion Squad\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Dominion Squad", 5, 10, getPts("Dominion Squad"));
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASSororitastrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (AMI)")));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (AMI)")));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (AMI)")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMPrioris", "Upgrade zur Prioris");
		((IMPrioris)rkBoss.getKammer()).type = "Sister Superior";
		rkBoss.initKammer(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		
		if(squad.getModelle()<=5)
			power = 5;
		else if(squad.getModelle()<=10)
			power = 9;
	}

}
