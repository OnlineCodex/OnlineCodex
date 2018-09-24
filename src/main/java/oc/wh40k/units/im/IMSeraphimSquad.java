package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.ae.AEExarch;

public class IMSeraphimSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public IMSeraphimSquad() {
		name = "Seraphim Squad\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Seraphim Squad", 5, 10, getPts("Seraphim Squad"));
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASSororitastrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Hand flamers", getPts("Hand flamer (AMI)")*2));
		ogE.addElement(new OptionsGruppeEintrag("2 Inferno pistols", getPts("Inferno pistol (AMI)")*2));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMPrioris", "Upgrade zur Prioris");
		((IMPrioris)rkBoss.getKammer()).type = "Seraphim Superior";
		rkBoss.initKammer(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		
		if(squad.getModelle()<=5)
			power = 4;
		else if(squad.getModelle()<=10)
			power = 8;
	}

}
