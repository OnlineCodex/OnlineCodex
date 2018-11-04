package oc.wh40k.units.or;

import oc.*;

public class ORGrotTanks extends Eintrag {

    AnzahlPanel GrotTank;
    OptionsEinzelUpgrade Kommanda;
    OptionsZaehlerGruppe KommandaFK;
    OptionsEinzelUpgrade KommandaShoota;
    OptionsZaehlerGruppe GrotTankFK;
    OptionsEinzelZaehler Shoota;
    OptionsEinzelUpgrade RPJ;

    public ORGrotTanks() {

        kategorie = 2;
        grundkosten = 0;
        GrotTank = new AnzahlPanel(ID, randAbstand, cnt, "", "Grot Tanks (FW)", 4, 8, getPts("Grot Tanks"));
        add(GrotTank);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", getPts("Big Shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("Skorcha")));
        ogE.addElement(new OptionsGruppeEintrag("Grotzooka", getPts("Grotzooka")));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", getPts("Rokkit Launcha")));
        ogE.addElement(new OptionsGruppeEintrag("Kustom Mega Blasta", getPts("Kustom Mega Blasta")));
        GrotTankFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
        add(GrotTankFK);

        seperator();

        add(Shoota = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Shoota", GrotTank.getModelle(), getPts("Shoota")));

        seperator();

        add(Kommanda = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kommanda", getPts("Kommanda")));

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", getPts("Big Shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("Skorcha")));
        ogE.addElement(new OptionsGruppeEintrag("Grotzooka", getPts("Grotzooka")));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", getPts("Rokkit Launcha")));
        ogE.addElement(new OptionsGruppeEintrag("Kustom Mega Blasta", getPts("Kustom Mega Blasta")));
        KommandaFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2);
        add(KommandaFK);

        seperator();

        add(KommandaShoota = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Shoota", getPts("Shoota")));

        complete();

    }

    //@OVERRIDE
    public void refreshen() {


        if (!Kommanda.isSelected()) {
            GrotTankFK.setMaxAnzahl(GrotTank.getModelle());
            Shoota.setMaxAnzahl(GrotTank.getModelle());
            GrotTankFK.setLegal(GrotTank.getModelle() == GrotTankFK.getAnzahl());

            KommandaFK.setAktiv(false);
            KommandaShoota.setAktiv(false);

        } else {

            GrotTankFK.setMaxAnzahl(GrotTank.getModelle() - 1);
            Shoota.setMaxAnzahl(GrotTank.getModelle() - 1);
            GrotTankFK.setLegal(GrotTank.getModelle() - 1 == GrotTankFK.getAnzahl());

            KommandaFK.setAktiv(true);
            KommandaShoota.setAktiv(true);

            KommandaFK.setLegal(KommandaFK.getAnzahl() == 2);

        }

        power = 6;
        if (GrotTank.getModelle() > 4) {
            power = 12;
        }
    }
}

