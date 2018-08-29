package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ABTechpriestEngineseer extends Eintrag {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsEinzelUpgrade trojan;
    OptionsUpgradeGruppe trojanWpn;
    OptionsUpgradeGruppe trojanUp;

	public ABTechpriestEngineseer() {
		name = "Techpriest Engineseer";
		grundkosten = 45;
		this.setEintragsCNT(0);

		addToInformationVector("ABTechpriestEngineseer", 1);

		add(ico = new oc.Picture("oc/wh40k/images/IGMinistrorumPriest.jpg"));

		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Melta bombs", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servitor", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 30));
		ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 30));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

		seperator();

		add(trojan =new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Trojan Support Vehicle", 35));

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter","Pintle-mounted heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber","Pintle-mounted heavy stubber", 10));
		add(trojanWpn = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
		ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 10));
		ogE.addElement(new OptionsGruppeEintrag("Extra armour", 15));
		ogE.addElement(new OptionsGruppeEintrag("Camo-netting", 20));
		add(trojanUp = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 4));

		complete();
	}

	@Override
	public void refreshen() {
		trojanUp.setAktiv(trojan.isSelected());
		trojanWpn.setAktiv(trojan.isSelected());
		
		if(getCountFromInformationVector("ABTechpriestEngineseer") > 2) {
			setFehlermeldung("0-2 Auswahl!");
		} else {
			setFehlermeldung("");
		}
        
        o2.setMaxAnzahl(o1.getAnzahl() > 2 ? 2 : o1.getAnzahl());
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		addToInformationVector("ABTechpriestEngineseer", -1);
	}

}
