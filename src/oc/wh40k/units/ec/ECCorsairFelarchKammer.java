package oc.wh40k.units.ec;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ECCorsairFelarchKammer extends RuestkammerVater {

    OptionsZaehlerGruppe o1, o1x;
    OptionsEinzelUpgrade key;
    OptionsEinzelUpgrade master;
    OptionsEinzelUpgrade fnp;
	
	public ECCorsairFelarchKammer() {
		grundkosten = 5;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		ogE.addElement(new OptionsGruppeEintrag("Lasblaster", 0));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Close combat weapon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power maul", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power lance", 15));
		ogE.addElement(new OptionsGruppeEintrag("Venom blade", 10));
		ogE.addElement(new OptionsGruppeEintrag("Blast pistol", 20));
		ogE.addElement(new OptionsGruppeEintrag("Dissonance pistol", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		add(key = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multiph. key gen.","Multiphase key generator", 15));
		add(master = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "master-crafted", 10));
		add(fnp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "FNP(5+) SR", 10));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1x.setMaxAnzahl(1-(o1.isSelected()?1:0));
    	o1x.setAnzahl(0,1-(o1.isSelected()?1:0));
        o1.setMaxAnzahl(2);
        key.setAktiv(getCountFromInformationVector("ECPrinceTrait")==1);
        master.setAktiv(getCountFromInformationVector("ECPrinceTrait")==2);
        fnp.setAktiv(getCountFromInformationVector("ECPrinceTrait")==5);
	}

}
