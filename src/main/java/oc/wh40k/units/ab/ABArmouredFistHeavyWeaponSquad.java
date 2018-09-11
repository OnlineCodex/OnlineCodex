package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ABArmouredFistHeavyWeaponSquad extends Eintrag {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1a;
	OptionsEinzelZaehler oe1;
    RuestkammerStarter rkTransport;

	public ABArmouredFistHeavyWeaponSquad() {
		name = "Armoured Fist Heavy Weapon Squad";
		grundkosten = 60;
		überschriftSetzen=true;
	
		add(ico = new oc.Picture("oc/wh40k/images/IGHeavyWeaponsSquad.jpg"));
		

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Voxcaster", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Frag grenades", 6));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 12));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mortar", 0));
		add(o1a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		add(oe1=new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Flakk missiles",3, 15));

		seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ABChimeraKammer", "Chimera Transport");
		rkTransport.initKammer();
        rkTransport.setAbwaehlbar(false);
		add(rkTransport);
		
		complete();
	}

    @Override
	public void refreshen() {
    	o1a.setMaxAnzahl(3-o1.getAnzahl());
    	o1a.setAnzahl(0, o1a.getMaxAnzahl());
		oe1.setMaxAnzahl(o1.getAnzahl(2));
	}

}
