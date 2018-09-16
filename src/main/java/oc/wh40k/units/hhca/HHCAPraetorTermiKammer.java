package oc.wh40k.units.hhca;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class HHCAPraetorTermiKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6, o7, o8;
	OptionsUpgradeGruppe termi, termiFK, termiNK;
	
	public HHCAPraetorTermiKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 7));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 7));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 7));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 7));
		add(termiFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lightning claw", 10));
		ogE.addElement(new OptionsGruppeEintrag("Chain fist", 15));
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Paragon blade", 20));
		add(termiNK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		
		ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 20));
		add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Digital lasers", 15));
		ogE.addElement(new OptionsGruppeEintrag("Iron halo", 10));
		ogE.addElement(new OptionsGruppeEintrag("Master-crafted weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Grenade harness", 10));
		add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 4));

		
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		termiNK.setAktiv(!o7.isSelected());
		termiFK.setAktiv(!o7.isSelected());
		
		if (!termiFK.isSelected()) {
			termiFK.setSelected(0, true);
			}
		if (!termiNK.isSelected()) {
			termiNK.setSelected(0, true);
			}
			
	}



}
