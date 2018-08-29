package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CMEmperorsChildrenKampfverband extends Eintrag {

	RuestkammerStarter rkGeneral;
        RuestkammerStarter rkTrupp1;
	RuestkammerStarter rkTrupp2;
	RuestkammerStarter rkTrupp3;
	RuestkammerStarter rkTrupp4;
	RuestkammerStarter rkTrupp5;
	RuestkammerStarter rkTrupp6;

	public CMEmperorsChildrenKampfverband() {
            name = "Emperor's-Children-Kampfverband";
            grundkosten = 100;

            add(ico = new oc.Picture("oc/wh40k/images/ThousandSons.gif"));
            
            seperator();

            rkGeneral = new RuestkammerStarter(ID, randAbstand, cnt, "CMEmperorsChildrenAnfuehrer", "Anführer");
            rkGeneral.initKammer();
            rkGeneral.setButtonText("Anführer");
            add(rkGeneral);
            
            seperator(15);

            rkTrupp1 = new RuestkammerStarter(ID, randAbstand, cnt, "CMEmperorsChildrenTrupp", "Emperor's Children Trupp");
            rkTrupp1.initKammer();
            rkTrupp1.setButtonText("Emperor's Children Trupp");
            add(rkTrupp1);

            seperator(15);

            rkTrupp2 = new RuestkammerStarter(ID, randAbstand, cnt, "CMEmperorsChildrenTrupp", "Emperor's Children Trupp");
            rkTrupp2.initKammer();
            rkTrupp2.setButtonText("Emperor's Children Trupp");
            add(rkTrupp2);

            seperator();

            rkTrupp3 = new RuestkammerStarter(ID, randAbstand, cnt, "CMEmperorsChildrenTrupp", "Emperor's Children Trupp");
            rkTrupp3.initKammer();
            rkTrupp3.setButtonText("Emperor's Children Trupp");
            add(rkTrupp3);

            seperator();

            rkTrupp4 = new RuestkammerStarter(ID, randAbstand, cnt, "CMEmperorsChildrenTrupp", "Emperor's Children Trupp");
            rkTrupp4.initKammer();
            rkTrupp4.setButtonText("Emperor's Children Trupp");
            add(rkTrupp4);

            seperator();

            rkTrupp5 = new RuestkammerStarter(ID, randAbstand, cnt, "CMEmperorsChildrenTrupp", "Emperor's Children Trupp");
            rkTrupp5.initKammer();
            rkTrupp5.setButtonText("Emperor's Children Trupp");
            add(rkTrupp5);

            seperator();

            rkTrupp6 = new RuestkammerStarter(ID, randAbstand, cnt, "CMEmperorsChildrenTrupp", "Emperor's Children Trupp");
            rkTrupp6.initKammer();
            rkTrupp6.setButtonText("Emperor's Children Trupp");
            add(rkTrupp6);

            complete();
	}

	@Override
	public void refreshen() {
            rkGeneral.setAbwaehlbar(false);

            rkTrupp1.getPanel().setLocation(rkTrupp1.getPanel().getX(), rkGeneral.getPanel().getHeight() + rkGeneral.getPanel().getY() + 15);
            rkTrupp2.getPanel().setLocation(rkTrupp2.getPanel().getX(), rkTrupp1.getPanel().getHeight() + rkTrupp1.getPanel().getY() + 15);
            rkTrupp3.getPanel().setLocation(rkTrupp3.getPanel().getX(), rkTrupp2.getPanel().getHeight() + rkTrupp2.getPanel().getY() + 10);
            rkTrupp4.getPanel().setLocation(rkTrupp4.getPanel().getX(), rkTrupp3.getPanel().getHeight() + rkTrupp3.getPanel().getY() + 10);
            rkTrupp5.getPanel().setLocation(rkTrupp5.getPanel().getX(), rkTrupp4.getPanel().getHeight() + rkTrupp4.getPanel().getY() + 10);
            rkTrupp6.getPanel().setLocation(rkTrupp6.getPanel().getX(), rkTrupp5.getPanel().getHeight() + rkTrupp5.getPanel().getY() + 10);
        }

}
