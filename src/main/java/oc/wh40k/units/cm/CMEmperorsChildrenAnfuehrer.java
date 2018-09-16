package oc.wh40k.units.cm;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CMEmperorsChildrenAnfuehrer extends RuestkammerVater {

	RuestkammerStarter rkGeneral;
	RuestkammerStarter rkHexer;
        OptionsEinzelUpgrade lucius;

	public CMEmperorsChildrenAnfuehrer() {
            grundkosten = 0;            
	}

        @Override
        public void initButtons(boolean... b) {
            add(ico = new oc.Picture("oc/wh40k/images/ThousandSons.gif"));
            
            seperator();

            rkGeneral = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosgeneralKammer", "Chaosgeneral");
            rkGeneral.initKammer(false, true);
            rkGeneral.setButtonText("Chaosgeneral");
            add(rkGeneral);

            seperator();

            rkHexer = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaoshexerKammer", "Chaoshexer");
            rkHexer.initKammer(false, true);
            rkHexer.setButtonText("Chaoshexer");
            add(rkHexer);

            seperator();

            add(lucius = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lucius der Ewige", 160));

            sizeSetzen();
        }

	@Override
	public void refreshen() {
            rkHexer.setAktiv(!lucius.isSelected() && !rkGeneral.isSelected());
            rkGeneral.setAktiv(!rkHexer.isSelected() && ! lucius.isSelected());
            lucius.setAktiv(!rkHexer.isSelected() && !rkGeneral.isSelected());

            rkHexer.setLegal(rkHexer.isSelected() || rkGeneral.isSelected() || lucius.isSelected());
            rkGeneral.setLegal(rkHexer.isSelected() || rkGeneral.isSelected() || lucius.isSelected());
            lucius.setLegal(rkHexer.isSelected() || rkGeneral.isSelected() || lucius.isSelected());

            rkHexer.getPanel().setLocation(rkHexer.getPanel().getX(), rkGeneral.getPanel().getHeight() + rkGeneral.getPanel().getY() + 5);
            lucius.getPanel().setLocation(lucius.getPanel().getX(), rkHexer.getPanel().getHeight() + rkHexer.getPanel().getY() + 5);
        }


}
