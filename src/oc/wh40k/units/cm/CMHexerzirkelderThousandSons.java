package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CMHexerzirkelderThousandSons extends Eintrag {

	RuestkammerStarter rkHexer;
	RuestkammerStarter rkTermi1;
	RuestkammerStarter rkTermi2;
	RuestkammerStarter rkTermi3;
	RuestkammerStarter rkTermi4;
	RuestkammerStarter rkTermi5;
	RuestkammerStarter rkTermi6;
        OptionsEinzelUpgrade ahriman;
        RuestkammerStarter rkAuserkorene;

	public CMHexerzirkelderThousandSons() {
            name = "Hexerzirkel der Thousand Sons";
            grundkosten = 200;

            add(ico = new oc.Picture("oc/wh40k/images/ThousandSons.gif"));
            
            seperator();

            rkHexer = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaoshexerKammer", "Chaoshexer");
            rkHexer.initKammer(true);
            rkHexer.setButtonText("Chaoshexer");
            add(rkHexer);

            seperator();

            add(ahriman = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ahriman", 250));

            seperator(15);

            rkAuserkorene = new RuestkammerStarter(ID, randAbstand, cnt, "CMAuserkoreneThousandSons", "Auserkorene Thousand Sons");
            rkAuserkorene.initKammer();
            rkAuserkorene.setButtonText("Auserkorene");
            add(rkAuserkorene);

            seperator(15);

            rkTermi1 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosterminatorenKammer", "Chaosterminatoren");
            rkTermi1.initKammer(true);
            rkTermi1.setButtonText("Chaosterminatoren");
            add(rkTermi1);

            seperator();

            rkTermi2 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosterminatorenKammer", "Chaosterminatoren");
            rkTermi2.initKammer(true);
            rkTermi2.setButtonText("Chaosterminatoren");
            add(rkTermi2);

            seperator();

            rkTermi3 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosterminatorenKammer", "Chaosterminatoren");
            rkTermi3.initKammer(true);
            rkTermi3.setButtonText("Chaosterminatoren");
            add(rkTermi3);

            complete();
	}

	@Override
	public void refreshen() {
//            rkHexer.setAktiv(!ahriman.isSelected());
//            ahriman.setAktiv(!rkHexer.isSelected());

            rkHexer.setAbwaehlbar(ahriman.isSelected());
            rkHexer.setAktiv(!ahriman.isSelected());

            rkAuserkorene.setAbwaehlbar(false);

            ahriman.getPanel().setLocation(ahriman.getPanel().getX(), rkHexer.getPanel().getHeight() + rkHexer.getPanel().getY() + 5);
            rkAuserkorene.getPanel().setLocation(rkAuserkorene.getPanel().getX(), ahriman.getPanel().getHeight() + ahriman.getPanel().getY() + 15);
            rkTermi1.getPanel().setLocation(rkTermi1.getPanel().getX(), rkAuserkorene.getPanel().getHeight() + rkAuserkorene.getPanel().getY() + 15);
            rkTermi2.getPanel().setLocation(rkTermi2.getPanel().getX(), rkTermi1.getPanel().getHeight() + rkTermi1.getPanel().getY() + 10);
            rkTermi3.getPanel().setLocation(rkTermi3.getPanel().getX(), rkTermi2.getPanel().getHeight() + rkTermi2.getPanel().getY() + 10);
        }

}
