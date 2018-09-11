package oc.wh40k.units.da;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DARavenwingAngriffsschwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe trike, o3, o4, o5;
	OptionsEinzelUpgrade boss;
	OptionsEinzelUpgrade o1;
	RuestkammerStarter rkBoss;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o2a;

	boolean added = false;

	public DARavenwingAngriffsschwadron() {
		name = "Ravenwing-Angriffsschwadron";
		grundkosten = -1;
		überschriftSetzen = true;
		neuzeile=true;

		add(ico = new oc.Picture("oc/wh40k/images/DARavenwingAttackSquadron.gif"));

		seperator();

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Ravenwing-Biker", 3, 6, 27);
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
		add(o2a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		o2.setMaxAnzahl(squad.getModelle());
		o2.setAnzahl(0, squad.getModelle());
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Trike", "Ravenwing-Trike", 45));
		add(trike = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o5.setSelected(0, true);

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Land Speeder", 50));
		
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o3.setSelected(0, true);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Typhoon", "Typhoon-Raketenwerfer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 30));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DASergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(false, false, true);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		addToInformationVector("DARavenwingAngriffsschwadron", 1);
		
		complete();
	}

	@Override
	public void deleteYourself() {
		addToInformationVector("DARavenwingAngriffsschwadron", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		
		if(getCountFromInformationVector("Ravenwing Huntmasters")>0){
			squad.setModelle(6);
		}
		
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        o2.setMaxAnzahl(squad.getModelle() -1 -o2a.getAnzahl());
        o2.setAnzahl(0,o2.getMaxAnzahl());
        o2a.setMaxAnzahl(squad.getModelle()-1);
        
        if(squad.getModelle() == 6){
        	o1.setAktiv(true);
        } else {
        	o1.setSelected(false);
        	o1.setAktiv(false);
        	
        }
        
        if(o1.isSelected()){
        	o3.setAktiv(true);
        	o4.setAktiv(true);
        	if(!o3.isSelected()){
        		o3.setSelected(0, true);
        	}
        } else {
        	o3.setAktiv(false);
        	o4.setAktiv(false);
        }
        
        if(trike.isSelected()){
        	o5.setAktiv(true);
        	if(!o5.isSelected()){
        		o5.setSelected(0, true);
        	}
        } else {
        	o5.setAktiv(false);
        }
        
        if(getCountFromInformationVector("Ravenwing Huntmasters")>0){
			o1.setSelected(true);
			trike.setSelected(0, true);
		}
        
        if(getCountFromInformationVector("Ravenwing Huntmasters")>0 && getCountFromInformationVector("DARavenwingAngriffsschwadron")>3){
			setFehlermeldung("max. 3");
		}else{
			setFehlermeldung("");
		}
	}

}
