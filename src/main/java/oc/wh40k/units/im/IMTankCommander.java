package oc.wh40k.units.im;

import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.LEMAN_RUSS;
import static oc.KeyWord.OFFICER;
import static oc.KeyWord.TANK_COMMANDER;
import static oc.KeyWord.VEHICLE;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMTankCommander extends Eintrag {

	private final OptionsUpgradeGruppe o2;
	private final OptionsEinzelUpgrade oe1;
	private final OptionsEinzelUpgrade oe2;

	public IMTankCommander() {
    	super(CHARACTER, VEHICLE, LEMAN_RUSS, OFFICER, TANK_COMMANDER);

        grundkosten = getPts("Tank Commander");
        name = "Tank Commander";
        power = 13;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AM other)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (AM other)")));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon (AM other)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", getPts("Heavy bolter (AM other)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Heavy flamers", getPts("Heavy flamer (AM other)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Multi-meltas", getPts("Multi-melta (AM other)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Plasma cannons", getPts("Plasma cannon (AM other)") * 2));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (AM)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", getPts("Heavy stubber")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Augur array", getPts("Augur array")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", getPts("Dozer blade")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (AM)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Track guards", getPts("Track guards")));

        seperator();

        addWeapons(IMAstraMilitarumRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {

    	o2.alwaysSelected();

        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());
    }
}
