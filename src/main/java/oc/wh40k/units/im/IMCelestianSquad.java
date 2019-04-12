package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTA_SORORITAS;
import static oc.KeyWord.ADEPTUS_MINISTORUM;
import static oc.KeyWord.CELESTIAN_SQUAD;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.ORDER;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMCelestianSquad extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe bolters;
	private final OptionsZaehlerGruppe special;
	private final OptionsZaehlerGruppe heavy;

    public IMCelestianSquad() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, INFANTRY, CELESTIAN_SQUAD);
        name = "Celestian Squad\n";
        grundkosten = 0;
        applyTitle = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Celestian Squad", 5, 10, getPts("Celestian Squad"));
        add(squad);

        seperator();

        checkBuildaVater();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (AMI)")));
        add(bolters = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addAll(IMAdeptaSororitasRuestkammer.getSpecialWeapons(buildaVater));
        add(special = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addAll(IMAdeptaSororitasRuestkammer.getHeavyWeapons(buildaVater));
        add(heavy = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Simulacrum Imperialis", getPts("Simulacrum Imperialis (AMI)")));

        seperator();

        add(createTroopChampion(IMAdeptaSororitasRuestkammer.class, true, "Upgrade zur Prioris", "Sister Superior"));

        complete();
    }

    @Override
    public void refreshen() {

        if (squad.getModelle() <= 5)
            power = 5;
        else if (squad.getModelle() <= 10)
            power = 7;

        bolters.setMaxAnzahl(squad.getModelle() - 1 - special.getAnzahl() - heavy.getAnzahl());
        bolters.setAnzahl(0, bolters.getMaxAnzahl());
        special.setMaxAnzahl(2 - heavy.getAnzahl());
        heavy.setMaxAnzahl(Math.min(1, 2 - special.getAnzahl()));
    }

}
