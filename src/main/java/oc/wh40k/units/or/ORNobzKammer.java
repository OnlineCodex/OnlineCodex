package oc.wh40k.units.or;

import oc.*;

public class ORNobzKammer extends RuestkammerVater {

    private final AnzahlPanel Bosse;
    private final OptionsEinzelUpgrade Bossbikaz;
    private final OptionsZaehlerGruppe BosseCC;
    private final OptionsZaehlerGruppe BosseFK;
    private final OptionsEinzelUpgrade Panzarüstung;
    private final OptionsEinzelZaehler Trophäenstange;
    private final OptionsEinzelZaehler Munigrotz;
    private final RuestkammerStarter PikkUp;
    private final RuestkammerStarter Kampfpanza;

    public ORNobzKammer() {
        grundkosten = 0;

        Bosse = new AnzahlPanel(ID, randAbstand, cnt, "Nobz", 3, 10, 18);
        add(Bosse);

        add(ico = new oc.Picture("oc/wh40k/images/Bosse.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Fette Spalta", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiekrallä", 25));
        BosseCC = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
        add(BosseCC);

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Wumme", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Wumme", 3));
        ogE.addElement(new OptionsGruppeEintrag("Bazzukka-Kombi", 5));
        ogE.addElement(new OptionsGruppeEintrag("Gitbrenna-Kombi", 10));
        BosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
        add(BosseFK);

        seperator(5);

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Waaaghbanner", 20));

        seperator(5);

        add(Trophäenstange = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Trophäenstange", Bosse.getModelle(), 5));
        add(Munigrotz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Munigrotz", Bosse.getModelle(), 3));

        seperator(5);

        add(Panzarüstung = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzarüstungen", 4, Bosse.getModelle()));
        add(Bossbikaz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bossbikaz", 27, Bosse.getModelle()));

        seperator();

        PikkUp = new RuestkammerStarter(ID, randAbstand, cnt, new ORTrukkKammer(), "Trukk");
        add(PikkUp);

        Kampfpanza = new RuestkammerStarter(ID, randAbstand, cnt, new ORFahrzeugruestkammer(), "Battlewagon");
        add(Kampfpanza);

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        Bossbikaz.setAktiv(!Panzarüstung.isSelected());
        Panzarüstung.setAktiv(!Bossbikaz.isSelected());

        BosseFK.setMaxAnzahl(Bosse.getModelle());
        BosseCC.setMaxAnzahl(Bosse.getModelle());
        Panzarüstung.setModelle(Bosse.getModelle());
        Trophäenstange.setMaxAnzahl(Bosse.getModelle());
        Munigrotz.setMaxAnzahl(Bosse.getModelle());

        Bossbikaz.setModelle(Bosse.getModelle());

        PikkUp.setAktiv(!Kampfpanza.isSelected() && !Bossbikaz.isSelected());
        Kampfpanza.setAktiv(!PikkUp.isSelected() && !Bossbikaz.isSelected());
        Kampfpanza.getPanel().setLocation((int) Kampfpanza.getPanel().getLocation().getX(), (int) PikkUp.getPanel().getLocation().getY() + PikkUp.getPanel().getSize().height);
    }
}