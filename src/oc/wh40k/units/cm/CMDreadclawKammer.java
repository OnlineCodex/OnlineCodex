package oc.wh40k.units.cm;

import oc.OptionsSeperator;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CMDreadclawKammer extends RuestkammerVater {

	RuestkammerStarter auserkorene;
	RuestkammerStarter besessene;
	RuestkammerStarter termis;
	RuestkammerStarter khornies;
	RuestkammerStarter noise;
	RuestkammerStarter seuchis;
	RuestkammerStarter sons;
	RuestkammerStarter csm;
	RuestkammerStarter cybot;

	public CMDreadclawKammer() {
                name = "Dreadclaw";
                grundkosten = 85;
	}

	public void initButtons(boolean... defaults) {
				
				add(new OptionsSeperator(10));
		
                add(ico = new oc.Picture("oc/wh40k/images/Dreadclaw.gif"));

                auserkorene = new RuestkammerStarter(ID, randAbstand, cnt, "CMDreadClawTalonAuserkoreneKammer", "Auserkorene",1);
                auserkorene.initKammer();
        		add(auserkorene);
        		//auserkorene.setButtonText("Auserkorene");
        		
        		besessene = new RuestkammerStarter(ID, randAbstand, cnt, "CMDreadClawTalonBesesseneKammer", "Besessene",1);
        		besessene.initKammer();
        		add(besessene);
        		besessene.setButtonText("Besessene");
        		
        		termis = new RuestkammerStarter(ID, randAbstand, cnt, "CMDreadclawTalonChaosterminatorenKammer", "Chaosterminatoren",1);
        		termis.initKammer();
        		add(termis);
        		termis.setButtonText("Chaosterminatoren");
                
        		khornies = new RuestkammerStarter(ID, randAbstand, cnt, "CMDreadclawTalonKhorneBerserkerKammer", "Khorne Berserker",1);
        		khornies.initKammer();
        		add(khornies);
        		khornies.setButtonText("Khorne Berserker");
        		
        		noise = new RuestkammerStarter(ID, randAbstand, cnt, "CMDreadclawTalonNoiseMarinesKammer", "Noise Marines",1);
        		noise.initKammer();
        		add(noise);
        		noise.setButtonText("Noise Marines");
        		
        		seuchis = new RuestkammerStarter(ID, randAbstand, cnt, "CMDreadclawTalonSeuchenmarinesKammer", "Seuchenmarines",1);
        		seuchis.initKammer();
        		add(seuchis);
        		seuchis.setButtonText("Seuchenmarines");
        		
        		sons = new RuestkammerStarter(ID, randAbstand, cnt, "CMDreadclawTalonThousandSonsKammer", "Thousand Sons",1);
        		sons.initKammer();
        		add(sons);
        		sons.setButtonText("Thousand Sons");
        		
        		csm = new RuestkammerStarter(ID, randAbstand, cnt, "CMDreadclawTalonChaosSpaceMarinesKammer", "Chaos Space Marines",1);
        		csm.initKammer();
        		add(csm);
        		csm.setButtonText("Chaos Space Marines");
        		
        		cybot = new RuestkammerStarter(ID, randAbstand, cnt, "CMDreadClawTalonChaosCybotKammer", "Chaos Cybot",1);
        		cybot.initKammer();
        		add(cybot);
        		cybot.setButtonText("Höllenschlächter");
        		

                sizeSetzen();
	}

	@Override
	public void refreshen() {
		auserkorene.setAktiv(!besessene.isSelected() && !termis.isSelected() && !khornies.isSelected() && !noise.isSelected() && !seuchis.isSelected() && !sons.isSelected() && !csm.isSelected() && !cybot.isSelected());
		besessene.setAktiv(!auserkorene.isSelected() && !termis.isSelected() && !khornies.isSelected() && !noise.isSelected() && !seuchis.isSelected() && !sons.isSelected() && !csm.isSelected() && !cybot.isSelected());
		termis.setAktiv(!besessene.isSelected() && !auserkorene.isSelected() && !khornies.isSelected() && !noise.isSelected() && !seuchis.isSelected() && !sons.isSelected() && !csm.isSelected() && !cybot.isSelected());
		khornies.setAktiv(!besessene.isSelected() && !termis.isSelected() && !auserkorene.isSelected() && !noise.isSelected() && !seuchis.isSelected() && !sons.isSelected() && !csm.isSelected() && !cybot.isSelected());
		noise.setAktiv(!besessene.isSelected() && !termis.isSelected() && !khornies.isSelected() && !auserkorene.isSelected() && !seuchis.isSelected() && !sons.isSelected() && !csm.isSelected() && !cybot.isSelected());
		seuchis.setAktiv(!besessene.isSelected() && !termis.isSelected() && !khornies.isSelected() && !noise.isSelected() && !auserkorene.isSelected() && !sons.isSelected() && !csm.isSelected() && !cybot.isSelected());
		sons.setAktiv(!besessene.isSelected() && !termis.isSelected() && !khornies.isSelected() && !noise.isSelected() && !seuchis.isSelected() && !auserkorene.isSelected() && !csm.isSelected() && !cybot.isSelected());
		csm.setAktiv(!besessene.isSelected() && !termis.isSelected() && !khornies.isSelected() && !noise.isSelected() && !seuchis.isSelected() && !sons.isSelected() && !auserkorene.isSelected() && !cybot.isSelected());
		cybot.setAktiv(!besessene.isSelected() && !termis.isSelected() && !khornies.isSelected() && !noise.isSelected() && !seuchis.isSelected() && !sons.isSelected() && !csm.isSelected() && !auserkorene.isSelected());
	}

}
