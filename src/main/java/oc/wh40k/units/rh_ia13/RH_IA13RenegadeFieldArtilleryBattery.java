package oc.wh40k.units.rh_ia13;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class RH_IA13RenegadeFieldArtilleryBattery extends Eintrag {

	OptionsZaehlerGruppe FK2;
	OptionsZaehlerGruppe o2;
	OptionsEinzelUpgrade mt;
	OptionsEinzelUpgrade ca;
	OptionsEinzelUpgrade fnp;

	public RH_IA13RenegadeFieldArtilleryBattery() {
		name = "Renegade Field Artillery Battery";
		grundkosten = 0;
        überschriftSetzen=true;
		


        ogE.addElement(new OptionsGruppeEintrag("Quad launcher", 30));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Mortar", 30));
		add(FK2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,4));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Additional Crewman", 3));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sub-flak armour", 5));
		add(ca = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 10));
        add(mt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Militia Training", 10));
		add(fnp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Feel no Pain SR", 10));
        
		
		complete();
	}

	// @OVERRIDE
	public void refreshen() {
		if(!FK2.isSelected()){
			FK2.setAnzahl(0, 1);
		}
		
		o2.setMaxAnzahl(FK2.getAnzahl()*2);
		
		if(getCountFromInformationVector("RHBloodyHandedReaver")==1){
        	mt.setSelected(true);
		}
		
		ca.setAktiv(getCountFromInformationVector("RHBloodyHandedReaver")==1);
		fnp.setAktiv(getCountFromInformationVector("RHHeretekMagus")==1);
	}

}
