package oc.wh40k.units.as;

import java.util.Vector;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ASSchaarderBussfertigen extends Eintrag {
	 
	RuestkammerStarter principalis;
    Vector<RuestkammerStarter> repentias = new Vector<RuestkammerStarter>();//3+
    Vector<RuestkammerStarter> laeuterer = new Vector<RuestkammerStarter>();//3+
    
	public ASSchaarderBussfertigen() {
		name = "Schaar der Buﬂfertigen";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/ASSchaarderBussfertigen.gif"));
		
		principalis =new RuestkammerStarter(ID, randAbstand, cnt, "ASPrincipalisKammer", "Principalis",1);
		principalis.initKammer();
        add(principalis);

		seperator();
        
        for(int i=0;i<4;i++){
        	repentias.add(new RuestkammerStarter(ID, randAbstand, cnt, "ASRepentiatruppKammer", "Repentias",1));
        	repentias.get(i).initKammer();
	        add(repentias.get(i));
        }
        repentias.get(3).setAktiv(false);
        
        for(int i=0;i<4;i++){
        	laeuterer.add(new RuestkammerStarter(ID, randAbstand, cnt, "ASLaeutererKammer", "L‰uterer",1));
        	laeuterer.get(i).initKammer();
            add(laeuterer.get(i));
        }
        laeuterer.get(1).setAktiv(false);
       
        
    	complete();

	}

	public void refreshen() {
		//principalis.setSelected(true);
		principalis.setLegal(principalis.isSelected());
		
		adjustOptions(repentias,3,"ASRepentiatruppKammer", "Repentias",1,1);
		repentias.get(0).setLegal(repentias.get(0).isSelected());
		repentias.get(1).setLegal(repentias.get(1).isSelected());
		repentias.get(2).setLegal(repentias.get(2).isSelected());
		repentias.get(3).setAktiv(repentias.get(2).isSelected() && repentias.get(1).isSelected() && repentias.get(0).isSelected());
		repentias.get(0).setAktiv(true);
		repentias.get(1).setAktiv(true);
		repentias.get(2).setAktiv(true);
		
		adjustOptions(laeuterer,3,"ASLaeutererKammer", "L‰uterer",1+repentias.size(),1);
		laeuterer.get(0).setLegal(laeuterer.get(0).isSelected());
		laeuterer.get(1).setLegal(laeuterer.get(1).isSelected());
		laeuterer.get(2).setLegal(laeuterer.get(2).isSelected());
		laeuterer.get(3).setAktiv(laeuterer.get(2).isSelected() && laeuterer.get(1).isSelected() && laeuterer.get(0).isSelected());
		laeuterer.get(0).setAktiv(true);
		laeuterer.get(1).setAktiv(true);
		laeuterer.get(2).setAktiv(true);

		aktualisiereKammerStarterLocation();
		
	}
	
	//Entfernt aus dem Vektor alle ¸berz‰hligen nicht ausgew‰hlten Eintr‰ge.
	//F¸gt einen neuen ausw‰hlbaren Eintrag hinter dem letzten der gleichen Einheit ein, falls alle ausgew‰hlt wurden.
	public void adjustOptions(Vector<RuestkammerStarter> starter, int minOptions, String unit, String unitName, int offset, int einrueck){
		
		
		for(int i=0;i<starter.size()-1 && starter.size()>(minOptions+1);i++){
			if(!starter.get(i).isSelected()){
				remove(starter.get(i));
				starter.remove(i);
				i--;
			}
		}
		
		if(starter.lastElement().isSelected()){
			RuestkammerStarter ruest = new RuestkammerStarter(ID, randAbstand, cnt, unit, unitName,einrueck);
			starter.add(ruest);
			ruest.initKammer();
			addAt(ruest, offset+starter.size()-1);
		}
	
	}
	
	
}
