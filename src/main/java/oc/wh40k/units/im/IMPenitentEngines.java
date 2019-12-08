package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_MINISTORUM;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.PENITENT_ENGINES;
import static oc.KeyWord.VEHICLE;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMPenitentEngines extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe flails;

    public IMPenitentEngines() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, VEHICLE, PENITENT_ENGINES);
        name = "Penitent Engines";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Penitent Engines", 1, 6, getPts("Penitent Engines") + getPts("Heavy flamer (AMI)") * 2);
        add(squad);

        ogE.addElement(new OptionsGruppeEintrag("Penitent flails", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Penitent buzz-blades", getPts("")));
        add(flails = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        flails.setAnzahl(0, 2);
        
        complete();
    }

    @Override
    public void refreshen() {
        power = squad.getModelle() * 3;
        flails.setMaxAnzahl(2*squad.getModelle());
    }

}
