package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CHDeathshroudTerminators extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def, swords, bolter;
	OptionsEinzelUpgrade plasmapistole,sorcerer;
	OptionsUpgradeGruppe ikone;
	OptionsUpgradeGruppe sor;
	OptionsZaehlerGruppe o7;
	OptionsEinzelUpgrade stave;
	 
	public CHDeathshroudTerminators() {
		//name = "Thousand Sons\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Deathshroud Terminators", 3, 6, getPts("Deathshroud Terminators"));
		add(squad);
		
		seperator();
		
		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));	
		
		ogE.addElement(new OptionsGruppeEintrag("Manreaper", getPts("Manreaper")));
		add(swords = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		ogE.addElement(new OptionsGruppeEintrag("Plaguespurt gauntlet", getPts("Plaguespurt gauntlet")));
		add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
				
		seperator();
		
		add(sorcerer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deathshroud Champion", getPts("Deathshroud Champion")));
		sorcerer.setSelected(true);
		add(stave = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Manreaper", getPts("Manreaper")));
		ogE.addElement(new OptionsGruppeEintrag("Plaguespurt gauntlet", getPts("Plaguespurt gauntlet")));
		ogE.addElement(new OptionsGruppeEintrag("2 Plaguespurt gauntlet", getPts("Plaguespurt gauntlet")*2));
		add(sor = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		sor.setSelected(0, true);
			
		complete();
	}

	@Override
	public void refreshen() {
		
		swords.setMaxAnzahl(squad.getModelle()-1);
		swords.setAnzahl(0, squad.getModelle()-1);
		
		bolter.setMaxAnzahl(squad.getModelle()-1);
		bolter.setAnzahl(0, squad.getModelle()-1);
		
		sorcerer.setSelected(true);
		if(!stave.isSelected())stave.setSelected(true);
                
        power = 13 +
				((squad.getModelle()==10)?11:0);
	}
}
