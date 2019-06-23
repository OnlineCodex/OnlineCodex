package oc.wh40k.units.ta;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TACommanderinXV84CrisisBattlesuit extends Eintrag {

	private final OptionsZaehlerGruppe o5;

    public TACommanderinXV84CrisisBattlesuit() {
    	super(TAU_EMPIRE, BATTLESUIT, CHARACTER, XV84_CRISIS, JET_PACK, COMMANDER);

        name = "Commander in XV84 Crisis Battlesuit";
        grundkosten = getPts("Commander in XV84 Crisis Battlesuit");
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

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        power = 6;
        if (o5.isSelected()) {
            power++;
        }
        
        setUnikat(true);
    }

}

