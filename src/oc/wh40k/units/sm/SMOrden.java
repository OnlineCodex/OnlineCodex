package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;

public class SMOrden extends Eintrag {

    OptionsUpgradeGruppe ordenHaupt;
	int orden=-1;

	public SMOrden() {
		grundkosten = 0;
		name="Orden:";
		überschriftSetzen=true;
		this.setEintragsCNT(0);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Ultramarines", 0));
		ogE.addElement(new OptionsGruppeEintrag("White Scars", 0));
		ogE.addElement(new OptionsGruppeEintrag("Imperial Fists", 0));
		ogE.addElement(new OptionsGruppeEintrag("Black Templars", 0));
		ogE.addElement(new OptionsGruppeEintrag("Iron Hands", 0));
		ogE.addElement(new OptionsGruppeEintrag("Salamanders", 0));//Each Character may upgrade one Weapon to an mastercrafted one (0)
		ogE.addElement(new OptionsGruppeEintrag("Raven Guard", 0));
		ogE.addElement(new OptionsGruppeEintrag("[FW] Red Scorpions", 0)); //Tactical sarges und Vet Sarges duerfen Narthecium erhalten 
		ogE.addElement(new OptionsGruppeEintrag("[FW] Carcharodons", 0));//alle Tcticals mit Bolter: bolter gegen ccw (0) oder +1ccw (1) //Nur mit Imperialer Fraktion verbünden (desperate allies)
		ogE.addElement(new OptionsGruppeEintrag("[FW] Howling Griffons", 0));//Ultras
		//ogE.addElement(new OptionsGruppeEintrag("[FW] Lamenters", 0)); //BA
		ogE.addElement(new OptionsGruppeEintrag("[FW] Fire Angels", 0));//Ultras
		ogE.addElement(new OptionsGruppeEintrag("[FW] Marines Errant", 0));//Ultras
		ogE.addElement(new OptionsGruppeEintrag("[FW] Raptors", 0)); //Raven Guard
		ogE.addElement(new OptionsGruppeEintrag("[FW] Exorcists", 0));//kann jeder Grundorden sein...
		ogE.addElement(new OptionsGruppeEintrag("[FW] Mantis Warriors", 0));
		ogE.addElement(new OptionsGruppeEintrag("[FW] Red Scorpions", 0));
		ogE.addElement(new OptionsGruppeEintrag("[FW] Executioners", 0));
		ogE.addElement(new OptionsGruppeEintrag("[FW] Angels Revenant", 0));//Ultras
		ogE.addElement(new OptionsGruppeEintrag("[FW] Red Hunters", 0));//GK und AS mit Inq zählen als BB
		ogE.addElement(new OptionsGruppeEintrag("[FW] Star Phantoms", 0));
		ogE.addElement(new OptionsGruppeEintrag("[FW] Minotaurus", 0));
		ogE.addElement(new OptionsGruppeEintrag("[FW] Sons of Medusa", 0));//Iron Hands
		ogE.addElement(new OptionsGruppeEintrag("[FW] Novamarines", 0));
		ogE.addElement(new OptionsGruppeEintrag("[FW] Fire Hawks", 0));//Ranged Weapon list: Hand flamer (5)
		ogE.addElement(new OptionsGruppeEintrag("[FW] Astral Claws", 0));
		add(ordenHaupt = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		System.out.println(ally);
		
		complete();
	}

	@Override
	public void deleteYourself() {
			setInformationVectorValue("SMUltramarines", 0);
			setInformationVectorValue("SMWhiteScars", 0);
			setInformationVectorValue("SMImperialFists", 0);
			setInformationVectorValue("SMBlackTemplars", 0);
			setInformationVectorValue("SMIronHands", 0);
			setInformationVectorValue("SMSalamanders", 0);
			setInformationVectorValue("SMRavenGuard", 0);
			setInformationVectorValue("SMRedScorpions", 0);
			setInformationVectorValue("SMCarcharodons", 0);
			setInformationVectorValue("SMExorcists", 0);
			setInformationVectorValue("SMMantisWarriors", 0);
			setInformationVectorValue("SMRedScorpions", 0);
			setInformationVectorValue("SMExecutioners", 0);
			setInformationVectorValue("SMRedHunters", 0);
			setInformationVectorValue("SMStarPhantoms", 0);
			setInformationVectorValue("SMMinotaurus", 0);
			setInformationVectorValue("SMNovamarines", 0);
			setInformationVectorValue("SMFireHawks", 0);
			setInformationVectorValue("SMAstralClaws", 0);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		
		if(!ordenHaupt.isSelected()){
			ordenHaupt.setSelected(0, true);
		}
		
		    setInformationVectorValue("SMUltramarines", 0);
			setInformationVectorValue("SMWhiteScars", 0);
			setInformationVectorValue("SMImperialFists", 0);
			setInformationVectorValue("SMBlackTemplars", 0);
			setInformationVectorValue("SMIronHands", 0);
			setInformationVectorValue("SMSalamanders", 0);
			setInformationVectorValue("SMRavenGuard", 0);
			setInformationVectorValue("SMRedScorpions", 0);
			setInformationVectorValue("SMCarcharodons", 0);
			setInformationVectorValue("SMExorcists", 0);
			setInformationVectorValue("SMMantisWarriors", 0);
			setInformationVectorValue("SMRedScorpions", 0);
			setInformationVectorValue("SMExecutioners", 0);
			setInformationVectorValue("SMRedHunters", 0);
			setInformationVectorValue("SMStarPhantoms", 0);
			setInformationVectorValue("SMMinotaurus", 0);
			setInformationVectorValue("SMNovamarines", 0);
			setInformationVectorValue("SMFireHawks", 0);
			setInformationVectorValue("SMAstralClaws", 0);
			
			if(ordenHaupt.isSelected("Ultramarines") || 
					ordenHaupt.isSelected("[FW] Fire Angels")|| 
					ordenHaupt.isSelected("[FW] Howling Griffons") || 
					ordenHaupt.isSelected("[FW] Marines Errant") || 
					ordenHaupt.isSelected("[FW] Angels Revenant")){
				setInformationVectorValue("SMUltramarines", 1);
			}else if(ordenHaupt.isSelected("White Scars")){
				setInformationVectorValue("SMWhiteScars", 1);
			}else if(ordenHaupt.isSelected("Imperial Fists")){
				setInformationVectorValue("SMImperialFists", 1);
			}else if(ordenHaupt.isSelected("Black Templars")){
				setInformationVectorValue("SMBlackTemplars", 1);
			}else if(ordenHaupt.isSelected("Iron Hands") || 
					ordenHaupt.isSelected("[FW] Sons of Medusa")){
				setInformationVectorValue("SMIronHands", 1);
			}else if(ordenHaupt.isSelected("Salamanders")){
				setInformationVectorValue("SMSalamanders", 1);
			}else if(ordenHaupt.isSelected("Raven Guard") || 
					ordenHaupt.isSelected("[FW] Raptors")){
				setInformationVectorValue("SMRavenGuard", 1);
			}else if(ordenHaupt.isSelected("[FW] Red Scorpions")){
				setInformationVectorValue("SMRedScorpions", 1);
			}else if(ordenHaupt.isSelected("[FW] Carcharodons")){
				setInformationVectorValue("SMCarcharodons", 1);
			}else if(ordenHaupt.isSelected("[FW] Exorcists")){
				setInformationVectorValue("SMExorcists", 1);
			}else if(ordenHaupt.isSelected("[FW] Mantis Warriors")){
				setInformationVectorValue("SMMantisWarriors", 1);
			}else if(ordenHaupt.isSelected("[FW] Red Scorpions")){
				setInformationVectorValue("SMRedScorpions", 1);
			}else if(ordenHaupt.isSelected("[FW] Executioners")){
				setInformationVectorValue("SMExecutioners", 1);
			}else if(ordenHaupt.isSelected("[FW] Red Hunters")){
				setInformationVectorValue("SMRedHunters", 1);
			}else if(ordenHaupt.isSelected("[FW] Star Phantoms")){
				setInformationVectorValue("SMStarPhantoms", 1);
			}else if(ordenHaupt.isSelected("[FW] Minotaurus")){
				setInformationVectorValue("SMMinotaurus", 1);
			}else if(ordenHaupt.isSelected("[FW] Novamarines")){
				setInformationVectorValue("SMNovamarines", 1);
			}else if(ordenHaupt.isSelected("[FW] Fire Hawks")){
				setInformationVectorValue("SMFireHawks", 1);
			}else if(ordenHaupt.isSelected("[FW] Astral Claws")){
				setInformationVectorValue("SMAstralClaws", 1);
			}
			
			if(orden!=ordenHaupt.getSelectedIndex()){
				orden=ordenHaupt.getSelectedIndex();
				RefreshListener.fireRefresh();
			}
		}
	

}
