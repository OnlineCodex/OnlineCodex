package oc.wh40k.units.rh_ia13;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class RH_IA13RenegadeOgrynBrutes extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade pack;
	OptionsEinzelZaehler hounds;
	OptionsUpgradeGruppe oug;


	public RH_IA13RenegadeOgrynBrutes() {
		name = "Renegade Ogryn Berserkers\n";
		grundkosten = 0;
		überschriftSetzen=true;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Ogryn Brute", 1, 10, 60);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGOgrynSquad.jpg"));

		seperator();
		
		add(pack = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Packmaster", 0));
		add(hounds = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Chaos hound", 6, 30));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Laser cutter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power drill", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Flak armour", 10));
		ogE.addElement(new OptionsGruppeEintrag("Carapace armour", 25));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Dedication to Khorne", 25));
		ogE.addElement(new OptionsGruppeEintrag("Dedication to Nurgle", 35));
		ogE.addElement(new OptionsGruppeEintrag("Dedication to Slaanesh", 25));
		ogE.addElement(new OptionsGruppeEintrag("Dedication to Tzeentch", 25));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Curse of Mutation", 15));
		add(oug = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
	}

	@Override
	public void refreshen() {
		hounds.setAktiv(pack.isSelected());
		oug.setAktiv(getCountFromInformationVector("RHMutantOverlord")==1);
	}

}
