package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CMGeisselSturmverband extends Eintrag {

	RuestkammerStarter rkBefehlsgeissel;
	RuestkammerStarter rkGeissel1;
	RuestkammerStarter rkGeissel2;
	RuestkammerStarter rkGeissel3;
	RuestkammerStarter rkGeissel4;
	RuestkammerStarter rkGeissel5;

	public CMGeisselSturmverband() {
            name = "Geissel-Sturmverband";
            grundkosten = 100;

            add(ico = new oc.Picture("oc/wh40k/images/ThousandSons.gif"));
            
            seperator();

            rkBefehlsgeissel = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosGeisselKammer", "Befehls-Geiﬂel");
            rkBefehlsgeissel.initKammer(true);
            rkBefehlsgeissel.setButtonText("Befehls-Geiﬂel");
            add(rkBefehlsgeissel);

            seperator(15);

            rkGeissel1 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosGeisselKammer", "Chaos-Geiﬂel");
            rkGeissel1.initKammer(false);
            rkGeissel1.setButtonText("Chaos-Geiﬂel");
            add(rkGeissel1);

            seperator();

            rkGeissel2 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosGeisselKammer", "Chaos-Geiﬂel");
            rkGeissel2.initKammer(false);
            rkGeissel2.setButtonText("Chaos-Geiﬂel");
            add(rkGeissel2);

            seperator();

            rkGeissel3 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosGeisselKammer", "Chaos-Geiﬂel");
            rkGeissel3.initKammer(false);
            rkGeissel3.setButtonText("Chaos-Geiﬂel");
            add(rkGeissel3);

            seperator();

            rkGeissel4 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosGeisselKammer", "Chaos-Geiﬂel");
            rkGeissel4.initKammer(false);
            rkGeissel4.setButtonText("Chaos-Geiﬂel");
            add(rkGeissel4);

            seperator();

            rkGeissel5 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosGeisselKammer", "Chaos-Geiﬂel");
            rkGeissel5.initKammer(false);
            rkGeissel5.setButtonText("Chaos-Geiﬂel");
            add(rkGeissel5);

            complete();
	}

	@Override
	public void refreshen() {
            rkBefehlsgeissel.setAbwaehlbar(false);
            rkGeissel1.setAbwaehlbar(false);
            rkGeissel2.setAbwaehlbar(false);
            rkGeissel3.setAktiv(rkGeissel1.isSelected() && rkGeissel2.isSelected());
            rkGeissel4.setAktiv(rkGeissel3.isSelected());
            rkGeissel5.setAktiv(rkGeissel4.isSelected());

            rkGeissel1.getPanel().setLocation((int) rkGeissel1.getPanel().getLocation().getX(), (int) (rkBefehlsgeissel.getPanel().getLocation().getY() + rkBefehlsgeissel.getPanel().getHeight()));
            rkGeissel2.getPanel().setLocation((int) rkGeissel2.getPanel().getLocation().getX(), (int) (rkGeissel1.getPanel().getLocation().getY() + rkGeissel1.getPanel().getHeight()));
            rkGeissel3.getPanel().setLocation((int) rkGeissel3.getPanel().getLocation().getX(), (int) (rkGeissel2.getPanel().getLocation().getY() + rkGeissel2.getPanel().getHeight()));
            rkGeissel4.getPanel().setLocation((int) rkGeissel4.getPanel().getLocation().getX(), (int) (rkGeissel3.getPanel().getLocation().getY() + rkGeissel3.getPanel().getHeight()));
            rkGeissel5.getPanel().setLocation((int) rkGeissel5.getPanel().getLocation().getX(), (int) (rkGeissel4.getPanel().getLocation().getY() + rkGeissel4.getPanel().getHeight()));
        }

}
