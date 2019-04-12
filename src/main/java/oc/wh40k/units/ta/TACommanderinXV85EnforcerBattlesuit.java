package oc.wh40k.units.ta;

import static oc.KeyWord.BATTLESUIT;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.COMMANDER;
import static oc.KeyWord.JET_PACK;
import static oc.KeyWord.TAU_EMPIRE;
import static oc.KeyWord.XV85_ENFORCER;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TACommanderinXV85EnforcerBattlesuit extends Eintrag {

    private final OptionsZaehlerGruppe o5;

    public TACommanderinXV85EnforcerBattlesuit() {
    	super(TAU_EMPIRE, BATTLESUIT, CHARACTER, XV85_ENFORCER, JET_PACK, COMMANDER);

        name = "Commander in XV85 Enforcer Battlesuit";
        grundkosten = getPts("Commander in XV85 Enforcer Battlesuit");
        applyTitle = true;

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        addWeapons(TAKampfanzugKammer.class, true);

        seperator();

		addWarlordTraits("");

        complete();

    }

    @Override
    public void refreshen() {
        power = 7;
        if (o5.isSelected()) {
            power++;
        }
    }

}

