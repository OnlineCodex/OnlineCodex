package oc.wh40k.units.ta;

import static oc.KeyWord.BATTLESUIT;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.COMMANDER;
import static oc.KeyWord.JET_PACK;
import static oc.KeyWord.TAU_EMPIRE;
import static oc.KeyWord.XV86_COLDSTAR;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TACommanderinXV86ColdstarBattlesuit extends Eintrag {

    private final OptionsZaehlerGruppe o5;

    public TACommanderinXV86ColdstarBattlesuit() {
    	super(TAU_EMPIRE, BATTLESUIT, CHARACTER, XV86_COLDSTAR, JET_PACK, COMMANDER);

        name = "Commander in XV86 Coldstar Battlesuit";
        grundkosten = getPts("Commander in XV86 Coldstar Battlesuit");

        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        addWeapons(TAKampfanzugKammer.class, true);

        seperator();

		addWarlordTraits("", true);

        addToInformationVector("Commander", 1);

        power = 8;

        complete();
    }

    @Override
    public void refreshen() {
        if (getCountFromInformationVector("Contingent Headquarters") > 0) {
            if (getCountFromInformationVector("Commander") > 1) {
                setFehlermeldung("Max 1 Commander");
            }
        }

        power = 8;

        if(o5.isSelected()) {
        	power++;
        }
    }

    //@OVERRIDE
    @Override
	public void deleteYourself() {
        super.deleteYourself();
    }

}
