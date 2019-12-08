package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTA_SORORITAS;
import static oc.KeyWord.ADEPTUS_MINISTORUM;
import static oc.KeyWord.DOMINION_SQUAD;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.ORDER;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMDominionSquad extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe bolters;
	private final OptionsZaehlerGruppe special;
	private final OptionsEinzelUpgrade simulacrum;

    public IMDominionSquad() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, INFANTRY, DOMINION_SQUAD);
        name = "Dominion Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Dominion Squad", 5, 10, getPts("Dominion Squad"));
        add(squad);

        seperator();

        checkBuildaVater();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (AMI)")));
        add(bolters = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addAll(IMAdeptaSororitasRuestkammer.getSpecialWeapons(buildaVater));
        add(special = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(simulacrum = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Simulacrum Imperialis", getPts("Simulacrum Imperialis (AMI)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Incensor-Cherub", getPts("Incensor-Cherub")));
        
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

        bolters.setMaxAnzahl(squad.getModelle() - 1 - special.getAnzahl());
        bolters.setAnzahl(0, bolters.getMaxAnzahl());
        special.setMaxAnzahl(Math.min(4, squad.getModelle() - 1 - (simulacrum.isSelected() ? 1 : 0)));
    }

}
