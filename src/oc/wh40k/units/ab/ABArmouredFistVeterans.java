package oc.wh40k.units.ab;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ABArmouredFistVeterans extends Eintrag {

	AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2hflamer;
    OptionsZaehlerGruppe lasgun;
    OptionsZaehlerGruppe laspistol;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade oe3;
    OptionsUpgradeGruppe doctrine;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkChimaere;
    RuestkammerStarter rkCentaur;

    public ABArmouredFistVeterans() {
        name = "Armoured Fist Veterans";
        grundkosten = 40;
        
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Veterans", 5, 10, 6);
		squad.setGrundkosten(5);
		add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ABArmouredFistSquad.jpg"));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Grenadiers", 30));
        ogE.addElement(new OptionsGruppeEintrag("Forward Sentries", 30));
        ogE.addElement(new OptionsGruppeEintrag("Demolitions", 30));
        add(doctrine = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
        add(lasgun = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,9));

        ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
        add(laspistol = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,9));
        
        seperator();
        
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Voxcaster", 5));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mortar", 5));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 15));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,2));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
        add(o2hflamer = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 10));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ABVeteransSergeant", "Veteran Sergeant");
        rkBoss.initKammer();
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        seperator();

        rkChimaere = new RuestkammerStarter(ID, randAbstand, cnt, "ABChimeraKammer", "Chimera Transport");
        rkChimaere.initKammer();
        add(rkChimaere);
        
        rkCentaur = new RuestkammerStarter(ID, randAbstand, cnt, "ABCentaurKammer", "Centaur Carrier");
        rkCentaur.initKammer();
        add(rkCentaur);

        complete();
    }

    @Override
    public void refreshen() {
    	
    	if(squad.getModelle()==5){
			rkChimaere.setAbwaehlbar(true);
			rkChimaere.setAktiv(false);
	    	rkCentaur.setAktiv(true);
	    	rkCentaur.setAbwaehlbar(false);
    	} else{
    		rkCentaur.setAbwaehlbar(true);
	    	rkCentaur.setAktiv(false);
			rkChimaere.setAktiv(true);
			rkChimaere.setAbwaehlbar(false);
    	}
	        
    	rkChimaere.getPanel().setLocation(
	            (int) rkChimaere.getPanel().getLocation().getX(),
	            (int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height
	        );
    	
    	rkCentaur.getPanel().setLocation(
	            (int) rkCentaur.getPanel().getLocation().getX(),
	            (int) rkChimaere.getPanel().getLocation().getY() + rkChimaere.getPanel().getSize().height
	        );
        
        lasgun.setMaxAnzahl(squad.getModelle()-1-(o1.isSelected()?2:0)-o2.getAnzahl()-o2hflamer.getAnzahl()-laspistol.getAnzahl());
        lasgun.setAnzahl(0, lasgun.getMaxAnzahl());
        
        laspistol.setMaxAnzahl(squad.getModelle()-1-(o1.isSelected()?2:0)-o2.getAnzahl()-o2hflamer.getAnzahl());
        
        o1.setAktiv(lasgun.getMaxAnzahl()>1 || o1.isSelected());
        o2.setAktiv(lasgun.getMaxAnzahl()>0 || o2.isSelected());
        o2hflamer.setAktiv(lasgun.getMaxAnzahl()>0 || o2hflamer.isSelected());
        
        if(lasgun.getMaxAnzahl()>1){
        	o2.setMaxAnzahl(2-o2hflamer.getAnzahl());
        }else if(lasgun.getMaxAnzahl()>0){
        	o2.setMaxAnzahl(1-o2hflamer.getAnzahl());
        }
        
    }
}
