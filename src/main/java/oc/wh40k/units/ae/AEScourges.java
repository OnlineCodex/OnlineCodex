package oc.wh40k.units.ae;

import oc.*;

public class AEScourges extends Eintrag {

    private final AnzahlPanel squad;

    public AEScourges() {
        name = "Scourges";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Scourges", 5, 10, getPts("Scourges"));
        add(squad);

        ogE.addElement(new OptionsGruppeEintrag("Shardcarbine", getPts("Shardcarbine")));
        ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", getPts("Splinter cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Dark lance", getPts("Dark lance")));
        ogE.addElement(new OptionsGruppeEintrag("Heat lance", getPts("Heat lance")));
        ogE.addElement(new OptionsGruppeEintrag("Shredder", getPts("Shredder")));
        ogE.addElement(new OptionsGruppeEintrag("Haywire blaster", getPts("Haywire blaster")));
        ogE.addElement(new OptionsGruppeEintrag("Blaster", getPts("Blaster")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        add(new RuestkammerStarter(ID, randAbstand, cnt, new AESolarite(), "Solarite"));

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 5) {
            power = 10;
        } else {
            power = 6;
        }
    }
}