package morlaistidedata;

import PamController.PamControlledUnit;
import PamguardMVC.PamProcess;

/**
 * Simple module that allows the display of Morlais tide data on the 
 * PAMGuard map
 * @author dg50
 *
 */
public class MorlaisTideControl extends PamControlledUnit {
	
	public static final String unitType = "Morlais Tides";
	
	public MorlaisTideControl( String unitName) {
		super(unitType, unitName);
		addPamProcess(new MorlaisTideProcess(this));
	}
	
	private class MorlaisTideProcess extends PamProcess {

		private MorlaisTideDataBlock tideDataBlock;

		public MorlaisTideProcess(MorlaisTideControl tideControl) {
			super(tideControl, null);
			tideDataBlock = new MorlaisTideDataBlock(this);
			tideDataBlock.SetLogging(new MorlaisTideLogging(tideDataBlock));
			tideDataBlock.setOverlayDraw(new MorlaisTideOverlayDraw(tideControl));
			addOutputDataBlock(tideDataBlock);
		}

		@Override
		public void pamStart() {
		}

		@Override
		public void pamStop() {			
		}
		
	}

}
