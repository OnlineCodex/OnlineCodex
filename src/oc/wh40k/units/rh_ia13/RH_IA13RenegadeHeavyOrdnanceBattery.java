package oc.wh40k.units.rh_ia13;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class RH_IA13RenegadeHeavyOrdnanceBattery extends Eintrag {

	OptionsZaehlerGruppe FK2;
	OptionsEinzelZaehler crew;
	OptionsEinzelUpgrade mt;
	OptionsEinzelUpgrade ca;
	OptionsEinzelUpgrade fnp;

	public RH_IA13RenegadeHeavyOrdnanceBattery() {
        grundkosten = 0;
        name = "Renegade Heavy Ordnance Battery";
        
		ogE.addElement(new OptionsGruppeEintrag("Earthshaker cannon", 55));
		ogE.addElement(new OptionsGruppeEintrag("Medusa siege gun", 80));
		ogE.addElement(new OptionsGruppeEintrag("Medusa siege gun (breacher)","Medusa siege gun with breacher shells", 85));
		add(FK2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,3));

        seperator();

        add(crew = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Add. Renegade Crew", 4, 3));
        
        seperator();
        
        add(mt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Militia Training", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sub-flak armour", 5));
		add(ca = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 10));
		add(fnp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Feel no Pain SR", 10));
		
		complete();

	}

	//@OVERRIDE
	public void refreshen() {
		
		if(!FK2.isSelected()){
			FK2.setAnzahl(0, 1);
		}
		
		crew.setMaxAnzahl(FK2.getAnzahl()*4);
		
		if(getCountFromInformationVector("RHBloodyHandedReaver")==1){
        	mt.setSelected(true);
		}
		
		ca.setAktiv(getCountFromInformationVector("RHBloodyHandedReaver")==1);
		fnp.setAktiv(getCountFromInformationVector("RHHeretekMagus")==1);
	}
}
