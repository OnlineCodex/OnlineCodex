package oc.wh40k.units.ec;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ECCorsairBalestrikeBand extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1, o1x;
    OptionsEinzelUpgrade jetpacks;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkFalcon;
    RuestkammerStarter rkVenom;
    
    OptionsEinzelUpgrade armour;
    OptionsEinzelUpgrade drugs;
    OptionsEinzelUpgrade rage;

    public ECCorsairBalestrikeBand() {
        name = "Corsair Balestrike Band\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Corsairs", 5, 10, 10);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairSquad.jpg"));
        
        seperator();

        add(jetpacks = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair Jet Packs", 5));
        
        seperator();
        
        add(armour = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy mesh armour", 5));
        
        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lasblaster", 0));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Dissonance cannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Eldar missile launcher", 25));
		ogE.addElement(new OptionsGruppeEintrag("Dark lance", 15));
		ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Haywire Grenades", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tanglefield Grenades", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Void hardened armour", 10));

		seperator();
		
		add(drugs = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combat drugs", 15));
		add(rage = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rage SR", 0));
        
        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairFelarchKammer", "Upgrade to Felarch");
		rkBoss.initKammer(true);
		add(rkBoss);
        
        seperator();
        
		rkVenom = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairVenomKammer", "Corsair Venom");
		rkVenom.initKammer();
		add(rkVenom);

		rkFalcon = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairFalconKammer", "Corsair Falcon");
		rkFalcon.initKammer();
		add(rkFalcon);
        
        complete();
    }

    @Override
    public void refreshen() {
    	
    	armour.setModelle(squad.getModelle());
    	jetpacks.setModelle(squad.getModelle());
    	o1x.setMaxAnzahl(squad.getModelle()-o1.getAnzahl()-(rkBoss.isSelected()?1:0));
    	o1x.setAnzahl(0,squad.getModelle()-o1.getAnzahl()-(rkBoss.isSelected()?1:0));
        o1.setMaxAnzahl( squad.getModelle()-(rkBoss.isSelected()?1:0));
        
        drugs.setAktiv(getCountFromInformationVector("ECPrinceTrait")==0);
        rage.setAktiv(getCountFromInformationVector("ECPrinceTrait")==3);
        
        rkFalcon.setAktiv(squad.getModelle() > 5 && !rkVenom.isSelected() && !jetpacks.isSelected());
        rkVenom.setAktiv(squad.getModelle() <= 5 && !rkFalcon.isSelected() && !jetpacks.isSelected());
    }
    
}
