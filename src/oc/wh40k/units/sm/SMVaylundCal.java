package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMVaylundCal extends Eintrag {

	public SMVaylundCal() {
		name = "Vaylund Cal";
		grundkosten = 225;
                
		addToInformationVector("SMOnlyOneChapterMaster", 1);
		addToInformationVector("SMChapterMaster", 1);
		addToInformationVector("SMHQ", -1);
                                
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Cybot");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Ironclad-Cybot");

		add(ico = new oc.Picture("oc/wh40k/images/SMKorsarroKhan.gif"));
                
		complete();
	}

	@Override
	public void deleteYourself() {
		
                addToInformationVector("SMChapterMaster", -1);
                addToInformationVector("SMOnlyOneChapterMaster", -1);
        		addToInformationVector("SMHQ", -1);
                BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Cybot");
                BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Ironclad-Cybot");
            
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
            setUnikat(true);
            
            if(getCountFromInformationVector("SMChapterMaster") > 1 && getCountFromInformationVector("SMOnlyOneChapterMaster") > 0) {
                setFehlermeldung("nur ein Ordensmeister");
            } else {
                setFehlermeldung("");
            }
            
            
            
        }

}
