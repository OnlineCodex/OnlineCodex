package oc.wh40k.units.ch;


import oc.AnzahlPanel;
import oc.Eintrag;

public class CHDarkDisciples extends Eintrag {

	private final AnzahlPanel squad;

    public CHDarkDisciples() {
        name = "Dark Disciples";
        grundkosten = 0;
        power = 1;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Dark Disciples", 2, 2, getPts("Dark Disciples"), "Dark Disciples");
        add(squad);

        seperator();

        setInformationVectorValue("Dark Disciples", getCountFromInformationVector("Dark Disciples") + 1);

        seperator(5);

        complete();
    }

    @Override
    public void refreshen() {

    	eintragsCNT = 0;

    	if(getCountFromInformationVector("Dark Disciples") > getCountFromInformationVector("Dark Apostle")) {
    		setFehlermeldung("\n" + getCountFromInformationVector("Dark Apostle") + " Dark Apostle");
    	} else {
    		setFehlermeldung("");
    	}
    }

    @Override
    public void deleteYourself() {
    	setInformationVectorValue("Dark Disciples", getCountFromInformationVector("Dark Disciples") - 1);
    }

}
