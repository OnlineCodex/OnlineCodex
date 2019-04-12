package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMImperialKnightWarlordtraits extends Eintrag {
	private final OptionsUpgradeGruppe fk1;

    public IMImperialKnightWarlordtraits() {
        name = "Armiger Helverin";
        grundkosten = 0;
        power = 0;

        ogE.addElement(new OptionsGruppeEintrag("Cunning Commander", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Ion Bulwark", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Knight Seneschal", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Landstrider", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Blessed by the Sacristans", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Fearsome Reputation", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Terryn) Champion of the Household", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Grffith) Master of Joust", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Hawkshroud) Duty of the Forsworn", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Cadmus) Veteran of Gyrphonne IV", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Mortan) Legacy of the Black Pall", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Raven) Master of the Trial", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Taranis) Knight of Mars", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Krast) First Knight", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Vulker) Adamantium Knight", getPts("")));
        add(fk1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        this.eintragsCNT = 0;

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        fk1.alwaysSelected();
    }
}
