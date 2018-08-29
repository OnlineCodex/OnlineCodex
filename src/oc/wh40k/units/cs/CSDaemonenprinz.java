package oc.wh40k.units.cs;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CSDaemonenprinz extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	OptionsUpgradeGruppe mal;
	OptionsUpgradeGruppe psi;
	RuestkammerStarter chaosBelohnungen;
	RuestkammerStarter waffenUndArtefakte;

	public CSDaemonenprinz() {
		name = "Dämonenprinz";
		grundkosten = 145;

		add(ico = new oc.Picture("oc/wh40k/images/DaemonPrince.gif"));
		
		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flügel", 40));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Servorüstung", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Dämon des Khorne", 15));
		ogE.addElement(new OptionsGruppeEintrag("Dämon des Tzeentch", 15));
		ogE.addElement(new OptionsGruppeEintrag("Dämon des Nurgle", 15));
		ogE.addElement(new OptionsGruppeEintrag("Dämon des Slaanesh", 10));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 1", 25));
		ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 2", 50));
		ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 3", 75));
		add(psi = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		chaosBelohnungen = new RuestkammerStarter(ID, randAbstand, cnt, "CSChaosbelohnungen", "");
		chaosBelohnungen.initKammer(mal.isSelected("Dämon des Khorne"), mal.isSelected("Dämon des Tzeentch"), mal.isSelected("Dämon des Nurgle"), mal.isSelected("Dämon des Slaanesh"), false,true);
		chaosBelohnungen.setButtonText(BuildaHQ.translate("Gaben des Chaos"));
		add(chaosBelohnungen);
		
		seperator();
		
		waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "CSWaffenUndArtefakte", "");
		// General, Hexer, Warpschmied, Apostel, Daemon 
		waffenUndArtefakte.initKammer(false, false, false, false, true);
		waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen & Artefakte"));
		add(waffenUndArtefakte);
		waffenUndArtefakte.setAbwaehlbar(false);
		
		complete();
	}

	@Override
	public void refreshen() {
        if(mal.getAnzahl() < 1) {
            mal.setLegal(false);
            setFehlermeldung("Wähle einen Gott");
        } else {
            mal.setLegal(true);
            setFehlermeldung("");
        }
        
        if (mal.isSelected("Dämon des Khorne")) {
			psi.setAktiv(false);
		} else {
			psi.setAktiv(true);
		}
        
        waffenUndArtefakte.getKammer().switchEntry("Axt der blinden Wut", mal.isSelected("Dämon des Khorne"));
        //waffenUndArtefakte.getKammer().switchEntry("Schriftrollen des Magnus", mal.isSelected("Dämon des Tzeentch"));
        
        if(((CSWaffenUndArtefakte)waffenUndArtefakte.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}
    }

}
