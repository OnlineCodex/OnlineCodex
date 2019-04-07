package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class IMArmigerHelverin extends Eintrag {
	private final OptionsUpgradeGruppe fk1;
	private final OptionsZaehlerGruppe fk2;
	private final AnzahlPanel squad;

    public IMArmigerHelverin() {
        name = "Armiger Helverin";
        grundkosten = 0;
        power = 9;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Armiger Helverin", 1, 3, getPts("Armiger Helverin"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Armiger autocannons", getPts("Armiger autocannon") * 2));
        add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber (QI)")));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", getPts("Melta gun (QI)")));
        add(fk2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        fk2.setAnzahl(0, 1);

        setInformationVectorValue("Armiger selected", getCountFromInformationVector("Armiger selected") + 1);

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        fk1.alwaysSelected();
        fk2.setMaxAnzahl(squad.getModelle());
        fk2.setLegal(fk2.getAnzahl() == squad.getModelle());

        power = 9 * squad.getModelle();
    }

    //@OVERRIDE
    @Override
	public void deleteYourself() {
        super.deleteYourself();

        setInformationVectorValue("Armiger selected", getCountFromInformationVector("Armiger selected") - 1);
    }
}
