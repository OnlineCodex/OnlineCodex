package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.ae.AEExarch;

public class IMRepentiaSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public IMRepentiaSquad() {
		name = "Repentia Squad\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Repentias", 3, 9, getPts("Repentia Squad"));
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASSororitastrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Penitent eviscerators", getPts("Penitent eviscerator")*squad.getModelle()));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setPreis(0, getPts("Penitent eviscerator")*squad.getModelle());
		o1.alwaysSelected();
		
		if(squad.getModelle()<=3)
			power = 3;
		else if(squad.getModelle()<=6)
			power = 6;
		else if(squad.getModelle()<=9)
			power = 9;
	}

}
