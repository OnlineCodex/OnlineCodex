package oc.wh40k.units.ch;

import oc.*;

public class CHBlightlordTerminators extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe swords, bolter;
	private final OptionsEinzelUpgrade sorcerer;
	private final OptionsUpgradeGruppe sor;
    private final OptionsZaehlerGruppe schwereWaffe, rak;
    private final OptionsUpgradeGruppe stave;

    public CHBlightlordTerminators() {
        //name = "Thousand Sons\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Blightlord Terminators", 5, 10, getPts("Blightlord Terminators"));
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Balesword", getPts("Balesword")));
        ogE.addElement(new OptionsGruppeEintrag("Bubotic axe", getPts("Bubotic axe")));
        add(swords = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        swords.setAnzahl(0, squad.getModelle() - 1);

        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
        add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        bolter.setAnzahl(0, squad.getModelle() - 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Plague spewer", getPts("Plague spewer")));
        ogE.addElement(new OptionsGruppeEintrag("Reaper autocannon", getPts("Reaper autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Blight launcher", getPts("Blight launcher")));
        add(schwereWaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flail of curruption", getPts("Flail of curruption")));
        add(rak = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(sorcerer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blightlord Champion", getPts("Blightlord Champion")));
        sorcerer.setSelected(true);
        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
        add(stave = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        stave.setSelected(0, true);
        ogE.addElement(new OptionsGruppeEintrag("Balesword", getPts("Balesword")));
        ogE.addElement(new OptionsGruppeEintrag("Bubotic axe", getPts("Bubotic axe")));
        add(sor = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        sor.setSelected(0, true);

        complete();
    }

    @Override
    public void refreshen() {

        swords.setMaxAnzahl(squad.getModelle() - 1 - rak.getAnzahl());
        bolter.setMaxAnzahl(squad.getModelle() - 1 - schwereWaffe.getAnzahl() - rak.getAnzahl());
        //bolter.setAnzahl(0, squad.getModelle()-schwereWaffe.getAnzahl());

        sorcerer.setSelected(true);

        int modelle = squad.getModelle() + 1;

        if (modelle >= 5) {
            schwereWaffe.setMaxAnzahl(modelle / 5);
            rak.setMaxAnzahl(modelle / 5);
        }

        power = 13 +
                ((squad.getModelle() == 10) ? 11 : 0);
    }
}
