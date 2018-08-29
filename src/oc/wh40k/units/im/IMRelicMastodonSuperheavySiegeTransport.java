package oc.wh40k.units.im;

import oc.Eintrag;

public class IMRelicMastodonSuperheavySiegeTransport extends Eintrag {

	public IMRelicMastodonSuperheavySiegeTransport() {
		name = "Relic Mastodon Super-heavy Siege Transport";
		grundkosten = getPts("Relic Mastodon Super-heavy Siege Transport") + 2*getPts("Heavy flamer") + 2*getPts("Lascannon (IA)") + getPts("Skyreaper battery") + getPts("Siege melta array") + getPts("Crushing tracks");
		power = 44; 
		complete();
	}

	@Override
	public void refreshen() {
	}

}
