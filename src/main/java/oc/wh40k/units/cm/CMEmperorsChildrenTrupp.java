package oc.wh40k.units.cm;

import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CMEmperorsChildrenTrupp extends RuestkammerVater {

        RuestkammerStarter rkCybot;
	RuestkammerStarter rkTermis;
	RuestkammerStarter rkAuserkorene;
	RuestkammerStarter rkMarines;
	RuestkammerStarter rkNoiseMarines;
	RuestkammerStarter rkBiker;
	RuestkammerStarter rkPredator;
	RuestkammerStarter rkHavocs;

	public CMEmperorsChildrenTrupp() {
            grundkosten = 0;
        }

        @Override
        public void initButtons(boolean... b) {
            add(ico = new oc.Picture("oc/wh40k/images/ThousandSons.gif"));
            
            seperator();

            rkCybot = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosCybotKammer", "Chaos Cybot", 1);
            rkCybot.initKammer(true);
            rkCybot.setButtonText("Chaos Cybot");
            add(rkCybot);

            seperator(15);

            rkTermis = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosterminatorenKammer", "Chaosterminatoren", 1);
            rkTermis.initKammer(false, true);
            rkTermis.setButtonText("Chaosterminatoren");
            add(rkTermis);

            seperator();

            rkAuserkorene = new RuestkammerStarter(ID, randAbstand, cnt, "CMAuserkoreneKammer", "Auserkorene Chaos Space Marines", 1);
            rkAuserkorene.initKammer(true);
            rkAuserkorene.setButtonText("Auserkorene Chaos Space Marines");
            add(rkAuserkorene);

            seperator();

            rkMarines = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosSpaceMarinesKammer", "Chaos Space Marines", 1);
            rkMarines.initKammer(true);
            rkMarines.setButtonText("Chaos Space Marines");
            add(rkMarines);

            seperator();

            rkNoiseMarines = new RuestkammerStarter(ID, randAbstand, cnt, "CMNoiseMarinesKammer", "Noise Marines", 1);
            rkNoiseMarines.initKammer();
            rkNoiseMarines.setButtonText("Noise Marines");
            add(rkNoiseMarines);

            seperator();

            rkBiker = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosSpaceMarinesaufBikesKammer", "Chaos Space Marines auf Bikes", 1);
            rkBiker.initKammer(true);
            rkBiker.setButtonText("Chaos Space Marines auf Bikes");
            add(rkBiker);

            seperator();

            rkPredator = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosPredatorKammer", "Chaos Predator", 1);
            rkPredator.initKammer(true);
            rkPredator.setButtonText("Chaos Predator");
            add(rkPredator);

            seperator();

            rkHavocs = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosSpaceMarinesHavocsKammer", "Chaos Space Marines Havocs", 1);
            rkHavocs.initKammer(true);
            rkHavocs.setButtonText("Chaos Space Marines Havocs");
            add(rkHavocs);

            sizeSetzen();
        }

	@Override
	public void refreshen() {
            rkTermis.getPanel().setLocation(rkTermis.getPanel().getX(), rkCybot.getPanel().getHeight() + rkCybot.getPanel().getY() + 10);
            rkAuserkorene.getPanel().setLocation(rkAuserkorene.getPanel().getX(), rkTermis.getPanel().getHeight() + rkTermis.getPanel().getY() + 10);
            rkMarines.getPanel().setLocation(rkMarines.getPanel().getX(), rkAuserkorene.getPanel().getHeight() + rkAuserkorene.getPanel().getY() + 10);
            rkNoiseMarines.getPanel().setLocation(rkNoiseMarines.getPanel().getX(), rkMarines.getPanel().getHeight() + rkMarines.getPanel().getY() + 10);
            rkBiker.getPanel().setLocation(rkBiker.getPanel().getX(), rkNoiseMarines.getPanel().getHeight() + rkNoiseMarines.getPanel().getY() + 10);
            rkPredator.getPanel().setLocation(rkPredator.getPanel().getX(), rkBiker.getPanel().getHeight() + rkBiker.getPanel().getY() + 10);
            rkHavocs.getPanel().setLocation(rkHavocs.getPanel().getX(), rkPredator.getPanel().getHeight() + rkPredator.getPanel().getY() + 10);

            rkCybot.setLegal(rkCybot.isSelected() ||rkTermis.isSelected() || rkAuserkorene.isSelected() || rkMarines.isSelected() || rkNoiseMarines.isSelected() || rkBiker.isSelected() || rkPredator.isSelected() || rkHavocs.isSelected());
            rkTermis.setLegal(rkCybot.isSelected() ||rkTermis.isSelected() || rkAuserkorene.isSelected() || rkMarines.isSelected() || rkNoiseMarines.isSelected() || rkBiker.isSelected() || rkPredator.isSelected() || rkHavocs.isSelected());
            rkAuserkorene.setLegal(rkCybot.isSelected() ||rkTermis.isSelected() || rkAuserkorene.isSelected() || rkMarines.isSelected() || rkNoiseMarines.isSelected() || rkBiker.isSelected() || rkPredator.isSelected() || rkHavocs.isSelected());
            rkMarines.setLegal(rkCybot.isSelected() ||rkTermis.isSelected() || rkAuserkorene.isSelected() || rkMarines.isSelected() || rkNoiseMarines.isSelected() || rkBiker.isSelected() || rkPredator.isSelected() || rkHavocs.isSelected());
            rkNoiseMarines.setLegal(rkCybot.isSelected() ||rkTermis.isSelected() || rkAuserkorene.isSelected() || rkMarines.isSelected() || rkNoiseMarines.isSelected() || rkBiker.isSelected() || rkPredator.isSelected() || rkHavocs.isSelected());
            rkBiker.setLegal(rkCybot.isSelected() ||rkTermis.isSelected() || rkAuserkorene.isSelected() || rkMarines.isSelected() || rkNoiseMarines.isSelected() || rkBiker.isSelected() || rkPredator.isSelected() || rkHavocs.isSelected());
            rkPredator.setLegal(rkCybot.isSelected() ||rkTermis.isSelected() || rkAuserkorene.isSelected() || rkMarines.isSelected() || rkNoiseMarines.isSelected() || rkBiker.isSelected() || rkPredator.isSelected() || rkHavocs.isSelected());
            rkHavocs.setLegal(rkCybot.isSelected() ||rkTermis.isSelected() || rkAuserkorene.isSelected() || rkMarines.isSelected() || rkNoiseMarines.isSelected() || rkBiker.isSelected() || rkPredator.isSelected() || rkHavocs.isSelected());

            rkCybot.setAktiv(!rkTermis.isSelected() && !rkAuserkorene.isSelected() && !rkMarines.isSelected() && !rkNoiseMarines.isSelected() && !rkBiker.isSelected() && !rkPredator.isSelected() && !rkHavocs.isSelected());
            rkTermis.setAktiv(!rkCybot.isSelected() && !rkAuserkorene.isSelected() && !rkMarines.isSelected() && !rkNoiseMarines.isSelected() && !rkBiker.isSelected() && !rkPredator.isSelected() && !rkHavocs.isSelected());
            rkAuserkorene.setAktiv(!rkCybot.isSelected() && !rkTermis.isSelected() && !rkMarines.isSelected() && !rkNoiseMarines.isSelected() && !rkBiker.isSelected() && !rkPredator.isSelected() && !rkHavocs.isSelected());
            rkMarines.setAktiv(!rkCybot.isSelected() && !rkTermis.isSelected() && !rkAuserkorene.isSelected() && !rkNoiseMarines.isSelected() && !rkBiker.isSelected() && !rkPredator.isSelected() && !rkHavocs.isSelected());
            rkNoiseMarines.setAktiv(!rkCybot.isSelected() && !rkTermis.isSelected() && !rkAuserkorene.isSelected() && !rkMarines.isSelected() && !rkBiker.isSelected() && !rkPredator.isSelected() && !rkHavocs.isSelected());
            rkBiker.setAktiv(!rkCybot.isSelected() && !rkTermis.isSelected() && !rkAuserkorene.isSelected() && !rkMarines.isSelected() && !rkNoiseMarines.isSelected() && !rkPredator.isSelected() && !rkHavocs.isSelected());
            rkPredator.setAktiv(!rkCybot.isSelected() && !rkTermis.isSelected() && !rkAuserkorene.isSelected() && !rkMarines.isSelected() && !rkNoiseMarines.isSelected() && !rkBiker.isSelected() && !rkHavocs.isSelected());
            rkHavocs.setAktiv(!rkCybot.isSelected() && !rkTermis.isSelected() && !rkAuserkorene.isSelected() && !rkMarines.isSelected() && !rkNoiseMarines.isSelected() && !rkBiker.isSelected() && !rkPredator.isSelected());
        }


}
