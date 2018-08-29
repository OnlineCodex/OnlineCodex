package oc.wh40k.units.ia;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IAOrdoHereticusInquisitor extends Eintrag {

	OptionsEinzelUpgrade bp, cs;
    OptionsZaehlerGruppe o1;
    OptionsEinzelUpgrade psi;
    RuestkammerStarter relikte;
    
	public IAOrdoHereticusInquisitor() {
            name = "Inquisitor des Ordo Hereticus";
            grundkosten = 25;

            add(ico = new oc.Picture("oc/wh40k/images/GKInquisitordesOrdoHereticus.jpg"));
            
            seperator();
    		
    		add(bp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole", 0));
    		add(cs = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kettenschwert", 0));
    		bp.setSelected(true);
    		cs.setSelected(true);
    		
    		seperator();

            ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
            ogE.addElement(new OptionsGruppeEintrag("Infernopistole", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
            ogE.addElement(new OptionsGruppeEintrag("Condemnor-Bolter", 15));
            ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 20));
            ogE.addElement(new OptionsGruppeEintrag("Nullstab", 25));
            ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

            seperator();

            add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Servo-Schädel", 3, 3));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Servorüstung", 3));
            ogE.addElement(new OptionsGruppeEintrag("Psiokular", 25));
            add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 100));

            seperator();

            add(psi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterschaftsgrad 1", 30));

            seperator();
            
            relikte = new RuestkammerStarter(ID, randAbstand, cnt, "IARelikte", "");
    		relikte.initKammer(false, true, false, false, false);
    		relikte.setButtonText(BuildaHQ.translate("Relikte"));
    		add(relikte);
    		relikte.setAbwaehlbar(false);
    		
            complete();
	}

	@Override
	public void refreshen() {

            o1.setAktiv("Psischwert", psi.isSelected());

            o1.setMaxAnzahl(2-(cs.isSelected()?1:0)-(bp.isSelected()?1:0));
            
            boolean legal=(o1.getAnzahl()+(cs.isSelected()?1:0)+(bp.isSelected()?1:0))==2;
            o1.setLegal(legal);
            bp.setLegal(legal);
            cs.setLegal(legal);
            
            if(((IARelikte)relikte.getKammer()).uniqueError){
    			setFehlermeldung("Artefakt doppelt!");
    		} else{
    			setFehlermeldung("");
    		}
            
        }

	@Override
	public void deleteYourself() {
            super.deleteYourself();
	}

}
