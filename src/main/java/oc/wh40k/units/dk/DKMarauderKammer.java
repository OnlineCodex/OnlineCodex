package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKMarauderKammer extends RuestkammerVater {

        OptionsUpgradeGruppe o1;
        OptionsUpgradeGruppe m1;
        OptionsEinzelUpgrade o2;

	public DKMarauderKammer() {}
	
	public void initButtons(boolean... b) {
		ogE.addElement(new OptionsGruppeEintrag("Marauder Bomber", 400));
		ogE.addElement(new OptionsGruppeEintrag("Marauder Destroyer",420));
		add(m1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		

		add(ico = new oc.Picture("oc/wh40k/images/MarauderKampfbomber.gif"));
		
		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bomben","zwölf Bomben", 0));
		ogE.addElement(new OptionsGruppeEintrag("Höllensturm-Bomben","zwei Höllensturm-Bomben",0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		add(o2=new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hellstrike missiles", "eight Hellstrike missiles", 80));
		
		sizeSetzen();

	}

	public void refreshen() {
		
		if (!m1.isSelected()) m1.setSelected(0,true);
		o1.setAktiv(m1.isSelected(0));
		o2.setAktiv(m1.isSelected(1));
        if (!o1.isSelected()) o1.setSelected(0,true);
	}
}
