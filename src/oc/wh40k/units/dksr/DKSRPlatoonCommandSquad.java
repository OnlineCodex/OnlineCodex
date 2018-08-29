package oc.wh40k.units.dksr;

import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DKSRPlatoonCommandSquad extends RuestkammerVater {

	OptionsZaehlerGruppe o22;
	OptionsEinzelZaehler oe2;
	OptionsEinzelZaehler oe3;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o4x;
    OptionsEinzelUpgrade mb;
	OptionsEinzelUpgrade commissar;
	OptionsEinzelUpgrade com1;
	OptionsEinzelUpgrade com2;
	OptionsEinzelUpgrade commander;

	public DKSRPlatoonCommandSquad() {
		grundkosten = 50;
	}
	
  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGCommandSquad.jpg"));
		

		seperator();

		add(commander = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Platoon Commander", 0));

        seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 1));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power maul", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power lance", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator(5);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 3));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "melta-bombs", 5));

		seperator();

		add(commissar = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Commissar", 30));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 1));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power maul", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power lance", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o22 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator(5);

		add(com1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 3));
		add(com2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "melta-bombs", 5));
		
		seperator();

		add(oe2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Platoon standard", 1, 10));
		add(oe3 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vox-caster", 1, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Guardsman with Lasgun", 0));
		add(o4x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Guardsman with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Guardsman with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Guardsman with Melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Guardsman with Plasma gun", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		sizeSetzen();
	}

  @Override
	public void refreshen() {
        commander.setSelected(true);

		o22.setAktiv(commissar.isSelected());
		com1.setAktiv(commissar.isSelected());
		com2.setAktiv(commissar.isSelected());

		o4.setMaxAnzahl(4-(oe2.getAnzahl() + oe3.getAnzahl())); //Spez
        if(o4.getMaxAnzahl()>2){
        	o4.setMaxAnzahl(2);
        }
        if(o4.getMaxAnzahl()<0){
        	o4.setMaxAnzahl(0);
        }
        
        
        oe3.setMaxAnzahl((4-(oe2.getAnzahl() + o4.getAnzahl()))>0?1:0);//Vox
        oe2.setMaxAnzahl((4-(oe3.getAnzahl() + o4.getAnzahl()))>0?1:0);//Standarte

        o4x.setMaxAnzahl(4 - o4.getAnzahl());
        o4x.setAnzahl(0, 4 - o4.getAnzahl());
	}

}
