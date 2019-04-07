package oc.wh40k.units.ta;

import static oc.KeyWord.BATTLESUIT;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.COMMANDER;
import static oc.KeyWord.JET_PACK;
import static oc.KeyWord.TAU_EMPIRE;
import static oc.KeyWord.XV8_CRISIS;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TACommanderinXV8CrisisBattlesuit extends Eintrag {

	private final OptionsZaehlerGruppe o5;

    public TACommanderinXV8CrisisBattlesuit() {
    	super(TAU_EMPIRE, BATTLESUIT, CHARACTER, XV8_CRISIS, JET_PACK, COMMANDER);

        name = "Commander";
        grundkosten = getPts("Commander in XV8 Crisis Battlesuit");
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "XV8-02 Iridium Battlesuit", getPts("XV8-02 Crisis Iridium battlesuite")));

        seperator();

        addWeapons(TAKampfanzugKammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        power = 7;
        if (o5.isSelected()) {
            power++;
        }
    }

}

